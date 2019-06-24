package com.spring.app.TraineeDB.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.app.TraineeDB.pojo.TraineeInfo;




public interface TraineeInfoService {

	//查
	//根据ID：查询信息
	public TraineeInfo getInfoById(Long traineeId);
	//根据名字：查询信息
	public TraineeInfo getInfoByName(String traineeName);
	//根据ID：查询名字
	public String getNameById(Long traineeId);
	//根据ID：查询QQ
	public Long selectQQ_NumberById(Long traineeId);
	
	//所有名字
	public List<TraineeInfo> getAllNames();
	//所有口号
	public List<TraineeInfo> getAllSlogans();	
	//所有信息
	public List<TraineeInfo> getAllInfos();
	
	//所有信息的概览
	public List<TraineeInfo> getOverview();
	
	
	//增
	public void addNewInfo(TraineeInfo traineeInfo) throws Exception;
	
	//删
	public void deleteInfo(long traineeId);

	//改
	public void updateInfo(TraineeInfo traineeInfo) throws Exception;
	
}
