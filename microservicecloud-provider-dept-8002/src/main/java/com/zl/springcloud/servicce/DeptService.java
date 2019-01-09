package com.zl.springcloud.servicce;

import com.zl.springcloud.dao.DeptMapper;
import com.zl.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    private DeptMapper deptMapper;

    public boolean add(Dept dept)
    {
        return deptMapper.addDept(dept);
    }

    public Dept get(Long id)
    {
        return deptMapper.findById(id);
    }

    public List<Dept> list()
    {
        return deptMapper.findAll();
    }
}
