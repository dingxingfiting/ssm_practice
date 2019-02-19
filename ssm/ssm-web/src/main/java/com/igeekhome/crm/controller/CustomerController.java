package com.igeekhome.crm.controller;

import com.igeekhome.crm.pojo.BaseDict;
import com.igeekhome.crm.pojo.Customer;
import com.igeekhome.crm.service.IBaseDictService;
import com.igeekhome.crm.service.ICustomerService;
import com.igeekhome.crm.util.Page;
import com.igeekhome.crm.vo.CustomerQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Value("${fromTypeCode}")
    private String FROM_TYPE_CODE;
    @Value("${industryTypeCode}")
    private String Industry_TYPE_CODE;
    @Value("${levelType}")
    private String LEVEL_TYPE_CODE;

    @Autowired
    private IBaseDictService baseDictService;

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/list")
    public String customerList(Model model, @RequestParam(defaultValue = "1") Long page,@RequestParam(defaultValue = "20") Long size,CustomerQueryVo queryVo){
        //获取客户来源 客户行业 客户级别相关数据 并进行转发
        List<BaseDict> fromType = baseDictService.selectBaseDictByTypeCode(FROM_TYPE_CODE);//客户来源
        List<BaseDict> industryType = baseDictService.selectBaseDictByTypeCode(Industry_TYPE_CODE);//客户行业
        List<BaseDict> levelType = baseDictService.selectBaseDictByTypeCode(LEVEL_TYPE_CODE);//客户级别

        Page<Customer> pageObj = customerService.selectCustomersByPage(page,size,queryVo);


        model.addAttribute("page",pageObj);
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        model.addAttribute("queryVo",queryVo);

        return "customer";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public Customer edit(Long id){
        return customerService.selectCustomerById(id);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> update(Customer customer){
        Map<String,Object> result = new HashMap<>();
        boolean tag = customerService.updateCustomer(customer);
        if(tag){
            result.put("status",200);//成功给200 失败给300或者其他
            result.put("message","成功");
        }else{
            result.put("status",300);//成功给200 失败给300或者其他
            result.put("message","新增失败");
        }


        return result;
    }
}
