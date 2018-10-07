package com.adshow.palyer.controller;


import com.adshow.ad.entity.Player;
import com.adshow.core.common.constant.SecurityConstant;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.palyer.service.IPlayerService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wmz
 * @since 2018-08-11
 */
@Slf4j
@RestController
@RequestMapping("/ad/player")
public class PlayerController extends BaseController<Player, IPlayerService> {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private IPlayerService playerService;

    @Override
    protected IPlayerService getBaseService() {
        return playerService;
    }


//    @RequestMapping(value = "/program/{id}.zip", method = RequestMethod.GET)
//    @ApiOperation(value = "获取广告包", notes = "获取广告包")
//    public ResponseEntity<InputStreamResource> get(@PathVariable String id) throws FileNotFoundException {
//        log.info("开始下载" + id + "----");
//
//        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
//        System.out.println("mediaType: " + mediaType);
//
//        File file = new File("D:\\广告包\\" + id + ".zip");
//        System.out.println("md5 is: " + ChecksumHelper.calculateMd5(file));
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//                .contentType(mediaType)
//                .contentLength(file.length())
//                .body(resource);
//    }


    @RequestMapping(value = "/validateToken", method = RequestMethod.GET)
    @ApiOperation(value = "校验AccessToken", notes = "校验AccessToken")
    public ResponseEntity<Result> validateToken(
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        boolean valid = false;
        String token = request.getHeader("accessToken");
        if (StringUtils.isNotBlank(token)) {
            // 解析token
            Claims claims = null;
            try {
                claims = Jwts.parser()
                        .setSigningKey(SecurityConstant.JWT_SIGN_KEY)
                        .parseClaimsJws(token.replace(SecurityConstant.TOKEN_SPLIT, ""))
                        .getBody();
                //获取用户名
                String username = claims.getSubject();
                claims.getExpiration();
                //TODO 校验当前设备的登录状态， 判断设备和用户的关联关系

                valid = true;
            } catch (ExpiredJwtException e) {
                return ResponseEntityBuilder.build(valid, "登录已失效，请重新登录");
            } catch (Exception e) {
                return ResponseEntityBuilder.build(valid, "解析token错误");
            }
        }

        System.out.println("received accessToken ==>" + request.getHeader("accessToken"));
        return ResponseEntityBuilder.build(valid);
    }

}

