package com.adshow.ad.service.impl;

import com.adshow.ad.entity.Program;
import com.adshow.ad.entity.ProgramMaterial;
import com.adshow.ad.mapper.ProgramMapper;
import com.adshow.ad.service.IProgramService;
import com.adshow.core.common.Param.ImgEntity;
import com.adshow.ad.utils.ThumbnailsUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhaoxianbin@163.com
 * @since 2018-08-03
 */
@Service
public class ProgramServiceImpl extends ServiceImpl<ProgramMapper, Program> implements IProgramService {

    @Override
    public void processThumbnails(List<ProgramMaterial> programMaterials) throws IOException {
        ImgEntity a = new ImgEntity();
        a.setImgPath("C:\\Users\\Administrator\\Desktop\\main.png");
        ImgEntity b = new ImgEntity();
        b.setImgPath("C:\\Users\\Administrator\\Desktop\\orange.png");
        b.setLocation(new Integer[]{20,30});
        b.setSize(new Integer[]{20,30});
        ImgEntity c = new ImgEntity();
        c.setImgPath("C:\\Users\\Administrator\\Desktop\\red.png");
        c.setLocation(new Integer[]{20,30});
        c.setSize(new Integer[]{20,30});
        ThumbnailsUtil.programBuild(new Integer[]{100,40},"C:\\Users\\Administrator\\Desktop\\test.png",a,b,c);


    }
}
