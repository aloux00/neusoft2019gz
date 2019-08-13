package com.neusoft.wuyemis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
/*
 * 员工的Model类
 * @Author: 
 */
@Alias("Employee")
@Data
public class EmployeeModel implements Serializable {
	private String id=null;
	private String password=null;
	private String name=null;
	private String sex=null;
	private int age=0;
	private double salary=0;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday=null;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joinDate=null;
	@JsonIgnore
	private byte[] photo=null;
	private String photoFileName=null;
	private String photoContentType=null;
	private String mail=null;
	//关联的部门
	private DepartmentModel department=null;
	//员工的角色列表
	private List<RoleModel> roles=null;
	

}
