package com.adshow.core.common.Param;

import net.coobird.thumbnailator.geometry.Position;

import java.awt.*;

/**
 * @Author martin
 * @Date 2018/9/14
 */
public class adPosition  implements Position {

    private int x;
    private int y;
    public adPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public Point calculate(int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new Point(x,y);
    }
}
