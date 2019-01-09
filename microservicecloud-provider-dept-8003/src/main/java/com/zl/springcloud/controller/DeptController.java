package com.zl.springcloud.controller;

import com.zl.springcloud.entity.Dept;
import com.zl.springcloud.servicce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
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
