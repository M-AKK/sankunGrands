package com.akk.service.impl;

import com.akk.bean.Ad;
import com.akk.dao.AdDao;
import com.akk.dto.AdDto;
import com.akk.service.AdService;
import com.akk.util.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AdServiceImpl implements AdService {

	@Autowired
	private AdDao adDao;

	//加载配置路径
	@Value("${adImage.savePath}")
	private String adImageSavePath;

	@Value("${adImage.url}")
	private String adImageUrl;

	@Override
	public boolean add(AdDto adDto) {
		Ad ad = new Ad();
		ad.setTitle(adDto.getTitle());
		ad.setWeight(adDto.getWeight());
		ad.setImgGroupId(adDto.getImgGroupId());
		if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
			String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
			File file = new File(adImageSavePath + fileName);
			//new一个这个文件夹
			File fileFolder = new File(adImageSavePath);
			//判断这个文件夹是否存在
			if (!fileFolder.exists()) {
				//不存在就生成一个这个文件夹
				fileFolder.mkdirs();
			}
			try {
				//transferTo：把imgFileName转移到一个文件，但首先你得自己创建一个文件
				adDto.getImgFile().transferTo(file);
				ad.setImgFileName(fileName);
				adDao.insert(ad);
				return true;
			} catch (IllegalStateException | IOException e) {
				log.info("【上传图片失败】, 图片地址={}",fileName);
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> result = new ArrayList<AdDto>();
        Ad condition = new Ad();
        BeanUtils.copyProperties(adDto, condition);
        List<Ad> adList = adDao.selectByPage(condition);

        for (Ad ad : adList) {
            AdDto adDtoTemp = new AdDto();
            result.add(adDtoTemp);
            adDtoTemp.setImg(adImageUrl + ad.getImgFileName());
            BeanUtils.copyProperties(ad, adDtoTemp);
        }
        return result;
	}

	@Override
	public AdDto getById(Long id) {
		AdDto result = new AdDto();
		Ad ad = adDao.selectById(id);
		BeanUtils.copyProperties(ad, result);
		result.setImg(adImageUrl + ad.getImgFileName());
		return result;
	}

	@Override
	public List<AdDto> selectAll() {
        List<AdDto> result = new ArrayList<>();
        List<Ad> adList = adDao.selectAll();
        for(Ad ad : adList){
            AdDto adDto = new AdDto();
            result.add(adDto);
            adDto.setImg(adImageUrl + ad.getImgFileName());
            BeanUtils.copyProperties(ad, adDto);
        }
		return result;
	}

	@Override
	public boolean modify(AdDto adDto) {
		Ad ad = new Ad();
		BeanUtils.copyProperties(adDto, ad);
		String fileName = null;
		if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
			try {
				fileName = FileUtil.save(adDto.getImgFile(), adImageSavePath);
				ad.setImgFileName(fileName);
			} catch (IllegalStateException | IOException e) {
				log.info("【修改：上传图片失败】，图片地址={}", fileName);
				return false;
			}
		}
		int updateCount = adDao.update(ad);
		if (updateCount != 1) {
			return false;
		}
		/*if (fileName != null) {
			return FileUtil.delete(adImageSavePath + adDto.getImgFileName());
		}*/
		return true;
	}
	
	@Override
	public boolean remove(Long id) {
		Ad ad = adDao.selectById(id);
		int deleteRows = adDao.delete(id);
		FileUtil.delete(adImageSavePath + ad.getImgFileName());
		return deleteRows == 1;
	}
}
