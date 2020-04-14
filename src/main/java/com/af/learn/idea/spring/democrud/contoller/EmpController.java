package com.af.learn.idea.spring.democrud.contoller;

import com.af.learn.idea.spring.democrud.dao.DepartmentDao;
import com.af.learn.idea.spring.democrud.dao.EmployeeDao;
import com.af.learn.idea.spring.democrud.entities.Employee;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author anna
 * @create 2019-12-03 19:05
 */
@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String emps(Model model){
        model.addAttribute("emps",employeeDao.getAll());
        return "list";
    }


    @RequestMapping("/emp")
    public String addEmpPage(Model model){
        model.addAttribute("depts",departmentDao.getDepartments());
        return "emp";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println("=================>emploee:"+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public  String editEmpPage(@PathVariable("id")Integer id,Model model){
        model.addAttribute("depts",departmentDao.getDepartments());
        model.addAttribute("emp",employeeDao.get(id));
        return "emp";
    }

    @PutMapping("/emp/{id}")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
