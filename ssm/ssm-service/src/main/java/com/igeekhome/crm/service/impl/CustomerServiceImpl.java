package com.igeekhome.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.igeekhome.crm.mapper.CustomerMapper;
import com.igeekhome.crm.pojo.Customer;
import com.igeekhome.crm.service.ICustomerService;
import com.igeekhome.crm.util.Page;
import com.igeekhome.crm.vo.CustomerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Page<Customer> selectCustomersByPage(Long page, Long size, CustomerQueryVo queryVo) {
        //设置分页信息 参数：1.当前页  2.每页条数
        PageHelper.startPage(page.intValue(),size.intValue());

        List<Customer> customers = customerMapper.selectCustomers(queryVo);//会在查询的时候自动加上分页信息

        PageInfo<Customer> pageInfo = new PageInfo<>(customers);
        //直接分页查询，并返回当前分页信息数据（pageInfo），并将当前页数据存放在customer对象中
        //将pagehelper提供的分页封装对象转换成自定义分页page对象
        Page<Customer> pageObj = new Page<>();
        pageObj.setRows(customers);
        pageObj.setPage(page);
        pageObj.setPages((long) pageInfo.getPages());
        pageObj.setSize(size.intValue());
        pageObj.setTotal(pageInfo.getTotal());
        //分页查询
        return pageObj;
    }

    @Override
    public Customer selectCustomerById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer)==1?true:false;
    }


}
