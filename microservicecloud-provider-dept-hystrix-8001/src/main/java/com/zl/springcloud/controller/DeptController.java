package com.zl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zl.springcloud.entity.Dept;
import com.zl.springcloud.servicce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //一旦条用服务方法失败并抛出错误信息，会自动条用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    //@HystrixCommand(fallbackMethod = "processHystrix_Get")    提到接口上     解耦
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = service.get(id);
        if (dept == null) {
            throw new RuntimeException("该："+id+"没有对应的信息");
        }
        return dept;
    }

    public Dept processHystrix_Get(@PathVariable("id") Long id) {
        Dept dept = new Dept();
        dept.setDeptNo(id);
        dept.setDbsource("no this database in  mysql");
        dept.setDeptName("该:"+id+"没有队形的信息，null---@Hystrix");
        return dept;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        return service.list();
    }

    @RequestMapping(value = "/dept/discovery",method = RequestMethod.GET)
    public DiscoveryClient discoveryClient() {
        List<String> services = discoveryClient.getServices();
        System.out.println("services:"+services);
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVIERCLOUD-PROVIDER-DEPT-8001");
        for(ServiceInstance element:instances){
            System.out.println(element.getHost()+"--"+element.getServiceId()+"--"+element.getUri());
        }
        return discoveryClient;
    }
}
