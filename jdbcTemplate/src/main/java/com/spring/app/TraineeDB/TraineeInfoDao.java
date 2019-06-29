package com.spring.app.TraineeDB;

import java.awt.List;


public interface TraineeInfoDao {
	// 从学员名字获取学员id
	public long SearchTraineeId(String trainee_name);	
	// 从学员id获取学员名字
	public String SearchTraineeName(long trainee_id);
	

	
	// 新增学员
	public void AddTrainee(TraineeInfo trainee);
	// 移除学员信息
	public void DeleteTrainee(long trainee_id);
	// 更新学员信息
	public void UpdateTrainee(TraineeInfo trainee);
	
	
}
