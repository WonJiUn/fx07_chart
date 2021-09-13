package quiz;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.stage.Stage;
import quiz.result.rsOpen;
import quiz.survey.Select;

public class Controller implements Initializable {
	private Parent root;
	public static DBClass db;
	Select sel;
	SurveyDTO dto; 
	rsOpen rs;
	
	public void setRoot(Parent root) {
		this.root = root;
		sel.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new DBClass();
		sel = new Select();
		dto = new SurveyDTO();
		rs = new rsOpen();
	}
	public void Ok() {
		String place;
		String age;
		String gender;
		
		//System.out.println("확인버튼");
		place = sel.selectPlace();
		age = sel.selectAge();
		gender = sel.selectGender();
		
		dto.setPlace(place);
		dto.setAge(age);
		dto.setGender(gender);
		
		int num = db.insert(dto);
		
		if(num == 1) {
			System.out.println("전송성공");
		}else {
			System.out.println("실패");
		}
		
	}
	public void Result() {
		//System.out.println("결과보기");
		rs.resultOpen();
	}
	public void Close() {
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	

}
