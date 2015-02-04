package com.flyingh;

import com.flyingh.dao.PersonDao;
import com.flyingh.dao.impl.PersonDaoImpl;
import com.flyingh.util.DbUtil;
import com.flyingh.vo.Person;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;

public class PersonDaoTest {
    private PersonDao dao = new PersonDaoImpl();
    @Test
    public void testAdd() throws SQLException {
        dao.add(new Person(2, "hehe", 22, "hehe@gmail.com", new Date(), RandomStringUtils.random(11, false, true)));
    }

    @Test
    public void testUpdate() throws SQLException {
        Person person = dao.find(1);
        person.setName("haha");
        person.setPhoneNumber("15834124321");
        dao.update(person);
    }

    @Test
    public void testDelete() throws SQLException {
        dao.delete(2);
    }

    @Test
    public void testFind() throws SQLException {
        Person person = dao.find(1);
        System.out.println(person);
    }

    @Test
    public void testFindAll() throws SQLException {
        dao.findAll().forEach(System.out::println);
    }


    @Test
    public void testCreate() throws SQLException {
        QueryRunner queryRunner=new QueryRunner(DbUtil.getDataSource());
        queryRunner.update("create table person(id int primary key,name varchar(20),age int,email varchar(25),birthday datetime,phone_number varchar(11))");
    }

    @Test
    public void testDrop() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DbUtil.getDataSource());
        queryRunner.update("drop table if exists person");
    }
}
