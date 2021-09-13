package quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBClass {
	public Connection conn;
	
	public DBClass() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","java2","1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public int insert(SurveyDTO dto) {
		String sql = "insert into survey(place,age,gender) values(?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPlace());
			ps.setString(2, dto.getAge());
			ps.setString(3, dto.getGender());
			
			//전송객체를 이용해서 명령어 실행(DB에 명령어 전송)
			//결과값: 성공 1, 실패 0
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int result_place_out() {
		int place_out = 0;

		String sql = "select * from survey where place=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "해외여행");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				place_out++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setPlace_out(place_out);
		return place_out;
		
		
	}
	public int result_place_in() {
		
		int place_in = 0;
		int place_no = 0;

		String sql = "select * from survey where place=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "국내여행");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				place_in++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setPlace_in(place_in);
		return place_in;
		
		
	}
	public int result_place_no() {
		
		int place_no = 0;

		String sql = "select * from survey where place=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "없음");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				place_no++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setPlace_no(place_no);
		return place_no;
	}
	
	public int result_age_10() {
		int age_10 = 0;
		
		String sql = "select * from survey where age=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "10대");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				age_10++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setAge_10(age_10);
		return age_10;
	}
	public int result_age_20() {
		int age_20 = 0;
		
		String sql = "select * from survey where age=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "20대");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				age_20++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setAge_20(age_20);
		return age_20;
	}
	public int result_age_30() {
		int age_30 = 0;
		
		String sql = "select * from survey where age=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "30대");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				age_30++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setAge_30(age_30);
		return age_30;
	}
	public int result_age_40() {
		int age_40 = 0;
		
		String sql = "select * from survey where age=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "40대");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				age_40++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setAge_40(age_40);
		return age_40;
	}
	public int result_male() {
		int male = 0;
		
		String sql = "select * from survey where gender=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "남성");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				male++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setMale(male);
		return male;
	}
	public int result_female() {
		int female = 0;
		
		String sql = "select * from survey where gender=?";
		SurveyDTO dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "여성");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new SurveyDTO();
				female++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		dto.setFemale(female);
		return female;
	}
}
