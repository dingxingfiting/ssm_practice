package com.igeekhome.crm.service;

import com.igeekhome.crm.pojo.BaseDict;

import java.util.List;

public interface IBaseDictService {
    List<BaseDict> selectBaseDictByTypeCode(String type);
}
