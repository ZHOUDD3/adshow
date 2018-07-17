package com.adshow.common;

import com.adshow.exception.StorageException;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;

public class FileUploadUtil {
    /**
     * 保存文件公共类
     * @param file
     * @param pathId  数据库中的文件路径id
     * @return
     */
    public static boolean store(MultipartFile file,FileTypes type,String pathId) {
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
                Path secondPath = Paths.get(StorageProperties.FILE_ROOT_PATH,type.toString());
                /**
                 * 创建根路径下次级路径
                 */
                if(!Files.exists(secondPath)){
                    Files.createDirectory(secondPath);
                }
                Path filePath = Paths.get(StorageProperties.FILE_ROOT_PATH,type.toString(),pathId);
                if(!Files.exists(filePath)){
                    Files.createDirectory(filePath);
                }
                if(Files.exists(filePath)){
                    Files.copy(inputStream, filePath.resolve(filename),
                            StandardCopyOption.REPLACE_EXISTING);
                }

            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + filename, e);
        }
        return  true;
    }
}
