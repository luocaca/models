package me.luocaca.model.service;


import me.luocaca.model.entity.Person;
import me.luocaca.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import otherservice.OtherService;

import java.util.List;

@Repository
public class PersonService implements PersonMapper {

    @Autowired
    PersonMapper personMapper;



    public int add(Person person) {
        return 0;
    }

    public int delete(long id) {
        return 0;
    }

    public int update(Person person) {
        return 0;
    }

    public List<Person> queryList(int limit, int offset) {
        return personMapper.queryList(limit, offset);
    }

    public Person queryById(long id) {

        return personMapper.queryById(id);
    }
}
