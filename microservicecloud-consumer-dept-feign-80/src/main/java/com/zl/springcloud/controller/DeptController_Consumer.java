package com.zl.springcloud.controller;

import com.zl.springcloud.entity.Dept;
import com.zl.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptClientService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list() {
        System.out.println("======================");
        return deptClientService.list();
    }

    @RequestMapping(value = "/consumer/dept/test")
    public String test() {
        System.out.println("======================");
        return "sdgfasg";
    }
}
