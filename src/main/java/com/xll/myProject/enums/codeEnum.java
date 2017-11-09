package com.xll.myProject.enums;

public enum codeEnum {
	UNKNOW_ERROE(-1,"未知错误"),
	SUCCESS(0,"成功"),
	NULL_NAME(101,"用户名为空"),
	NULL_PWD(0,"密码为空"),
	EXIST_NAME(100,"用户名已存在");
	
	private Integer code;
	
	private String msg;

	private codeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
