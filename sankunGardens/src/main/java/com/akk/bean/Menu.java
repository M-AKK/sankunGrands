package com.akk.bean;

import lombok.Data;

/**
 * 后台系统的菜单实体
 */
@Data
public class Menu {
	private Long id;
	private String name;
	private String url;
	private Long parentId;
	private Integer orderNum;
	
}