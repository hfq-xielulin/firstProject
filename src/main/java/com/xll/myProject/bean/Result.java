package com.xll.myProject.bean;
/**
 * 
* @ClassName: Result 
* @Description: http请求返回最外层对象
* @author: xielulin
* @param <T>
* @date 2017年11月9日 下午3:25:28
 */
public class Result<T> {
	/**错误码 */
	private Integer code;
	
	/**提示信息*/
	private String msg;
	
	/**具体内容*/
	private T data;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(Integer code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
