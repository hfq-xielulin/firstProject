package com.xll.myProject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xll.myProject.Exception.MyException;
import com.xll.myProject.bean.User;
import com.xll.myProject.dao.userDao;
import com.xll.myProject.enums.codeEnum;
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
			throw new MyException(codeEnum.NULL_NAME);
		if(user.getPwd()==null)
			throw new MyException(codeEnum.NULL_PWD);
		if(dao.findByName(user.getName())!=null)
			throw new MyException(codeEnum.EXIST_NAME);
		else 
		    return dao.save(user);
	}


	@Override
	public User findByName(String name) {
		return dao.findByName(name);
	}

}
