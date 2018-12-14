package me.luocaca.model.entity;

import java.io.Serializable;

/**
 * 部门
 */
public class Department implements Serializable{

    private Integer id;
    private String departmentName;


    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
