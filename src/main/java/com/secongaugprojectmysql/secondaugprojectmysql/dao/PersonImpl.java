package com.secongaugprojectmysql.secondaugprojectmysql.dao;

import com.secongaugprojectmysql.secondaugprojectmysql.model.Person;
import com.secongaugprojectmysql.secondaugprojectmysql.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by abhi on 26/08/18.
 */

@Repository
public class PersonImpl implements PersonRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> findAllPerson() {

        String sql="select * from person";

        List<Person> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Person.class));

        return list;
    }

    @Override
    public String savePerson(Person p) {

        String sql="insert into person values(?,?,?)";

        jdbcTemplate.update(sql,new Object[]{p.getId(),p.getName(),p.getCity()});
        return "Data saved";
    }

    @Override
    public Person findById(Integer id) {

        String sql="select * from person where id=?";

        Person p=jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Person.class));
        return p;
    }
}
