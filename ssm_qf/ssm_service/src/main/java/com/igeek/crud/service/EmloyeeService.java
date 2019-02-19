package com.igeek.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igeek.crud.bean.Employee;
import com.igeek.crud.dao.EmployeeMapper;

//emloyeeService
@Service
public class EmloyeeService {

	
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	//封装一个查询所有员工，以及部门的方法。
	public List<Employee> getAll(){
		List<Employee> list = employeeMapper.selectByExampleWithDept(null);
		return list;
	}
	
	//封装一个删除方法 ，根据主键 来删除员工 。
	public void deleteEmp(Integer key){
		employeeMapper.deleteByPrimaryKey(key);
	}
	
}
