package com.akk.dto;

import com.akk.bean.Ad;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 此Dao也明显的显示出Dto的重要性，有些属性是需要和前端相同而和后端又不同的，需要这个类做转换
 */
@JsonInclude(Include.NON_NULL)
@Data
public class AdDto extends Ad {
    private String img;
    //Springmvc提供的接收文件的属性，用来接收前端的文件
    private MultipartFile imgFile;
}
