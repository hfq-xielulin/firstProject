package com.xll.myProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xll.myProject.bean.User;

public interface userDao extends JpaRepository<User, Integer> {
	/**
	 * 
	 * @author:xielulin 
	 * @Description:根据姓名密码查询用户
	 * @param name:姓名
	 * @param pwd:密码
	 * @return:用户
	 * @throws:
	 * @date:2017年11月9日 上午11:34:06
	 */
	public User findByNameAndPwd(String name,String pwd);
	/**
	 * 
	 * @author:xielulin 
	 * @Description:根据姓名查询用户
	 * @param name
	 * @return:用户
	 * @throws:
	 * @date:2017年11月9日 下午2:51:29
	 */
	public User findByName(String name);
}
