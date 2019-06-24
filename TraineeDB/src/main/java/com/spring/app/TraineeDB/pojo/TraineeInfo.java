package com.spring.app.TraineeDB.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class TraineeInfo {
	
    private Long traineeId;

    private String traineeName;

    private Long qqNumber;

    private String practiceType;

    private Long regTime;

    private String college;

    private Long onlineId;

    private String dailyLink;

    private String slogan;

    private String tutorName;

    private Timestamp createAt;

    private Timestamp updateAt;
	
    public Long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }

    public String getTraineeName() {
        return traineeName;
    }

    public void setTraineeName(String traineeName) {
        this.traineeName = traineeName == null ? null : traineeName.trim();
    }

    public Long getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(Long qqNumber) {
        this.qqNumber = qqNumber;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType == null ? null : practiceType.trim();
    }

    public Long getRegTime() {
        return regTime;
    }

    public void setRegTime(Long regTime) {
        this.regTime = regTime;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public Long getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink == null ? null : dailyLink.trim();
    }

    public String getSlogan() {
		// 判断查询获得的字符串是否为空
//		if(slogan==null || slogan=="")
//		return "这家伙太懒，什么都没写。";
//		else {
			return slogan;
//		}	        
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan == null ? null : slogan.trim();
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName == null ? null : tutorName.trim();
    }

    public Timestamp getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Timestamp createAt) {
        this.createAt = createAt;
    }

    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }
    



	
	public TraineeInfo() {
		
	}
	
	public TraineeInfo(Long traineeId, String traineeName) {
		this.traineeId = traineeId;
		this.traineeName = traineeName;
	}
	
	
	@Override
	public String toString() {
		return "\n" 
				+ "学员ID: " + traineeId + "\n"
				+ "姓名: " + traineeName + "\n"
				+ "修真类型: " + practiceType + "\n"
				+ "QQ: " + qqNumber + "\n"
				+ "报到时间: " + regTime + "\n"
				+ "毕业院校: " + college + "\n"
				+ "线上学号: " + onlineId + "\n"
				+ "入学宣言: " + slogan + "\n"
				+ "师兄: " + tutorName + "\n"
				+ "日报链接 :" + dailyLink + "\n"
				+ "创建时间 :" + createAt + "\n"
				+ "更新时间 :" + updateAt + "\n"
				;
	}
	
	public void eat() {
		System.out.println("eat");
	}
	

}
