package me.luocaca.model.controller;


import me.luocaca.model.entity.Department;
import me.luocaca.model.entity.Employee;
import me.luocaca.model.service.DepartmentService;
import me.luocaca.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;


    // 查看员工列表
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeService.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }


    //员工添加界面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentService.getDepartments();

        model.addAttribute("depts", departments);
        return "emp/add";
    }


    //员工添加接口
    @PostMapping("emp")
    public String addEmp(Employee employee) {
        //
        System.out.println("保存员工信息" + employee);

        employeeService.save(employee);//添加新员工 或者修改员工信息
        //redirect: 表示重定向到一个地址
        //   / 代表当前项目路径
        // forward ： 表示转发到一个地址
        return "redirect:/emps";
    }

    //修改员工信息   。查出当前员工，在界面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeService.get(id);

        model.addAttribute("emp", employee);
        //界面要显示所有的部门列表
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts", departments);

        //回到修改界面（add是一个修改添加二合一的界面）

        return "emp/add";


    }


    //员工修改，需要提交员工id
//    @PutMapping
    public String updateEmployee(Employee employee) {
        System.out.println("修改员工数据" + employee);
        employeeService.save(employee);
        return "redirect:/emps";

    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/emps";
    }





}
