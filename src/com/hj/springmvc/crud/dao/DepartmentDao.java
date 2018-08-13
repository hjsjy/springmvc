package com.hj.springmvc.crud.dao;

import com.hj.springmvc.crud.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/7/31
 * @since 1.0.0
 */
@Repository
public class DepartmentDao {
    private  static Map<Integer, Department> departments;
    static {
        departments=new HashMap<>();

        departments.put(101,new Department(101,"D-AA"));
        departments.put(102,new Department(102,"D-BB"));
        departments.put(103,new Department(103,"D-CC"));
        departments.put(104,new Department(104,"D-DD"));

    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    public  Department getDepartment(Integer id){
        return departments.get(id);
    }

}