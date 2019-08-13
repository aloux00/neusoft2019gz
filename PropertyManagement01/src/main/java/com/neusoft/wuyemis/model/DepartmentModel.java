package com.neusoft.wuyemis.model;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

/*
 * 部门的Model类
 * @Author: 
 */
@Alias("Department")
@Data
public class DepartmentModel implements Serializable{
	private int no=0;
	private String code=null;
	private String name=null;
	private List<EmployeeModel> employees=null;
	
	

}
