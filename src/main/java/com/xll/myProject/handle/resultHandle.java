package com.xll.myProject.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.myProject.Exception.MyException;
import com.xll.myProject.bean.Result;
import com.xll.myProject.utils.ResultUtil;

@ControllerAdvice
public class resultHandle {
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Result handle(Exception e) {
		if(e instanceof MyException) {
			MyException exception=(MyException)e;
			return ResultUtil.error(exception.getCode(), exception.getMessage());
		}else
			return ResultUtil.error(100, e.getMessage());
	}
}
