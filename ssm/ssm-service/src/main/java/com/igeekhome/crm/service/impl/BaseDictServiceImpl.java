package com.igeekhome.crm.service.impl;

import com.igeekhome.crm.mapper.BaseDictMapper;
import com.igeekhome.crm.pojo.BaseDict;
import com.igeekhome.crm.pojo.BaseDictExample;
import com.igeekhome.crm.service.IBaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseDictServiceImpl implements IBaseDictService {

    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> selectBaseDictByTypeCode(String type) {
        //根据字典类型查询字典数据列表
        BaseDictExample example = new BaseDictExample();
        BaseDictExample.Criteria criteria = example.createCriteria();
        criteria.andDictTypeCodeEqualTo(type);
        return baseDictMapper.selectByExample(example);
    }
}
