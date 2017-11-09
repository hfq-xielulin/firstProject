package com.xll.myProject.Exception;

public class MyException extends RuntimeException {
	
	private Integer code;//错误码

	public MyException(Integer code,String msg) {
		super(msg);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	
	
}
