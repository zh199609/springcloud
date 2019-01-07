package com.zl.springcloud.entity;

import java.io.Serializable;

public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;
    //来自哪个数据库，因为微服务架构可以服务对应一个数据库，
    private String dbsource;

    public Dept() {
    }

    public Dept(Long deptNo, String deptName, String dbSoruce) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.dbsource = dbSoruce;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDbsource() {
        return dbsource;
    }

    public void setDbsource(String dbsource) {
        this.dbsource = dbsource;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", dbSoruce='" + dbsource + '\'' +
                '}';
    }
}
