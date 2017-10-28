package com.akk.service;

import com.akk.Vo.ArticleVo;
import com.akk.dto.ArticleDto;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/10 20:35
 */
public interface ArticleService {

    //查询所有文章
    List<ArticleVo> searchByPage(ArticleDto articleDto);

    //修改初始化使用
    ArticleVo getById(Long id);

    //根据父栏目查询文章
    List<ArticleVo> searchFlanmuByPage(ArticleDto articleDto, Long fid);

    //根据子栏目查询文章
    List<ArticleVo> searchZlanmuByPage(ArticleDto articleDto, Long fid, Long zid);

    //前端查询父栏目文章
    List<ArticleVo> ApisearchFlanmu(ArticleDto articleDto, Long fid);

    //前端查询子栏目文章
    List<ArticleVo> ApisearchZlanmu(ArticleDto articleDto, Long fid, Long zid);



    /**
     * 删除广告
     * @param id
     * @return true:删除成功;false:删除失败
     */
    boolean remove(Long id);

    boolean add(ArticleDto articleDto);

    boolean modify(ArticleDto articleDto);
}
