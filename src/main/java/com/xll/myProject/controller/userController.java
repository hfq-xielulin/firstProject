package com.xll.myProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xll.myProject.bean.Result;
import com.xll.myProject.bean.User;
import com.xll.myProject.service.userServie;
import com.xll.myProject.utils.ResultUtil;

@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	userServie service;
	
	@RequestMapping("/index")
	public ModelAndView loginPage() {
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("form") User user) {
		
		User users=new User();
		users=service.login(user.getName(), user.getPwd());
		if(users!=null)
			return "登录成功，欢迎"+users.getName()+"<br/>您的信息为：<br/>"+users.toString();
		else
			return "登录失败，请重新输入";
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description:增加一个用户
	 * @param name:用户名
	 * @param pwd:密码
	 * @return:用户
	 * @throws Exception 
	 * @throws:
	 * @date:2017年11月9日 下午2:56:45
	 */
	@RequestMapping("add/{name}/{pwd}")
	public Result add(@PathVariable("name")String name,@PathVariable("pwd")String pwd) throws Exception {
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user=service.add(user);
		/*if (name!=null)
			throw new Exception();*/
		return ResultUtil.success(user);
		
	}
	
	/**
	 * 
	 * @author:xielulin 
	 * @Description: 分页查询
	 * @param page: 当前页
	 * @param size: 每页查询数量
	 * @return:
	 * @throws:
	 * @date:2017年11月10日 上午11:44:58
	 */
	@RequestMapping("find/{page}/{size}")
	public Result<User> find(@PathVariable(value="page") Integer page,@PathVariable("size")Integer size) {
		Sort sort=new Sort("id");
		Pageable pageable=new PageRequest(page, size,sort);
		return ResultUtil.success(service.findAll(pageable));
	}
}
