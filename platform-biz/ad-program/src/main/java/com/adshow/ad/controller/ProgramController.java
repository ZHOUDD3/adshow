package com.adshow.ad.controller;


import com.adshow.ad.entity.Program;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.param.ProgramParam;
import com.adshow.ad.service.IProgramMaterialService;
import com.adshow.ad.service.IProgramService;
import com.adshow.common.CheckSumUtil;
import com.adshow.common.FileTypes;
import com.adshow.core.common.controller.BaseController;
import com.adshow.core.common.result.PageResult;
import com.adshow.core.common.result.Result;
import com.adshow.core.common.result.builder.ResponseEntityBuilder;
import com.adshow.palyer.service.IPlayerProgramService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@RestController
@RequestMapping("/ad/program")
public class ProgramController extends BaseController<Program, IProgramService> {

    private static final Logger log = LoggerFactory.getLogger(ProgramController.class);

    @Value("${module.file.rootPath}")
    private String fileRootPath;

    @Autowired
    private IProgramService programService;

    @Autowired
    private IProgramMaterialService programMaterialService;

    @Autowired
    private IPlayerProgramService playerProgramService;

    @Override
    protected IProgramService getBaseService() {
        return programService;
    }

    protected IProgramMaterialService getProgramMaterialService() {
        return programMaterialService;
    }

    protected IPlayerProgramService getPlayerProgramService() {
        return playerProgramService;
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询", notes = "分页查询，支持基本条件筛选")
    public ResponseEntity<PageResult> list(
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int size,
            String name,
            @ApiIgnore HttpServletRequest request,
            @ApiIgnore HttpServletResponse response) {
        Wrapper<Program> wrapper = new EntityWrapper<>();
        wrapper.like("name", name);
        return ResponseEntityBuilder
                .build(getBaseService().selectPage(new Page<Program>(current, size), wrapper));
    }

    /**
     * 新建
     *
     * @param entity 数据实体
     * @return
     */
    @Transactional
    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ApiOperation(value = "新建", notes = "新建节目，前端传参包含节目信息及素材信息（位置，大小等）")
    public ResponseEntity<Result> create(@RequestBody ProgramParam entity) throws IOException {

        getBaseService().creat(entity);
        return ResponseEntityBuilder.build(true);
    }

    /**
     * 新建
     *
     * @param entity 数据实体
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation(value = "新建", notes = "新建节目，前端传参包含节目信息及素材信息（位置，大小等）")
    public ResponseEntity<Result> update(@RequestBody ProgramParam entity) {

        Program program = new Program();
        program.setId(entity.getProgramId());
        program.setName(entity.getName());
        program.setDateShow(entity.getDateShow());
        program.setMusicIds(entity.getMusicIds());
        program.setPreviewImage(entity.getPreviewImage());
        program.setProgramDescription(entity.getProgramDescription());
        program.setProgramDuration(entity.getProgramDuration());
        program.setTemplateImage(entity.getTemplateImage());
        program.setType(entity.getType());
        program.setTextIds(entity.getTextIds());
        program.setVideoIds(entity.getVideoIds());
        program.setWeather(entity.getWeather());
        program.setResolution(entity.getResolution());

        getBaseService().updateById(program);
        List<ProgramMaterial> materials = entity.getMaterials();
        for (ProgramMaterial pm : materials) {
            pm.setProgramId(program.getId());
        }
        getProgramMaterialService().updateAllColumnBatchById(materials);


        return ResponseEntityBuilder.build(true);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation(value = "删除", notes = "根据 ID 删除")
    public ResponseEntity<Result> remove(String[] ids) {

        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                boolean flag = getBaseService().deleteById(id);
                if (flag) {
                    Wrapper<ProgramMaterial> wrapper = new EntityWrapper<>();
                    wrapper.eq("program_id", id);
                    getProgramMaterialService().delete(wrapper);
                }
            }
        }
        return ResponseEntityBuilder.build(true);
    }

    @RequestMapping(value = "view", method = RequestMethod.POST)
    @ApiOperation(value = "节目预览", notes = "根据 ID 预览")
    public ResponseEntity<Result> view(String programId) {

        return ResponseEntityBuilder
                .build(true, getBaseService().getProgramParamById(programId));
    }


    @RequestMapping(value = "/download/{programId}.zip", method = RequestMethod.GET)
    @ApiOperation(value = "获取广告包", notes = "获取广告包")
    public ResponseEntity<InputStreamResource> get(@PathVariable String programId) throws IOException {

        programService.zip(programId);

        StringBuilder builder = new StringBuilder();
        builder.append(fileRootPath)
                .append(FileTypes.PACKAGE).append(File.separator)
                .append("pkg_")
                .append(programId);
        String destZipFile = builder.toString() + ".zip";

        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;
        System.out.println("mediaType: " + mediaType);

        File file = new File(destZipFile);
        System.out.println("md5 is: " + CheckSumUtil.calculateMd5(file));
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                .contentType(mediaType)
                .contentLength(file.length())
                .body(resource);
    }


}

