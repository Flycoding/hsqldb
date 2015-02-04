package com.flyingh.util;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class DbUtil {
    private static BasicDataSource dataSource;

    public static final String DRIVER_CLASS_NAME = "org.hsqldb.jdbc.JDBCDriver";
    public static final String URL = "jdbc:hsqldb:hsql://localhost/db";
    public static final String USERNAME = "SA";
    public static final String PASSWORD = "";

    static {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

}
