package com.xll.myProject.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String pwd;
	
	private String sex;
	
	private Integer age;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String name, String pwd, String sex, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", age=" + age + "]";
	}
	
	
}