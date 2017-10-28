package com.akk.service.impl;

import com.akk.Vo.ArticleVo;
import com.akk.bean.Ad;
import com.akk.bean.Article;
import com.akk.dao.ApiMenuDao;
import com.akk.dao.ArticleDao;
import com.akk.dto.ArticleDto;
import com.akk.service.ArticleService;
import com.akk.util.DateUtil;
import com.akk.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHM
 * 2017/10/10 21:31
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ApiMenuDao apiMenuDao;

    @Override
    public List<ArticleVo> searchByPage(ArticleDto articleDto) {
        List<ArticleVo> result1 = new ArrayList<>();
        List<ArticleDto> result = new ArrayList<>();
        Article condition = new Article();
        BeanUtils.copyProperties(articleDto, condition);
        List<Article> articleList = articleDao.selectByPage(condition);
        for(Article article1 : articleList){
            ArticleDto articleDtoTemp = new ArticleDto();
            BeanUtils.copyProperties(article1, articleDtoTemp);
            articleDtoTemp.setFname(apiMenuDao.getFmenu(article1.getFid()));
            articleDtoTemp.setZname(apiMenuDao.getZmenu(article1.getFid(), article1.getZid()));
            result.add(articleDtoTemp);
        }
        for(ArticleDto articleDto1 : result){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articleDto1, articleVo);
            articleVo.setUpdateTime(DateUtil.dateFormat2(articleDto1.getUpdateTime(), 0 ,16));
            result1.add(articleVo);
        }
        return result1;
    }

    @Override
    public List<ArticleVo> searchFlanmuByPage(ArticleDto articleDto, Long fid) {
        List<ArticleVo> result1 = new ArrayList<>();
        List<ArticleDto> result = new ArrayList<>();
        Article condition = new Article();
        BeanUtils.copyProperties(articleDto, condition);
        List<Article> articleList = articleDao.selectByfId(condition, fid);
        for(Article article1 : articleList){
            ArticleDto articleDtoTemp = new ArticleDto();
            BeanUtils.copyProperties(article1, articleDtoTemp);
            articleDtoTemp.setFname(apiMenuDao.getFmenu(article1.getFid()));
            articleDtoTemp.setZname(apiMenuDao.getZmenu(article1.getFid(), article1.getZid()));
            result.add(articleDtoTemp);
        }
        for(ArticleDto articleDto1 : result){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articleDto1, articleVo);
            articleVo.setUpdateTime(DateUtil.dateFormat2(articleDto1.getUpdateTime(), 0 ,16));
            result1.add(articleVo);
        }
        return result1;
    }

    @Override
    public List<ArticleVo> searchZlanmuByPage(ArticleDto articleDto, Long fid,  Long zid) {
        List<ArticleVo> result1 = new ArrayList<>();
        List<ArticleDto> result = new ArrayList<>();
        Article condition = new Article();
        BeanUtils.copyProperties(articleDto, condition);
        List<Article> articleList = articleDao.selectByfzId(condition, fid, zid);
        for(Article article : articleList){
            ArticleDto articleDtoTemp = new ArticleDto();
            BeanUtils.copyProperties(article, articleDtoTemp);
            articleDtoTemp.setFname(apiMenuDao.getFmenu(article.getFid()));
            articleDtoTemp.setZname(apiMenuDao.getZmenu(article.getFid(), article.getZid()));
            result.add(articleDtoTemp);
        }
        for(ArticleDto articleDto1 : result){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articleDto1, articleVo);
            articleVo.setUpdateTime(DateUtil.dateFormat2(articleDto1.getUpdateTime(), 0 ,16));
            result1.add(articleVo);
        }
        return result1;
    }

    public List<ArticleVo> ApisearchFlanmu(ArticleDto articleDto, Long fid){
        List<ArticleVo> result1 = new ArrayList<>();
        List<ArticleDto> result = new ArrayList<>();
        Article condition = new Article();
        BeanUtils.copyProperties(articleDto, condition);
        List<Article> articleList = articleDao.selectByfId(condition, fid);
        for(Article article1 : articleList){
            ArticleDto articleDtoTemp = new ArticleDto();
            BeanUtils.copyProperties(article1, articleDtoTemp);
            articleDtoTemp.setFname(apiMenuDao.getFmenu(article1.getFid()));
            articleDtoTemp.setZname(apiMenuDao.getZmenu(article1.getFid(), article1.getZid()));
            result.add(articleDtoTemp);
        }
        for(ArticleDto articleDto1 : result){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articleDto1, articleVo);
            articleVo.setUpdateTime(DateUtil.dateFormat2(articleDto1.getUpdateTime(), 0 ,16));
            result1.add(articleVo);
        }
        return result1;
    }


    public List<ArticleVo> ApisearchZlanmu(ArticleDto articleDto, Long fid,  Long zid){
        List<ArticleVo> result1 = new ArrayList<>();
        List<ArticleDto> result = new ArrayList<>();
        Article condition = new Article();
        BeanUtils.copyProperties(articleDto, condition);
        List<Article> articleList = articleDao.selectByfzId(condition, fid, zid);
        for(Article article : articleList){
            ArticleDto articleDtoTemp = new ArticleDto();
            BeanUtils.copyProperties(article, articleDtoTemp);
            articleDtoTemp.setFname(apiMenuDao.getFmenu(article.getFid()));
            articleDtoTemp.setZname(apiMenuDao.getZmenu(article.getFid(), article.getZid()));
            result.add(articleDtoTemp);
        }
        for(ArticleDto articleDto1 : result){
            ArticleVo articleVo = new ArticleVo();
            BeanUtils.copyProperties(articleDto1, articleVo);
            articleVo.setUpdateTime(DateUtil.dateFormat2(articleDto1.getUpdateTime(), 0 ,16));
            result1.add(articleVo);
        }
        return result1;
    }

    @Override
    public ArticleVo getById(Long id) {
        ArticleVo result = new ArticleVo();
        Article article = articleDao.selectById(id);
        BeanUtils.copyProperties(article, result);
        result.setUpdateTime(DateUtil.dateFormat2(article.getUpdateTime(), 0, 16));
        result.setFname(apiMenuDao.getFmenu(article.getFid()));
        result.setZname(apiMenuDao.getZmenu(article.getFid(), article.getZid()));
        return result;
    }

    @Override
    public boolean remove(Long id) {
        int deleteRows = articleDao.delete(id);
        return deleteRows == 1;
    }

    @Override
    public boolean add(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        int result = articleDao.insert(article);
        return result == 1;
    }

    @Override
    public boolean modify(ArticleDto articleDto) {
        Article article = new Article();
        BeanUtils.copyProperties(articleDto, article);
        int result = articleDao.update(article);
        return result == 1;
    }
}
