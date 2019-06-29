package com.spring.app.TraineeDB;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class App
{
    public static void main(String[] args)
    {       
        String config = "beans.xml"; 
    	ApplicationContext ctx = new ClassPathXmlApplicationContext(config);  	
    	JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate_dbcp2");
    	TraineeInfoDao myDao = (TraineeInfoDao)ctx.getBean("myDao");
    	
    	System.out.println( "Hello World!" );
    	
		long id = 2;
		System.out.println("START...");
		List<TraineeInfo> traineeInfoList = jdbcTemplate.query("SELECT * FROM trainee_info WHERE trainee_id=?",
				new Object[]{id},
				new BeanPropertyRowMapper<TraineeInfo>(TraineeInfo.class));
		System.out.println("学员信息 " + id + "号: " + "\n" + traineeInfoList);
		
		((ConfigurableApplicationContext) ctx).close();	
		
		System.out.println("RowMapper END...");   	
		System.out.println("查询结束！");   	
    }
}
