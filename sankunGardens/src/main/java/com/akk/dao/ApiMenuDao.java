package com.akk.dao;

import com.akk.bean.ApiMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by KHM
 * 2017/10/1 18:51
 */
public interface ApiMenuDao {

    /**
     * 查询所有前端菜单列表
     * @return
     */
    List<ApiMenu> getMenuList();

    //文章列表页的父、子栏目名显示，只需一个名字的显示
    String getFmenu(@Param("id")Long fid);

    String getZmenu(@Param("parent_id")Long fid, @Param("order_num")Long zid);

    List<ApiMenu> getFApiMenuList();

    //先不写联动，只让选择子栏目，所以这里获得所有子栏目
    List<ApiMenu> getZApiMenuList();

    //查询一条menu，修改用
    ApiMenu selectById(Long id);

    /**
     * 根据主键修改
     * @return 影响行数
     */
    int update(ApiMenu apiMenu);

    /**
     * 根据主键删除
     * @param id 主键
     * @return 影响行数
     */
    int delete(Long id);

    int insert(ApiMenu apiMenu);


}
