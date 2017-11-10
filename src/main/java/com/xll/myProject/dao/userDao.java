package com.xll.myProject.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.xll.myProject.bean.User;

public interface userDao extends JpaRepository<User, Integer>{
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
	 * @Description:分页查询所有用户
	 * @param name
	 * @return:用户
	 * @throws:
	 * @date:2017年11月9日 下午2:51:29
	 */
	public Page<User> findAll(Pageable page);
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 根据姓名查询用户
	 * @param name:用户名
	 * @return: 用户
	 * @throws:
	 * @date:2017年11月10日 上午11:17:01
	 */
	public User findByName(String name);
}
