package com.adshow.aop;

import com.adshow.auth.entity.Log;
import com.adshow.auth.service.ILogService;
import com.adshow.core.common.annotation.SystemLog;
import com.adshow.core.common.utils.IpInfoUtil;
import com.adshow.core.common.utils.ThreadPoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

/**
 * Spring AOP实现日志管理
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    private static final ThreadLocal<Long> beginTime = new NamedThreadLocal<Long>("ThreadLocal-beginTime");

    @Autowired
    private ILogService logService;

    @Autowired(required = false)
    private HttpServletRequest request;

    /**
     * Controller层切点,注解方式
     */
    @Pointcut("execution(* *..controller..*Controller*.*(..))")
    public void controllerAspect() {
    }

    /**
     * 被SystemLog注解标记的方法
     */
    @Pointcut("@annotation(com.adshow.core.common.annotation.SystemLog)")
    public void AnnotationAspect() {
    }

    /**
     * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect() || AnnotationAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {

        //线程绑定变量（该数据只有当前请求的线程可见）
        beginTime.set(System.currentTimeMillis());
    }


    /**
     * 后置通知(在方法执行之后返回) 用于拦截Controller层操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect() || AnnotationAspect()")
    public void after(JoinPoint joinPoint) {
        try {
            String username = null;
            if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
                UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                username = user.getUsername();
            }

            if (StringUtils.isNotBlank(username)) {
                Log log = new Log();
                //日志标题
                log.setName(getControllerMethodDescription(joinPoint));
                //日志请求url
                log.setRequestUrl(request.getRequestURI());
                //请求方式
                log.setRequestType(request.getMethod());
                //请求参数
                Map<String, String[]> logParams = request.getParameterMap();
                log.setMapToParams(logParams);
                //请求用户
                log.setUsername(username);
                //请求IP
                log.setIp(IpInfoUtil.getIpAddr(request));
                //IP地址
                log.setIpInfo(IpInfoUtil.getIpCity(IpInfoUtil.getIpAddr(request)));
                //请求耗时
                Long logElapsedTime = System.currentTimeMillis() - beginTime.get();
                log.setCostTime(logElapsedTime.intValue());

                //调用线程保存
                ThreadPoolUtil.getPool().execute(new SaveSystemLogThread(log, logService));
            }
        } catch (Exception e) {
            log.error("AOP后置通知异常", e);
        }
    }


    /**
     * 保存日志至数据库
     */
    private static class SaveSystemLogThread implements Runnable {

        private Log log;
        private ILogService logService;

        public SaveSystemLogThread(Log esLog, ILogService logService) {
            this.log = esLog;
            this.logService = logService;
        }

        @Override
        public void run() {
            logService.insertOrUpdate(log);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {

        //获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取相关参数
        Object[] arguments = joinPoint.getArgs();
        //生成类对象
        Class targetClass = Class.forName(targetName);
        //获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";

        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] clazzs = method.getParameterTypes();
            if (clazzs.length != arguments.length) {
                //比较方法中参数个数与从切点中获取的参数个数是否相同，原因是方法可以重载哦
                continue;
            }
            description = method.getAnnotation(SystemLog.class)!=null ? method.getAnnotation(SystemLog.class).description() : "";
        }
        return description;
    }

}
