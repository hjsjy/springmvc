package com.hj.springmvc.crud.handlers;

import com.hj.springmvc.crud.dao.DepartmentDao;
import com.hj.springmvc.crud.dao.Employeedao;
import com.hj.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 黄杰
 * @create 2018/7/31
 * @since 1.0.0
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private Employeedao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @ModelAttribute
    public void getEmployee(@RequestParam(value="id",required = false) Integer id
                            ,Map<String,Object> map){
        if (id != null) {
            map.put("employee",employeeDao.get(id));
        }
    }
    @RequestMapping(value = "/emp",method=RequestMethod.PUT)
    public  String update(Employee employee){
        employeeDao.save(employee);
    return "redirect:/emps";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String input(@PathVariable("id") Integer id,Map<String,Object> map){
        map.put("employee",employeeDao.get(id));
        map.put("departments",departmentDao.getDepartments());
        return "input";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
        public  String save(Employee employee){
        System.out.println("save:"+employee);
            employeeDao.save(employee);
            return "redirect:/emps";
        }
    @RequestMapping(value = "/emp",method = RequestMethod.GET)
    public  String input(Map<String,Object> map){
        map.put("departments",departmentDao.getDepartments());
        map.put("employee",new Employee());
        return "input";
    }
    @RequestMapping("/emps")
    public String list(Map<String, Object> map){
        map.put("employees", employeeDao.getAll());
        return "list";
    }

}