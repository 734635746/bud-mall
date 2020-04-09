package net.scode.budmall.server.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import net.scode.budmall.server.service.FileService;
import net.scode.commons.exception.ScodeRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * FileService的实现
 *
 * @author liuyoubin
 * @since 2020/4/9 - 19:49
 */
@Service
public class FileServiceImpl implements FileService {

    //保存到本地的路径
    private static final String FILE_PATH = Class.class.getResource("/").getPath() + "static" + File.separator + "file";

    @Override
    public String saveFile(MultipartFile file) {

        //获取原文件名
        String filename = file.getOriginalFilename();
        //获取文件后缀名
        String suffix = filename.substring(filename.lastIndexOf('.'));
        //生成新文件名
        String newFileName = UUID.randomUUID().toString() + suffix;
        //生成文件保存路径
        String newFilePath = FILE_PATH + File.separator + newFileName;
        //文件输入输出缓冲流
        BufferedInputStream is = null;
        BufferedOutputStream os = null;

        //将文件进行保存
        try {
            is = new BufferedInputStream(file.getInputStream());
            os = FileUtil.getOutputStream(newFilePath);
            IoUtil.copy(is, os);
        } catch (IOException e) {
            throw new ScodeRuntimeException("文件保存失败！");
        } finally {
            IoUtil.close(is);
            IoUtil.close(os);
        }

        return newFilePath;
    }
}
