import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

import Model.DBconnection;
import Ressources.ReadConfigProperties;

public class InfoServ extends Application {
            public Parent root;
			
			
			@Override
			public void start(Stage primaryStage) throws Exception {
			root =FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
			primaryStage.setTitle("Configuration de la base de donnees ");
		    primaryStage.setScene(new Scene(root, 1200, 700));
		    primaryStage.show();
			}
	
	public static void main(String[] args) {

     //  System.out.print(DBconnection.BDDconnection("jdbc:mysql://127.0.0.1:3306/sonatrach_servers","root","admin"));
	/*
	prop.setpropretyvalue("conf.properties","password","admin");

	     prop.setpropretyvalue("conf.properties","user","root");*/
		//ReadConfigProperties prop=new ReadConfigProperties();
		//System.out.println(prop.getpropretyvalue("Ressource/conf.properties","password")+"   "+prop.getpropretyvalue("conf.properties","cheminBDD"));
		launch(args);
		//ReadConfigProperties prop=new ReadConfigProperties();
		/*prop.setpropretyvalue("conf.properties","password","admin");

	     prop.setpropretyvalue("conf.properties","user","root");
		prop.setpropretyvalue("conf.properties","cheminBDD","jdbc:mysql://127.0.0.1:3306/sonatrach_servers");
		System.out.println(prop.getpropretyvalue("conf.properties","password")+"   "+prop.getpropretyvalue("conf.properties","cheminBDD"));*/
	try {
		DBconnection.CloseConnection();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
