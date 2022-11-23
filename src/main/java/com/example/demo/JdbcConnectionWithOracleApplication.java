package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class JdbcConnectionWithOracleApplication implements CommandLineRunner{

	@Autowired
	public JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(JdbcConnectionWithOracleApplication.class, args);
		System.out.println("this is first application");
	}

	@Override
	public void run(String... args) throws Exception {
	 String sql= "SELECT * FROM Students";
	 List<Student>  students= jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Student.class));
		students.forEach(System.out :: println);
		System.out.println(students.toString());
		System.out.println(students.size());
	}

}
