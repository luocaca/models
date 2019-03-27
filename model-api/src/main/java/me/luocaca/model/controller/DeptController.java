package me.luocaca.model.controller;

import me.luocaca.model.entity.Department;
import me.luocaca.model.entity.Employee;
import me.luocaca.model.mapper.DepartmentMapper;
import me.luocaca.model.mapper.EmployeeMapper;
import me.luocaca.model.service.DeptService;
import me.luocaca.model.service.EmpService;
import me.luocaca.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

//    @Autowired
//    DeptService deptService;

//    @Autowired
//    EmployeeMapper employeeMapper;


    @Autowired
    EmpService employeeService;

    @Autowired
    DepartmentMapper departmentMapper;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    @Transactional
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        System.err.println("Inserted successfully");
        System.err.println("---> 1/0 = " + (1 / 0));
        return department;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmpById(id);
    }

    @GetMapping("/employee/add")
    public void addEmp(Employee employee) {
        System.out.println("add" + employee);
        employeeService.insertEmp(employee);
    }


}
