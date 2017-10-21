package com.akk.dao;

import com.akk.bean.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/10 21:27
 */
public interface ArticleDao {

    //就是按照分页过滤器查找所有
    List<Article> selectByPage(Article article);

    /**
     * 根据主键查询文章对象
     */
    Article selectById(Long id);

    //根据父ID查找父栏目文章
    List<Article> selectByfId(Article article, @Param("fid")Long fid);

    //根据父、子ID查找子栏目文章
    List<Article> selectByfzId(Article article, @Param("fid")Long fid, @Param("zid")Long zid);

    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);

    int insert(Article article);

    int update(Article article);
}
