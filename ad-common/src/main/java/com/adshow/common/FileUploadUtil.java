package com.adshow.common;

import com.adshow.exception.StorageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class FileUploadUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUploadUtil.class);

    /**
     * @param file
     * @param type
     * @param pathId
     * @return 存储全路径
     */
    public static String store(MultipartFile file,FileTypes type,String pathId) {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to  emstorepty file " + filename);
            }
            if (filename.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + filename);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Path secondPath = Paths.get(StorageProperties.FILE_ROOT_PATH,type.toString(),pathId);
                /**
                 * 创建根路径下次级路径
                 */
                if(!Files.exists(secondPath)){
                    Files.createDirectories(secondPath);
                }
                if(Files.exists(secondPath)){
                    Path fullPath = secondPath.resolve(filename);
                    Files.copy(inputStream, fullPath,
                            StandardCopyOption.REPLACE_EXISTING);
                    return  fullPath.toString();
                }
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
        return null;
    }

    public static  boolean deleteFile(FileTypes type,String pathId) {
        Path secondPath = Paths.get(StorageProperties.FILE_ROOT_PATH,type.toString(),pathId);
        try {
            Files.deleteIfExists(secondPath);
        } catch (IOException e) {
            log.error("delete file error, type:{}，pathId:{}   " +e);
            return false;
        }
        return true;
    }
}
