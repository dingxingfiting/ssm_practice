package com.igeek.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igeek.crud.bean.Employee;
import com.igeek.crud.bean.Message;
import com.igeek.crud.service.EmloyeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmloyeeService emloyeeService;
	//localhost:8080/ssm?page=1&rows=10
	//对于springmvc而言 向往请求域中添加数据  。源生的servlet对象 。
	@RequestMapping("/list")
	public String empList(@RequestParam(value="page",defaultValue="1") Integer page,@RequestParam(value="rows",defaultValue="5") Integer rows,Map<String,Object> map){
		//page 表示当前页 是第几页  ，rows表示每页显示的条数 。
		PageHelper.startPage(page, rows);
		List<Employee> list = emloyeeService.getAll();
		PageInfo pageInfo = new PageInfo(list,5);
		//会自动的将数据 放到请求域中 。
		map.put("pageInfo", pageInfo);
		return "list";//
	}
	
	//写一个返回json数据的方法 。SSM整合中  想要返回json数据 。 1.导入jar包  。2.springmvc配置文件中 。<mvc:annotation-driven/>  3.在方法的声明位置  加上一个注解 。
	//对于ajax请求而言 ，那么方法定义的返回值类型 ，应该是你要返回的数据的类对象 。  
	/*@ResponseBody
	@RequestMapping("/emps")
	public  PageInfo getAjaxEmp(@RequestParam(value="page",defaultValue="1") Integer page,@RequestParam(value="rows",defaultValue="5") Integer rows){
		PageHelper.startPage(page, rows);
		List<Employee> list = emloyeeService.getAll();
		PageInfo pageInfo = new PageInfo(list,5);
		//会自动的将数据 放到请求域中 。
		return pageInfo;
	}*/
	
	@ResponseBody
	@RequestMapping("/emps")
	public Message getMessageByAjax(@RequestParam(value="page",defaultValue="1") Integer page,@RequestParam(value="rows",defaultValue="5") Integer rows){
		PageHelper.startPage(page, rows);
		List<Employee> list = emloyeeService.getAll();
		PageInfo pageInfo = new PageInfo(list,5);
		//0x5566.
		return Message.getSuccess().putMap("pageInfo", pageInfo);
	}
	//删除的方法 
	@RequestMapping("/delete")
	public String deleteEmp(@RequestParam(value="eid") Integer eid,Map<String,Object> map){
		emloyeeService.deleteEmp(eid);
		PageHelper.startPage(1, 5);
		List<Employee> list = emloyeeService.getAll();
		PageInfo pageInfo = new PageInfo(list,5);
		//会自动的将数据 放到请求域中 。
		map.put("pageInfo", pageInfo);
		return "list";//
		
	}
}
