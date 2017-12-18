package com.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ======================
 * Created By User: RXK
 * Date: 2017/12/18
 * Time: 16:07
 * Version: V1.0
 * Description:
 * ======================
 */
@ApiModel(value = "UserInDTO",description = "用户入参对象")
public class UserInDTO
{
	@ApiModelProperty(value = "当前用户Id")
	private String id ;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
}
