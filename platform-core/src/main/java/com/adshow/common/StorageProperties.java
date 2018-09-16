package com.adshow.common;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class StorageProperties {

    /**
     * Root Folder location for storing files
     */
    public static String FILE_ROOT_PATH = "upload-dir";

    public static String FFMPEG_PATH = "";

    public static String FFPROBE_PATH = "";

}
