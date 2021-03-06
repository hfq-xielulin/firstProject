package com.xll.myProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		if(name==null)
			throw new MyException(codeEnum.NULL_NAME);
		if(pwd==null)
			throw new MyException(codeEnum.NULL_PWD);
		user=dao.findByNameAndPwd(name,pwd);
		if(user==null)
			throw new MyException(codeEnum.NULL_USER);
		else
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


	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}


	

}
