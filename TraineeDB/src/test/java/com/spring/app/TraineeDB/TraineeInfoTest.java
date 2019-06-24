package com.spring.app.TraineeDB;


import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.spring.app.TraineeDB.dao.TraineeInfoDao;
import com.spring.app.TraineeDB.pojo.TraineeInfo;
import com.spring.app.TraineeDB.service.TraineeInfoService;

import org.apache.commons.dbcp2.BasicDataSource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath*:applicationContext.xml")	
public class TraineeInfoTest {
	
	@Autowired
	private TraineeInfoService traineeInfoService;	
	
	// 查询
	@Test
	public void TestSelect() {	

		//根据ID：查询信息
		System.out.println("Select By Id=5: ");
		System.out.println(traineeInfoService.getInfoById(5L));		
//		
		//根据名字：查询信息		
		String name = "你你你";
		System.out.println("Select By Name=" + name + ": ");
		System.out.println(traineeInfoService.getInfoByName(name));		
		
		//根据ID：查询名字
		System.out.println("Select Name By Id=11: ");
		System.out.println(traineeInfoService.getNameById(11L));	
		
		
		//所有名字
		System.out.println("ALL Names: ");
		List<TraineeInfo>names = traineeInfoService.getAllNames();
		System.out.println(names);		
		
		//所有信息
		System.out.println("ALL Infos: ");
		List<TraineeInfo>infos = traineeInfoService.getAllInfos();
		System.out.println(infos);	
		
		
		//所有概览
		System.out.println("Overview: ");
		List<TraineeInfo>overview = traineeInfoService.getOverview();
		System.out.println(overview);		
	}
	
	
	//增
//	@Test	
//	public void TestAdd() {
//		TraineeInfo info_111 = new TraineeInfo();
//		info_111.setTraineeName("我是0618号");
//		info_111.setOnlineId(22000000L);	
//		info_111.setQqNumber(2200000000L);
//		//
//		try {
//			traineeInfoService.addNewInfo(info_111);
//			System.out.println("新增的trainee_id: " + info_111.getTraineeId());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//改
//	@Test
//	public void TestUpdate() {
//		TraineeInfo info_1 = new TraineeInfo();
//		info_1.setTraineeId(16L);
//		info_1.setOnlineId(222666L);
//		info_1.setTraineeName("变为222号");
//		info_1.setQqNumber(2222222292L);
//		info_1.setSlogan("二二二");
//		try {
//			traineeInfoService.updateInfo(info_1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	//删
//	@Test
//	public void TestDelete() throws Exception {
//		traineeInfoService.deleteInfo(13L);
//	}
	

	
		

	
}
