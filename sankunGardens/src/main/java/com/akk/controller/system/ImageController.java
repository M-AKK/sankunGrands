package com.akk.controller.system;

import com.akk.util.ImageUploadUtil;
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

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public void uploadFile(HttpServletRequest request, HttpServletResponse response) {
        String DirectoryName = "upload/ad";
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}