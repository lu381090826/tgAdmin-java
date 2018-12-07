package cn.tg.wdog.common.controller;

import cn.tg.wdog.common.bean.ResponseCode;
import cn.tg.wdog.common.bean.ResponseResult;
import cn.tg.wdog.common.util.SaveFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@Controller
@RequestMapping("/FileUpload")
public class FileUploadController {

    @ResponseBody
    @RequestMapping(value = "/FileUp", method = RequestMethod.POST)
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file) {
        String fileName;

        try {
            String originFileName = file.getOriginalFilename();
            String ext = originFileName.substring(originFileName.lastIndexOf("."));
            fileName = UUID.randomUUID().toString() + ext;
            SaveFile.saveFile(SaveFile.getRealPath(), fileName, file);
        } catch (Exception ex) {
            return ResponseResult.e(ResponseCode.FAIL, ex.getMessage());
        }

        return ResponseResult.e(ResponseCode.OK, fileName);
    }
}
