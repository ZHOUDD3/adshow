package com.adshow.core.common.controller;

import com.adshow.core.common.entity.BaseEntity;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.mybatis.annotations.QueryCondition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;

@Slf4j
public abstract class BaseController<E extends BaseEntity, T extends IService<E>> {

    protected abstract T getBaseService();


    protected EntityWrapper<E> extractQueryWrapper(E entity) {
        if (entity == null || entity.isEmpty()) {
            return new EntityWrapper<E>();
        }
        EntityWrapper<E> entityWrapper = null;
        try {
            entityWrapper = new EntityWrapper<E>();
            Field fields[] = entity.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (!field.isAnnotationPresent(QueryCondition.class) || field.get(entity) == null || StringUtils.isEmpty(field.get(entity).toString())) {
                    continue;
                }
                QueryCondition queryCondition = field.getAnnotation(QueryCondition.class);
                switch (queryCondition.value()) {
                    case GT:
                        entityWrapper.gt(queryCondition.column(), field.get(entity));
                        break;
                    case GE:
                        entityWrapper.ge(queryCondition.column(), field.get(entity));
                        break;
                    case LT:
                        entityWrapper.lt(queryCondition.column(), field.get(entity));
                        break;
                    case LE:
                        entityWrapper.le(queryCondition.column(), field.get(entity));
                        break;
                    case EQ:
                        entityWrapper.eq(queryCondition.column(), field.get(entity));
                        break;
                    case LIKE:
                        entityWrapper.like(queryCondition.column(), field.get(entity).toString());
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            log.error("error occurs: ", e);
        }
        return entityWrapper;
    }


    /**
     * 分页查询，支持基本条件筛选
     *
     * @param current 当前页码
     * @param size    每页数据量
     * @param entity  筛选条件
     * @return
     */
    @RequestMapping(value = "page", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页码", required = false, defaultValue = "1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页数据量", required = false, defaultValue = "10", dataType = "int", paramType = "query"),
    })
    public ResponseEntity<PageResult> page(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            E entity,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        return ResponseEntityBuilder.build(getBaseService().selectPage(new Page<E>(current, size), extractQueryWrapper(entity)));
    }

    /**
     * 查询单个，根据 ID 查询
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询单个", notes = "查询单个，根据 ID 查询")
    public ResponseEntity<Result> all(@PathVariable long id) {
        return ResponseEntityBuilder.build(true, getBaseService().selectById(id));
    }

    /**
     * 查询全部，支持基本条件筛选
     *
     * @param entity 筛选条件
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询全部", notes = "查询全部，支持基本条件筛选")
    public ResponseEntity<Result> all(E entity) {
        if (entity.isEmpty()) {
            entity = null;
        }
        return ResponseEntityBuilder.build(getBaseService().selectList(new EntityWrapper<E>(entity)));
    }

    /**
     * 查询总数，支持基本条件筛选
     *
     * @param entity 筛选条件
     * @return
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询总数", notes = "查询总数，支持基本条件筛选")
    public ResponseEntity<Result> count(E entity) {
        if (entity.isEmpty()) {
            entity = null;
        }
        return ResponseEntityBuilder.build(getBaseService().selectCount(new EntityWrapper<E>(entity)));
    }

    /**
     * 新建
     *
     * @param entity 数据实体
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "新建", notes = "新建，返回结果包含生成的 ID")
    public ResponseEntity<Result> create(@RequestBody E entity) {
        return ResponseEntityBuilder.build(getBaseService().insert(entity), entity);
    }

    /**
     * 根据 ID 更新
     *
     * @param entity 数据实体
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "更新", notes = "根据 ID 更新")
    public ResponseEntity<Result> update(@RequestBody E entity) {
        return ResponseEntityBuilder.build(getBaseService().updateById(entity));
    }

    /**
     * 根据 ID 逻辑删除
     *
     * @param id ID
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> remove(@PathVariable String id) {
        return ResponseEntityBuilder.build(getBaseService().deleteById(id));
    }


}
