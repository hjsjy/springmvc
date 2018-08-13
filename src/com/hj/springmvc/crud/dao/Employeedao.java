package com.hj.springmvc.crud.dao;

import com.hj.springmvc.crud.entity.Department;
import com.hj.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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
public class Employeedao {
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private  DepartmentDao departmentDao;
    static {
        employees=new HashMap<>();
        employees.put(1001,new Employee(1001,"E-AA","aa@163.com",1,new Department(101,"D-AA")));
        employees.put(1002,new Employee(1002,"E-BB","bb@163.com",0,new Department(102,"D-BB")));
        employees.put(1003,new Employee(1003,"E-CC","cc@163.com",0,new Department(103,"D-CC")));
        employees.put(1004,new Employee(1004,"E-DD","ee@163.com",1,new Department(104,"D-DD")));
    }
    private  static  Integer initId=1006;
    public void  save(Employee employee){
        if (employee.getId()== null) {
            employee.setId(initId++);
        }
         employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public  void delete(Integer id){
        employees.remove(id);
    }
    public Employee get(Integer id){
        return  employees.get(id);
    }

}
