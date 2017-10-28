package com.akk.dto;

import com.akk.bean.User;
import lombok.Data;

@Data
public class UserDto extends User {
    
    private Integer pId;

    private String updateTime1;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}
}