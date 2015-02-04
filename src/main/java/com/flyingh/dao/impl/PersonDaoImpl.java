package com.flyingh.dao.impl;

import com.flyingh.dao.PersonDao;
import com.flyingh.util.DbUtil;
import com.flyingh.vo.Person;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDaoImpl implements PersonDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtil.getDataSource());
    private Map<String, String> map = new HashMap<String, String>() {
        {
            put("PHONE_NUMBER", "phoneNumber");
        }
    };

    @Override
    public void add(Person person) throws SQLException {
        queryRunner.insert("insert into person(id,name,age,email,birthday,phone_number) values(?,?,?,?,?,?)", new BeanHandler<>(Person.class), person.getId(), person.getName(), person.getAge(), person.getEmail(), person.getBirthday(), person.getPhoneNumber());
    }

    @Override
    public int update(Person person) throws SQLException {
        return queryRunner.update("update person set name=?,age=?,email=?,birthday=?,phone_number=? where id=?", person.getName(), person.getAge(), person.getEmail(), person.getBirthday(), person.getPhoneNumber(), person.getId());
    }

    @Override
    public int delete(int id) throws SQLException {
        return queryRunner.update("delete from person where id=?", id);
    }

    @Override
    public Person find(int id) throws SQLException {
        return queryRunner.query("select * from person where id=?", new BeanHandler<>(Person.class, new BasicRowProcessor(new BeanProcessor(map))), id);
    }

    @Override
    public List<Person> findAll() throws SQLException {
        return queryRunner.query("select * from person", new BeanListHandler<>(Person.class, new BasicRowProcessor(new BeanProcessor(map))));
    }
}
