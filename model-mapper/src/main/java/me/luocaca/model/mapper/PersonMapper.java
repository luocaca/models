package me.luocaca.model.mapper;

import me.luocaca.model.entity.Person;
import me.luocaca.model.mapper.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonMapper extends BaseMapper<Person> {

    @Select("SELECT * FROM Person WHERE id = #{id}")
    @Override
    Person queryById(long id);


    @Select("SELECT * FROM Person limit #{limit} offset #{offset} ")
    @Override
    List<Person> queryList(@Param("limit") int limit, @Param("offset") int offset);



}
