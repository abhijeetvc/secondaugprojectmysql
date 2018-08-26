package com.secongaugprojectmysql.secondaugprojectmysql.repository;

import com.secongaugprojectmysql.secondaugprojectmysql.model.Person;

import java.util.List;

/**
 * Created by abhi on 26/08/18.
 */
public interface PersonRepo {

    List<Person> findAllPerson();

    String savePerson(Person p);

    Person findById(Integer id);
}
