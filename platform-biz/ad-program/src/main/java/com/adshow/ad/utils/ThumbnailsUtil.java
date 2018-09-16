package com.adshow.ad.utils;

import com.adshow.core.common.Param.ImgEntity;
import com.adshow.core.common.Param.adPosition;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @Author martin
 * @Date 2018/9/13
 */
public class ThumbnailsUtil {

    /**
     * 制作节目信息缩略图
     * @param backSize
     * @param savedPath
     * @param imgs
     * @throws IOException
     */
    public static void programBuild(Integer[] backSize,String savedPath,ImgEntity... imgs) throws IOException {

        if(imgs!=null && imgs.length>0){
            ImgEntity backImg = imgs[0];
            int back_x = backSize[0];
            int back_y = backSize[1];
            Thumbnails.Builder<File> backBuilder = Thumbnails.of(new File(backImg.getImgPath())).size(back_x,back_y);

            if(imgs.length>1){
                for (int i = 1; i <imgs.length ; i++) {
                    int x = imgs[i].getLocation()[0]*back_x/100;
                    int y = imgs[i].getLocation()[1]*back_y/100;
                    int width = imgs[i].getSize()[0]*back_x/100;
                    int height = imgs[i].getSize()[1]*back_y/100;
                    backBuilder = backBuilder.watermark(new adPosition(x,y),ImageIO.read(new File(imgs[i].getImgPath())),1.0f);
                }
            }
            backBuilder.outputQuality(1.0).toFile(savedPath);
        }
    }

}



