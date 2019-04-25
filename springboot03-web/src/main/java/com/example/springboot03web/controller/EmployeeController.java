package com.example.springboot03web.controller;

import com.example.springboot03web.dao.EmployeeDao;
import com.example.springboot03web.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    //查询员工返回页面
    @GetMapping("/emps")
    public String list(Model model){
        //thymeleaf默认会拼接串
        //classpath:/templeaf/emp/list
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
