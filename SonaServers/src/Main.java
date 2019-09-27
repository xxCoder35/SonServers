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
			Parent root =FXMLLoader.load(getClass().getResource("/view/DBconfig.fxml"));
			primaryStage.setTitle("Configuration de la base de donnees ");
		    primaryStage.setScene(new Scene(root, 1000, 700));
		    primaryStage.show();
			}
	
	public static void main(String[] args) {
	//launch(args);
     //  System.out.print(DBconnection.BDDconnection("jdbc:mysql://127.0.0.1:3306/sonatrach_servers","root","admin"));
	ReadConfigProperties prop=new ReadConfigProperties();
	//prop.setpropretyvalue("conf.properties","password","Bonjour");
	//prop.setpropretyvalue("conf.properties","cheminBDD","chemin");
	System.out.println("     "+prop.getpropretyvalue("conf.properties","password"));
	System.out.println("     "+prop.getpropretyvalue("conf.properties","cheminBDD"));
	System.out.println("     "+prop.getpropretyvalue("conf.properties","user"));
	
	}

}
