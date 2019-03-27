package me.luocaca.model.service;

import me.luocaca.model.entity.Department;
import me.luocaca.model.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptService implements DepartmentMapper{


    @Autowired
    DepartmentMapper departmentMapper;


    @Override
    public Department getDeptById(Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @Override
    public int deleteDeptById(Integer id) {
        return 0;
    }

    @Override
    public int insertDept(Department department) {
        return 0;
    }

    @Override
    public int updateDept(Department department) {
        return 0;
    }


}
