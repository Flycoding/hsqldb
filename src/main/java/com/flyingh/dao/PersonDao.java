package com.flyingh.dao;

import com.flyingh.vo.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    void add(Person person) throws SQLException;

    int update(Person person) throws SQLException;

    int delete(int id) throws SQLException;

    Person find(int id) throws SQLException;

    List<Person> findAll() throws SQLException;
}
