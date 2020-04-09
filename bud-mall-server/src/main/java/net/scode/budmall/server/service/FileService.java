package net.scode.budmall.server.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件业务相关的Service
 *
 * @author liuyoubin
 * @since 2020/4/9 - 19:48
 */
public interface FileService {

    /**
     * 保存文件
     *
     * @param file 文件对象
     * @return 文件存储路径
     */
    String saveFile(MultipartFile file);
}
