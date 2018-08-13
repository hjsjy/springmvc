package com.hj.springmvc.crud.entity;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/7/31
 * @since 1.0.0
 */
public class Department {
    private Integer id;
    private String departmentName;

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}