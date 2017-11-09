package com.xll.myProject.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xll.myProject.Exception.MyException;
import com.xll.myProject.bean.Result;
import com.xll.myProject.enums.codeEnum;
import com.xll.myProject.utils.ResultUtil;

@ControllerAdvice
public class resultHandle {
	private final static  Logger log = LoggerFactory.getLogger(resultHandle.class);

	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Result handle(Exception e) {
		if(e instanceof MyException) {
			MyException exception=(MyException)e;
			return ResultUtil.error(exception.getCode(), exception.getMessage());
		}else {
			log.error("【系统异常】",e);
			return ResultUtil.error(codeEnum.UNKNOW_ERROE.getCode(),codeEnum.UNKNOW_ERROE.getMsg());
		}
		}
			
}
