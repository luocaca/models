package me.luocaca.model.service;

import me.luocaca.model.entity.Department;
import me.luocaca.model.entity.Employee;
import me.luocaca.model.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmpService implements EmployeeMapper {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp")
    @Override
    public Employee getEmpById(Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @Override
    public void insertEmp(Employee employee) {

        employeeMapper.insertEmp(employee);
    }







}
