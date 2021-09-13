package quiz.result;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import quiz.DBClass;

public class Controller_result implements Initializable {
	private Parent root;
	PieChart pieChart;
	BarChart barChart;
	AreaChart areaChart;
	DBClass db = new DBClass();
	
	
	public void setRoot(Parent root) {
		this.root = root;
		pieChart = (PieChart)root.lookup("#pieChart");
		barChart = (BarChart)root.lookup("#barChart");
		areaChart = (AreaChart)root.lookup("#areaChart");
		chart();
	}
	public void chart() {
		
		//나이
		int age_10 = db.result_age_10();
		int age_20 = db.result_age_20();
		int age_30 = db.result_age_30();
		int age_40 = db.result_age_40();
		
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("10대", age_10),
				new PieChart.Data("20대", age_20),
				new PieChart.Data("30대", age_30),
				new PieChart.Data("40대", age_40)
				));
		
		
		//성별
		int male = db.result_male();
		int female = db.result_female();
		
		XYChart.Series series1 = new XYChart.Series();
		series1.setName("남자");
		series1.setData(FXCollections.observableArrayList(
				new XYChart.Data("성별 설문조사 비율",male)
				));
		
		XYChart.Series series2 = new XYChart.Series();
		series2.setName("여자");
		series2.setData(FXCollections.observableArrayList(
				new XYChart.Data("성별 설문조사 비율",female)
				));
		
		barChart.getData().add(series1);
		barChart.getData().add(series2);
		
		//지역
		XYChart.Series series3 = new XYChart.Series();
		
		int place_out = db.result_place_out();
		int place_in = db.result_place_in();
		int place_no = db.result_place_no();
		
		series3.setName("가고싶은 여행지");
		series3.setData(FXCollections.observableArrayList(
				new XYChart.Data("해외여행",place_out),
				new XYChart.Data("국내여행",place_in),
				new XYChart.Data("없음",place_no)
				));
		
		areaChart.getData().add(series3);
		
		Label lbl = (Label)root.lookup("#TotalNum");
		lbl.setText(male + female + "");
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
