package com.spring.app.TraineeDB.dao;

import java.util.List;

import com.spring.app.TraineeDB.pojo.TraineeInfo;



public interface TraineeInfoDao {

	// myBatis-generator
	// 查
	TraineeInfo selectByPrimaryKey(Long traineeId);
	// 删
    int deleteByPrimaryKey(Long traineeId);   
    // 增
    int insert(TraineeInfo record);
    int insertSelective(TraineeInfo record);  
    // 改
    int updateByPrimaryKeySelective(TraineeInfo record);
    int updateByPrimaryKey(TraineeInfo record);		
		
    
	//查
	//根据名字：查询信息
    TraineeInfo selectInfoByName(String traineeName);	
    //根据ID：查询名字
	String selectNameById(Long traineeId);
	//根据ID：查询QQ
	Long selectQQ_NumberById(Long traineeId);
	
	//列出某个字段的数据
	List<TraineeInfo> listTraineeNames();
	List<TraineeInfo> listSlogans();
	
	//所有信息
	List<TraineeInfo> listTraineeInfos();
	
	//查询概览
	List<TraineeInfo> listOverview();	
	
}
