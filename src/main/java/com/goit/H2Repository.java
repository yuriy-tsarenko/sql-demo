package com.goit;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class H2Repository implements AutoCloseable {
    private final Driver driver = new Driver();
    private Connection connection;
    private Statement statement;

    public H2Repository(String url) throws SQLException {
        DriverManager.registerDriver(driver);
        openConnection(url, null, null);
    }

    public H2Repository(String url, String username, String password) throws SQLException {
        DriverManager.registerDriver(driver);
        openConnection(url, username, password);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    public int executeUpdate(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    public boolean execute(String sql) throws SQLException {
        return statement.execute(sql);
    }

    private void openConnection(String url, String username, String password) throws SQLException {
        Objects.requireNonNull(url);
        if (Objects.isNull(username) && Objects.isNull(password)) {
            connection = DriverManager.getConnection(url);
        } else {
            connection = DriverManager.getConnection(url, username, password);
        }
        statement = connection.createStatement();
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
