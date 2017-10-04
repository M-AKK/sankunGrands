package com.akk.service;

import com.akk.dto.AdDto;

import java.util.List;

public interface AdService {
    /**
     * 新增广告
     * @param adDto
     * @return 是否新增成功：true-成功;fale-失败
     */
    boolean add(AdDto adDto);
    
    /**
     * 分页搜索广告列表
     * @param adDto 查询条件(包含分页对象)
     * @return 广告列表
     */
    List<AdDto> searchByPage(AdDto adDto);

    /**
     * 前端查询所有图片,根据权重排值,大的在前
     * @param adDto
     * @return
     */
    List<AdDto> selectAll(AdDto adDto);

    /**
     * 根据主键获取广告的Dto对象，初始化修改页面用的
     * @param id 广告表主键值
     * @return adDto对象
     */
    AdDto getById(Long id);
    
    /**
     * 修改广告
     * @param adDto
     * @return 是否修改成功：true-成功;fale-失败
     */
    boolean modify(AdDto adDto);

    /**
     * 删除广告
     * @param id
     * @return true:删除成功;false:删除失败
     */
    boolean remove(Long id);
}
