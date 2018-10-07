package com.adshow.ad.service;

import com.adshow.ad.entity.Program;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.param.ProgramParam;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.scheduling.annotation.Async;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
public interface IProgramService extends IService<Program> {
    /**
     * 根据素材生成缩略图
     * @param programMaterials
     */
    @Async
    public void processThumbnails(List<ProgramMaterial> programMaterials , String programId ) throws IOException;

    public ProgramParam getProgramParamById(String programId);

    public void creat(ProgramParam pp) throws IOException;

    public void zip(String programId) throws IOException;

    public void deploy(String programId, String... playerIds);
}
