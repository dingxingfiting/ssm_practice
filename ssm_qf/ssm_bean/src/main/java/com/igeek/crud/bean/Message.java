package com.igeek.crud.bean;

import java.util.HashMap;
import java.util.Map;

//封装数据 ，作为数据传输对象 ，将数据封装给前台 。

//DTO  数据传输对象 。    让springMVC 自动帮我们把当前对象转换成json  ...
public class Message {

	//100 表示请求成功   200请求失败 。
	private int code;
	//失败的原因 ;
	private String msg;
	//请求携带的数据 。
	private Map<String,Object> data = new HashMap<>();
	
	//再去添加操作 ，快速的帮你返回两个对象 ，一个表示成功 一个表示失败 。
	public static Message getSuccess(){
		Message message = new Message();
		message.setCode(100);
		message.setMsg("操作成功!");
		return message;
	}
	
	//
	public static Message getFail(){
		Message message = new Message();
		message.setCode(200);
		message.setMsg("操作失败!");
		return message;
	}
	
	
	//再来封装一个支持链式调用的方法 。可以往map中 添加数据的。
	//支持链式调用 ， 可以向map中添加数据 。
	public Message putMap(String key ,Object obj){
		//那个对象 调用方法 ，这个this就代表了 那个对象 。
		this.getData().put(key, obj);
		return this;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
}
