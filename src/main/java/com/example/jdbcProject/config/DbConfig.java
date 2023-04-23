package com.example.jdbcProject.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbConfig {
	
	@Bean
	public Connection getConnection() {
		
		try {
			
			return	DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbl43","root","Root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
