package me.luocaca.model.mapper;


import me.luocaca.model.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT * FROM  employee WHERE id=#{id}")
    Employee getEmpById(Integer id);


    void insertEmp(Employee employee);


}
