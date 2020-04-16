package net.scode.budmall.server.controller.admapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import net.scode.budmall.server.service.FileService;
import net.scode.commons.core.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * 后台文件管理接口
 *
 * @author liuyoubin
 * @since 2020/4/9 - 19:31
 */
@Slf4j
@Api(tags = {"后台文件管理接口"})
@RestController
@RequestMapping("/admapi/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "上传文件到服务器", notes = "成功则返回文件保存的url地址")
    @PostMapping
    public R uploadFile(
            @ApiParam(name = "file", value = "上传的文件对象", required = true)
            @RequestParam @NotNull(message = "上传文件不能为空") MultipartFile file) {

        //保存文件并返回文件的路径
        String fileUrl = fileService.saveFile(file);
        HashMap<String, Object> map = new HashMap<>();
        map.put("url", fileUrl);
        return R.data(map);
    }

}
