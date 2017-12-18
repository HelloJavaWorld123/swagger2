package com.swagger.controller;

import com.swagger.dto.TestModel;
import com.swagger.dto.UserInDTO;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

/**
 * ======================
 * Created By User: RXK
 * Date: 2017/12/18
 * Time: 15:05
 * Version: V1.0
 * Description:
 * ======================
 */
@Api(value = "TestController",description = "测试Swagger2的Controller")
@RestController
@RequestMapping("/api/add")
public class TestController
{

	@ApiOperation(value = "增加用户",response = TestModel.class,httpMethod = "POST")
	@PostMapping("/user")
//	@ApiImplicitParams({@ApiImplicitParam(name = "id",value = "当前用户Id",required = true)}) 接收多个参数的时候 使用该注解 逐个说面 使用对象接收时 直接再对象中标识
	public void addUser(@RequestBody UserInDTO dto){

	}
}
