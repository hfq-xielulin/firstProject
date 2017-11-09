package com.xll.myProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.myProject.Exception.MyException;
import com.xll.myProject.bean.User;
import com.xll.myProject.dao.userDao;
import com.xll.myProject.service.userServie;
@Service
public class userServiceImpl implements userServie{

	@Autowired
	userDao dao;
	@Override
	public User login(String name, String pwd) {
		User user=new User();
		if(name!=null&&pwd!=null) {
			user=dao.findByNameAndPwd(name,pwd);
		}
		return user;
	}
	
	
	@Override
	public User add(User user) throws Exception {
		if(user.getName()==null)
			throw new MyException(100,"用户名不能为空");
		if(user.getPwd()==null)
			throw new MyException(101,"密码不能为空");
		if(dao.findByName(user.getName())!=null)
			throw new MyException(102,"该用户已存在，请重新注册或直接登录");
		else 
		    return dao.save(user);
	}


	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

}
