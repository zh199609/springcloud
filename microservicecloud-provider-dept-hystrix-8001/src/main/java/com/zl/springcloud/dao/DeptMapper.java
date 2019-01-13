package com.zl.springcloud.dao;

import com.zl.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Insert("INSERT INTO dept(dept_name,db_source) VALUES(#{deptName},DATABASE())")
    public boolean addDept(Dept dept);
    @Select("select * from dept where dept_no=#{id}")
    public Dept findById(Long id);
    @Select("select * from dept")
    public List<Dept> findAll();
}
