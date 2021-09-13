package quiz.result;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class rsOpen {
	public void resultOpen() {
		
		try {
			Stage arg0 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../result.fxml"));
			
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			Controller_result ctl = loader.getController();
			ctl.setRoot(root);
			
			arg0.setScene(scene);
			arg0.show();
			
			
		}catch(Exception e) {
			
		}
	}
}
