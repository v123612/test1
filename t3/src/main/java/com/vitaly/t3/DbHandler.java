package com.vitaly.t3;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DbHandler {

    // Константа, в которой хранится адрес подключения
    private static final String CON_STR = "jdbc:sqlite:/home/vitaly/dt_java/vacancies.db";

    // Используем щаблон одиночка, чтобы не плодить множество
    // экземпляров класса DbHandler
    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    // Объект, в котором будет храниться соединение с БД
    private Connection connection;

    private DbHandler() throws SQLException {
        // Регистриуем драйвер, с которым будем работать
        // в нашем случае Sqlite
        DriverManager.registerDriver(new JDBC());
        // Выполняем подключение к базе данных
        this.connection = DriverManager.getConnection(CON_STR);
    }
    
    public void execute(String request) throws SQLException {
    	Statement statement = this.connection.createStatement();
    	ResultSet resultSet = statement.executeQuery("select * from vac");
    	
    	while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));        
        }    	
    	
    	
		
	}
}