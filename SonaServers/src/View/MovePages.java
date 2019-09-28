package View;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public interface MovePages {
	public default void goToLogin(ActionEvent n)
	{
		Stage primaryStage = (Stage)((Node)n.getSource()).getScene().getWindow();
	
		try {
			Parent root1;
			root1 = FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
			primaryStage.setScene(new Scene(root1,1200,700));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public default void goToDBConfig(ActionEvent n)
	{
		Stage primaryStage = (Stage)((Node)n.getSource()).getScene().getWindow();
	
		try {
			Parent root1;
			root1 = FXMLLoader.load(getClass().getResource("/view/DBconfig.fxml"));
			primaryStage.setScene(new Scene(root1,1200,700));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
