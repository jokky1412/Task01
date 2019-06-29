package com.spring.app.TraineeDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



import org.apache.commons.dbcp2.BasicDataSource;



public class TraineeInfoTest {
	
	private String config = "beans.xml"; 
	private ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
	
//	private String config = "F:/Tools/workspace/TraineeDB/src/main/resources/beans.xml"; 
//	private ApplicationContext ctx = new FileSystemXmlApplicationContext(config);
	
	private JdbcTemplate jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate_dbcp2");
	TraineeInfoDao myDao = (TraineeInfoDao)ctx.getBean("myDao");

	
	
	
	
	// 使用RowMapper
	@Test
	public void testRowMapper() {		
	
		long id = 2;
		System.out.println("START...");
		List<TraineeInfo> traineeInfoList = jdbcTemplate.query("SELECT * FROM trainee_info WHERE trainee_id=?",
				new Object[]{id},
				new BeanPropertyRowMapper<TraineeInfo>(TraineeInfo.class));
		System.out.println("学员信息 " + id + "号: " + "\n" + traineeInfoList);
		
		((ConfigurableApplicationContext) ctx).close();	
		System.out.println("RowMapper END...");
	}

	
	// 查询
	@Test
	public void testTraineeInfoDaoImpl() {	

		long id = 1;
		String name = "'李宣'";
		
		System.out.println("SearchNameResult:" + myDao.SearchTraineeName(id) + " where 学员ID:" + id);
		System.out.println("SearchIDResult:" + myDao.SearchTraineeId(name) + " where 学员姓名:" + name);
		
		((ConfigurableApplicationContext) ctx).close();	
		System.out.println("搜索完成...");
	}
	
	/*
	
	// 增加
	@Test
	public void testAddTrainee() {
		long id = 999;
		TraineeInfo traineeInfo = new TraineeInfo();
		
		traineeInfo.setTrainee_id(id);
		traineeInfo.setTrainee_name("我是新来的");
		traineeInfo.setQq_number(99999999);
		traineeInfo.setPractice_type("JAVA工程师");
		traineeInfo.setReg_time(201811010930L);
		traineeInfo.setCollege("Cambridge");
		traineeInfo.setOnline_id(999);	
		traineeInfo.setDaily_link("www.baidu.com");
		traineeInfo.setSlogan("初来乍到，请多关照。");
		traineeInfo.setTutor_name("任我行");
		traineeInfo.setCreate_at(201811010000L);
		traineeInfo.setUpdate_at(201811010000L);
		
		myDao.AddTrainee(traineeInfo);
		
		List<TraineeInfo> traineeInfoList = jdbcTemplate.query("SELECT * FROM trainee_info WHERE trainee_id=?",
				new Object[]{id},
				new BeanPropertyRowMapper<TraineeInfo>(TraineeInfo.class));
		System.out.println("\n" + "查询新添加的学员信息:" + "\n" + traineeInfoList);
		
		((ConfigurableApplicationContext) ctx).close();	
		System.out.println("添加新学员信息完成...");		
		
	}
	
	
	
	// 删除
	@Test
	public void testDeleteTrainee() {
		long id = 999;
		myDao.DeleteTrainee(id);
		
		((ConfigurableApplicationContext) ctx).close();	
		System.out.println("删除完成...");						
	}
	
	// 更新
	@Test
	public void testUpdateTrainee() {
		long id = 999;
		TraineeInfo traineeInfo = new TraineeInfo();
		
		traineeInfo.setTrainee_id(id);
		traineeInfo.setTrainee_name("贺蕊");
		traineeInfo.setQq_number(666666);
		traineeInfo.setSlogan("老大最帅");
		myDao.UpdateTrainee(traineeInfo);
		
		((ConfigurableApplicationContext) ctx).close();	
		System.out.println("更新完成...");				
	}
	
	*/
	
}
