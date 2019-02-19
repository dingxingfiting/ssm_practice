package com.igeekhome.crm.mapper;

import com.igeekhome.crm.pojo.Customer;
import com.igeekhome.crm.pojo.CustomerExample;
import com.igeekhome.crm.vo.CustomerQueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectCustomers(CustomerQueryVo queryVo);
}