package com.spring.app.TraineeDB;

//import java.awt.List;
import java.util.List;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import javax.sql.DataSource;
//import javax.swing.tree.RowMapper;
//
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;



// 注入方法3：继承JdbcDaoSupport
public class TraineeInfoDaoImpl extends JdbcDaoSupport implements TraineeInfoDao {
	
	// 根据ID查询名字
	@Override
	public String SearchTraineeName(long id) {
		String sql = "SELECT trainee_name FROM trainee_info WHERE trainee_id=" + id;
		String name = this.getJdbcTemplate().queryForObject(sql, String.class);
		return name;
	}
	
	// 根据名字查询ID
	@Override
	public long SearchTraineeId(String name) {
		String sql = "SELECT trainee_id FROM trainee_info WHERE trainee_name=" + name;
		// 使用JdbcDaoSupport
		long id = this.getJdbcTemplate().queryForObject(sql, Long.class);
		return id;
	}
	
	// 添加学员
	@Override
	public void AddTrainee(TraineeInfo traineeInfo) {
		String sql = "INSERT INTO trainee_info VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		this.getJdbcTemplate().update(
				sql,
				traineeInfo.getTrainee_id(),
				traineeInfo.getTrainee_name(),
				traineeInfo.getQq_number(),
				traineeInfo.getPractice_type(),
				traineeInfo.getReg_time(),
				traineeInfo.getCollege(),
				traineeInfo.getOnline_id(),
				traineeInfo.getDaily_link(),
				traineeInfo.getSlogan(),
				traineeInfo.getTutor_name(),
				traineeInfo.getCreate_at(),
				traineeInfo.getUpdate_at()
				);
		System.out.println("Created Record: ID=" + traineeInfo.getTrainee_id() + ", 姓名:" + 
				traineeInfo.getTrainee_name() + ", 修真类型:" + traineeInfo.getPractice_type());
	
	}

	// 删除学员信息
	@Override
	public void DeleteTrainee(long id) {
		String sql = "DELETE FROM trainee_info WHERE trainee_id=?";
		this.getJdbcTemplate().update(sql, id);
		System.out.println("删除学员(id=" + id + ")的信息.");
	}

	// 更新学员信息
	@Override
	public void UpdateTrainee(TraineeInfo traineeInfo) {
		String sql = "UPDATE trainee_info SET "
				+ "trainee_name=?,"
				+ "qq_number=?,"
				+ "practice_type=?,"
				+ "reg_time=?,"
				+ "college=?,"
				+ "online_id=?,"
				+ "daily_link=?,"
				+ "slogan=?,"
				+ "tutor_name=?,"
				+ "create_at=?,"
				+ "update_at=?"
				+ " WHERE trainee_id=?";
		this.getJdbcTemplate().update(
				sql,
				traineeInfo.getTrainee_name(),
				traineeInfo.getQq_number(),
				traineeInfo.getPractice_type(),
				traineeInfo.getReg_time(),
				traineeInfo.getCollege(),
				traineeInfo.getOnline_id(),
				traineeInfo.getDaily_link(),
				traineeInfo.getSlogan(),
				traineeInfo.getTutor_name(),
				traineeInfo.getCreate_at(),
				traineeInfo.getUpdate_at(),
				traineeInfo.getTrainee_id()
				);
		System.out.println("更新了学员(id="+traineeInfo.getTrainee_id()+")的信息:");

		String selectSql = "SELECT * from trainee_info WHERE trainee_id=?";

		// 更新后再查询
		List<TraineeInfo> Updatedtrainee = this.getJdbcTemplate().query("SELECT * FROM trainee_info WHERE trainee_id=?",
				new Object[]{traineeInfo.getTrainee_id()},
				new BeanPropertyRowMapper<TraineeInfo>(TraineeInfo.class));
		System.out.println("学员信息 " + traineeInfo.getTrainee_id() + "号: " + "\n" + Updatedtrainee);
		
		
	}

}
