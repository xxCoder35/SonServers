import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

import Model.DBconnection;
import Ressources.ReadConfigProperties;
public class Main extends Application {

			@Override
			public void start(Stage primaryStage) throws Exception {
			Parent root =FXMLLoader.load(getClass().getResource("/view/AccPage.fxml"));
			primaryStage.setTitle("Configuration de la base de donnees ");
		    primaryStage.setScene(new Scene(root, 1000, 700));
		    primaryStage.show();
			}
	
	public static void main(String[] args) {
	//	launch(args);
       //System.out.print(DBconnection.BDDconnection("jdbc:mysql://localhost:3306/sonatrach_servers","root","admin"));
	ReadConfigProperties prop=new ReadConfigProperties();
	System.out.print(prop.getpropretyvalue("config.properties","cheminBDD"));
	
	
	}

}
