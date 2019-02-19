package com.igeekhome.crm.service;

import com.igeekhome.crm.pojo.Customer;
import com.igeekhome.crm.util.Page;
import com.igeekhome.crm.vo.CustomerQueryVo;

public interface ICustomerService {
    //获取当前页数据
    Page<Customer> selectCustomersByPage(Long page, Long size, CustomerQueryVo queryVo);

    Customer selectCustomerById(Long id);

    boolean updateCustomer(Customer customer);
}
