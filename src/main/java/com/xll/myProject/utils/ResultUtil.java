package com.xll.myProject.utils;

import com.xll.myProject.bean.Result;

public class ResultUtil {
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 带内容的返回成功
	 * @param obj: 内容
	 * @return: 结果
	 * @throws:
	 * @date:2017年11月9日 下午4:18:45
	 */
	public static Result success(Object obj) {
		Result result=new Result();
		result.setCode(0);
		result.setMsg("成功");
		result.setData(obj);
		return result;
	}
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 不带内容的返回成功
	 * @return: 结果
	 * @throws:
	 * @date:2017年11月9日 下午4:22:23
	 */
	public static Result success() {
		return success(null);
	}
	
	public static Result error(Integer code,String msg) {
		Result result=new Result();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
}
