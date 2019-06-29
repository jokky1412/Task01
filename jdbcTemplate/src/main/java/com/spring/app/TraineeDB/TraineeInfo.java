package com.spring.app.TraineeDB;

public class TraineeInfo {
	
	private long trainee_id;
	private String trainee_name;
	private long qq_number;
	private String practice_type;
	private long reg_time;
	private String college;
	private long online_id;
	private String daily_link;
	private String slogan;
	private String tutor_name;
	private long create_at;
	private long update_at;
	

	public void setTrainee_id(long trainee_id) {
		this.trainee_id = trainee_id;
	}
	public long getTrainee_id() {
		return trainee_id;
	}
	
	public String getTrainee_name() {
		return trainee_name;
	}	
	public void setTrainee_name(String trainee_name) {
		this.trainee_name = trainee_name;
	}
	
	public long getQq_number() {
		return qq_number;
	}
	public void setQq_number(long qq_number) {
		this.qq_number = qq_number;
	}

	
	public String getPractice_type() {
		return practice_type;
	}
	public void setPractice_type(String practice_type) {
		this.practice_type = practice_type;
	}
	
	public long getReg_time() {
		return reg_time;
	}
	public void setReg_time(long reg_time) {
		this.reg_time = reg_time;
	}
	
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	public long getOnline_id() {
		return online_id;
	}
	public void setOnline_id(long online_id) {
		this.online_id = online_id;
	}
	


	public String getDaily_link() {
		return daily_link;
	}
	public void setDaily_link(String daily_link) {
		this.daily_link = daily_link;
	}
	
	
	public String getSlogan() {
		// 判断查询获得的字符串是否为空
		if(slogan==null || slogan=="")
		return "这家伙太懒，什么都没写。";
		else {
			return slogan;
		}		
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getTutor_name() {
		return tutor_name;
	}
	public void setTutor_name(String tutor_name) {
		this.tutor_name = tutor_name;
	}
	
	public long getCreate_at() {
		return create_at;
	}
	public void setCreate_at(long create_at) {
		this.create_at = create_at;
	}
	
	public long getUpdate_at() {
		return update_at;
	}	
	public void setUpdate_at(long update_at) {
		this.update_at = update_at;
	}
	
	public TraineeInfo() {
		
	}
	
	public TraineeInfo(int trainee_id, String trainee_name) {
		this.trainee_id = trainee_id;
		this.trainee_name = trainee_name;
	}
	
	
	@Override
	public String toString() {
		return "\n" 
				+ "学员ID: " + trainee_id + "\n"
				+ "姓名: " + trainee_name + "\n"
				+ "修真类型: " + practice_type + "\n"
				+ "QQ: " + qq_number + "\n"
				+ "报到时间: " + reg_time + "\n"
				+ "毕业院校: " + college + "\n"
				+ "线上学号: " + online_id + "\n"
				+ "入学宣言: " + slogan + "\n"
				+ "师兄: " + tutor_name + "\n"
				+ "日报链接 :" + daily_link + "\n"
				+ "创建时间 :" + create_at + "\n"
				+ "更新时间 :" + update_at + "\n"
				;
	}
	
	public void eat() {
		System.out.println("eat");
	}
	

}
