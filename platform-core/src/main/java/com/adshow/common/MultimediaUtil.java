package com.adshow.common;

import com.adshow.exception.ParseMediaExcepion;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author martin
 * @Date 2018/7/19
 * @Comment 所媒体文件信息处理类
 */
public class MultimediaUtil {

    /**
     * 获取视频总时间
     * @param video_path    视频路径
     * @param ffmpeg_path	ffmpeg路径
     * @return
     */
    public static Double getVideoTime(String video_path, String ffmpeg_path) {
        List<String> commands = new ArrayList<String>();
        /**
         * 查看多媒体信息命令 ffprobe -v quiet -print_format json -show_format -show_streams ${path}
         */
        commands.add(ffmpeg_path);
        commands.add("-v");
        commands.add("quiet");
        commands.add("-print_format");
        commands.add("json");
        commands.add("-show_format");
        commands.add("-show_streams");
        commands.add(video_path);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commands);
            final Process p = builder.start();

            //从输入流中读取视频信息
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line=null;
            StringBuffer sb=new StringBuffer();
            while ((line=br.readLine())!=null) {
                sb.append(line+"\n");
            }
            JsonParser JParser = new JsonParser() ;
            JsonElement Jelement = JParser.parse(sb.toString());
            double duration = Jelement.getAsJsonObject().getAsJsonObject("format").get("duration").getAsDouble();
            return  duration;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0D;
    }

    //格式:"00:00:10.68"
    private static int getTimelen(String timelen){
        int min=0;
        String strs[] = timelen.split(":");
        if (strs[0].compareTo("0") > 0) {
            min+=Integer.valueOf(strs[0])*60*60;//秒
        }
        if(strs[1].compareTo("0")>0){
            min+=Integer.valueOf(strs[1])*60;
        }
        if(strs[2].compareTo("0")>0){
            min+=Math.round(Float.valueOf(strs[2]));
        }
        return min;
    }


}
