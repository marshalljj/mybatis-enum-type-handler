package com.majian.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jianma on 2017/11/1.
 */
@Mapper
public interface PersonMapper {

    @Select("select * from person")
    List<Person> select();

    @Insert("insert into person values(#{person.id},#{person.name}, #{person.gender})")
    int save(@Param("person") Person person);
}
