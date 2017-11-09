package com.xll.myProject.service;

import org.springframework.stereotype.Service;

import com.xll.myProject.bean.User;
@Service
public interface userServie {
	/**
	 * 
	 * @author:xielulin 
	 * @Description:根据用户名和密码登录
	 * @param name:用户名
	 * @param pwd:密码
	 * @return:用户
	 * @throws:
	 * @date:2017年11月9日 上午11:22:14
	 */
	public User login(String name,String pwd);
	/**
	 * 
	 * @author:xielulin 
	 * @Description:增加一个用户
	 * @param user
	 * @return:用户
	 * @throws Exception 
	 * @throws:
	 * @date:2017年11月9日 下午2:37:27
	 */
	public User add(User user) throws Exception;
	/**
	 * @author:xielulin 
	 * @Description: 根据用户名查询用户
	 * @param name:
	 * @return:用户
	 * @throws:
	 * @date:2017年11月9日 下午2:58:53
	 */
	public User findByName(String name);
	
}
