package com.majian.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jianma on 2017/11/1.
 */
@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public void getAll() {
        List<Person> persons = personMapper.select();
        System.out.println(persons);
    }

    public int save() {
        Person person = new Person();
        person.setId(2);
        person.setName("jj");
        person.setGender(GenderEnum.FEMALE);
        return personMapper.save(person);
    }
}
