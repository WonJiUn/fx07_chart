package quiz.survey;

import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import quiz.SurveyDTO;

public class Select {
	private Parent root;
	private SurveyDTO dto = new SurveyDTO();
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public String selectPlace() {
		
		
		RadioButton place_out = (RadioButton)root.lookup("#place_out");
		RadioButton place_in = (RadioButton)root.lookup("#place_in");
		RadioButton place_no = (RadioButton)root.lookup("#place_no");
		
		String place;
		
		if(place_out.isSelected()) {
			place = place_out.getText();
		}else if(place_in.isSelected()) {
			place = place_in.getText();
		}else {
			place = place_no.getText();
		}
		
		return place;
		
		
		
	}
	public String selectAge() {
		
		
		
		RadioButton age_10 = (RadioButton)root.lookup("#age_10");
		RadioButton age_20 = (RadioButton)root.lookup("#age_20");
		RadioButton age_30 = (RadioButton)root.lookup("#age_30");
		RadioButton age_40 = (RadioButton)root.lookup("#age_40");
		
		String age;

		if(age_10.isSelected()) {
			age = age_10.getText();
		}else if(age_20.isSelected()) {
			age = age_20.getText();
		}else if(age_30.isSelected()) {
			age = age_30.getText();
		}else {
			age = age_40.getText();
		}
		
		return age;
	}
	public String selectGender() {
		
		RadioButton gender_male = (RadioButton)root.lookup("#gender_male");
		RadioButton gender_female = (RadioButton)root.lookup("#gender_female");
		
		String gender;

		if(gender_male.isSelected()) {
			gender = gender_male.getText();
		}else {
			gender = gender_female.getText();
		}
		return gender;
		
	}
}
