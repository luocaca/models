package me.luocaca.model.mapper;


import me.luocaca.model.entity.Department;
import org.apache.ibatis.annotations.*;

/**
 * 指定这是一个操作数据库的mapper
 */
@Mapper
public interface DepartmentMapper {

    @Select("Select * from department where id=#{id}")
    Department getDeptById(Integer id);

    @Delete("Delete from department where id=#{id}")
    int deleteDeptById(Integer id);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("Insert into department(department_name) values(#{departmentName})")
    int insertDept(Department department);


    @Update("Update department set department_name=#{departmentName} where id=#{id}")
    int updateDept(Department department);


}
