package com.akk.controller.system;

import com.akk.util.ImageUploadUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 上传img
 */
@Controller
public class ImageController {

    //加载绝对路径
    @Value("${adImage.savePath}")
    private String adImageSavePath;

    //访问路径
    @Value("${adImage.url}")
    private String adImageUrl;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) {
        try {
            ImageUploadUtil.ckeditor(request, response, adImageSavePath, adImageUrl);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}