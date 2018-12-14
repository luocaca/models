package me.luocaca.model.service;

import me.luocaca.model.entity.Department;
import me.luocaca.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeService {


    /**
     * 模拟整张表
     */
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentService departmentService;

    static {
        //初始化表
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1,
                new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1,
                new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0,
                new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0,
                new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1,
                new Department(105, "D-EE")));


    }


    private static Integer initId = 1006;


    // 增加或者修改表内容
    //表结构----
    public void save(Employee employee) {
        if (employee.getId() == null) {
            //没有此员工信息，新增一个员工
            employee.setId(initId++);
        }
        employee.setDepartment(departmentService.getDepartment(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);


    }

    //查询所有员工
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //根据id 查询一个员工的所有信息，包括部门信息
    public Employee get(Integer id) {
        return employees.get(id);
    }

    //删除一个员工的 信息
    public void delete(Integer id) {
        employees.remove(id);
    }


}
