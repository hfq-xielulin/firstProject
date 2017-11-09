package com.xll.myProject.Exception;

import com.xll.myProject.enums.codeEnum;

public class MyException extends RuntimeException {
	
	private Integer code;//错误码

	public MyException(codeEnum enums) {
		super(enums.getMsg());
		this.code =enums.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	
	
}
