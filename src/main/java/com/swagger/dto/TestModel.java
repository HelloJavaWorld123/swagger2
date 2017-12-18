package com.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * ======================
 * Created By User: RXK
 * Date: 2017/12/18
 * Time: 15:45
 * Version: V1.0
 * Description:
 * ======================
 */
@ApiModel(description = "出参对象",value = "TestModel")
public class TestModel
{
	//name 当前属性的名称(可以不写 默认去当前属性的名称) ;value: 当前属性的中文说明; dataType：当前属性的数据类型(可以不写，默认去取当前属性的数据类型)
	@ApiModelProperty(name = "name",value = "姓名",required = true)
	private String name ;

	@ApiModelProperty(name = "age",value = "年龄",required = true)
	private Integer age ;

	@ApiModelProperty(name = "address",value = "地址",required = true)
	private String addrerss ;


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getAge()
	{
		return age;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getAddrerss()
	{
		return addrerss;
	}

	public void setAddrerss(String addrerss)
	{
		this.addrerss = addrerss;
	}
}
