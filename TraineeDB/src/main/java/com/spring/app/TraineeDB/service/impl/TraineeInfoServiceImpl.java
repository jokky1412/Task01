package com.spring.app.TraineeDB.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.app.TraineeDB.pojo.TraineeInfo;
import com.spring.app.TraineeDB.dao.TraineeInfoDao;
import com.spring.app.TraineeDB.service.TraineeInfoService;

/*
  @Service注解做了两件事：
  1. 声明TraineeInfoService.java是一个bean，这点很重要，
  因为TraineeInfoService.java是一个bean，其他的类才可以使用@Autowired将TraineeInfoService作为一个成员变量自动注入
  2. TraineeInfoService.java在bean中的id是"traineeInfoService"，即类名且首字母小写
*/
@Service("TraineeInfoService")
public class TraineeInfoServiceImpl implements TraineeInfoService{
	
	//定义属性，该属性为1个已存在的bean
	@Resource  //按照名称
	private TraineeInfoDao infoDao;
	
	//查询
	//根据ID：查询信息
	@Override
	public TraineeInfo getInfoById(Long traineeId) {
		return this.infoDao.selectByPrimaryKey(traineeId);
	}
	//根据名字：查询信息
	@Override
	public TraineeInfo getInfoByName(String traineeName) {
		return this.infoDao.selectInfoByName(traineeName);
	}
	//根据ID：查询名字
	@Override
	public String getNameById(Long traineeId) {
		return this.infoDao.selectNameById(traineeId);
	}
	//根据ID：查询QQ	
	public Long selectQQ_NumberById(Long traineeId)	{
		return this.infoDao.selectQQ_NumberById(traineeId);
	}
		
	//所有名字
	@Override
	public List<TraineeInfo> getAllNames() {
		return this.infoDao.listTraineeNames();
	}
	//所有口号
	@Override
	public List<TraineeInfo> getAllSlogans() {
		return this.infoDao.listSlogans();
	}
	//所有信息
	@Override
	public List<TraineeInfo> getAllInfos() {
		return this.infoDao.listTraineeInfos();
	}
	
	//所有信息的概览
	@Override
	public List<TraineeInfo> getOverview() {
		return this.infoDao.listOverview();
	}

	
	//增
	@Override
	public void addNewInfo(TraineeInfo traineeInfo) throws Exception {
		if(traineeInfo.getTraineeName()==null || traineeInfo.getTraineeName().equals("")) {
		throw new Exception("学员名字不能为空");
		}
		else if(traineeInfo.getOnlineId()==0) {
			throw new Exception("线上学号不能为空");
		}
		else if(traineeInfo.getQqNumber()==0) {
			throw new Exception("QQ号不能为空");
		}
		
		//时间戳
		//Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		Timestamp ts_2019 = Timestamp.valueOf("2019-01-01 00:00:00");		
		traineeInfo.setCreateAt(ts_2019);	
		traineeInfo.setUpdateAt(ts_2019);
		
		infoDao.insertSelective(traineeInfo);			
	}

	
	//删
	@Override
	public void deleteInfo(long traineeId) {
		//返回值
		int retDelete = infoDao.deleteByPrimaryKey(traineeId);
		if(retDelete > 0)
		{
			System.out.println("True: Deleted: " + retDelete);
		}
		else
		{
			System.out.println("False: Delete failed");
		}		
	}

	
	//改
	@Override
	public void updateInfo(TraineeInfo traineeInfo) throws Exception {
//		if(traineeInfo.getTraineeName()==null || traineeInfo.getTraineeName().equals("")) {
//		throw new Exception("学员名字不能为空");
//		}
//		else if(traineeInfo.getOnlineId()==0) {
//			throw new Exception("线上学号不能为空");
//		}
//		else if(traineeInfo.getQqNumber()==0) {
//			throw new Exception("QQ号不能为空");
//		}
//		else {
		
		
			//时间戳
			//Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
			Timestamp ts_2019 = Timestamp.valueOf("2019-01-01 00:00:00");		
			traineeInfo.setUpdateAt(ts_2019);			
		
			
//			int returnUpdateRowNum = infoDao.updateByPrimaryKeySelective(traineeInfo);
			int returnUpdateRowNum = infoDao.updateByPrimaryKey(traineeInfo);
			if(returnUpdateRowNum > 0)
			{
				System.out.println("更新信息成功。 Updated: " + returnUpdateRowNum);
			}
			else {
				System.out.println("更新信息失败。 Update failed");
			}
//		}			
	}
	
	

	
	



	
	
}
