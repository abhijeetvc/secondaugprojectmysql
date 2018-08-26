package com.secongaugprojectmysql.secondaugprojectmysql.controller;

import com.secongaugprojectmysql.secondaugprojectmysql.dao.PersonImpl;
import com.secongaugprojectmysql.secondaugprojectmysql.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by abhi on 26/08/18.
 */

@RestController
public class PersonController {

    @Autowired
    private PersonImpl personImpl;

    @RequestMapping(value="/persons")
    public List<Person> getData(){

        List<Person> list=personImpl.findAllPerson();
        return list;
    }

    @PostMapping(value="/savedata")
    public String saveData(@RequestBody Person p){

        String msg=personImpl.savePerson(p);
        return msg;
    }

    @RequestMapping(value="/person/{id}")
    public Person getPerson(@PathVariable Integer id){

        Person p=personImpl.findById(id);
        return p;
    }

}
