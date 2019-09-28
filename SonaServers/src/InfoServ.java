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
            public static Connection  conn;
			public static Connection getConn() {
				return conn;
			}
			public static void setConn(Connection conn) {
				InfoServ.conn = conn;
			}
			@Override
			public void start(Stage primaryStage) throws Exception {
			Parent root =FXMLLoader.load(getClass().getResource("/view/LoginPage.fxml"));
			primaryStage.setTitle("Configuration de la base de donnees ");
		    primaryStage.setScene(new Scene(root, 1000, 700));
		    primaryStage.show();
			}
	
	public static void main(String[] args) {

     //  System.out.print(DBconnection.BDDconnection("jdbc:mysql://127.0.0.1:3306/sonatrach_servers","root","admin"));
	ReadConfigProperties prop=new ReadConfigProperties();
	prop.setpropretyvalue("conf.properties","password","admin");
	prop.setpropretyvalue("conf.properties","cheminBDD","jdbc:mysql://127.0.0.1:3306/sonatrach_servers");
	     prop.setpropretyvalue("conf.properties","user","root");
	     launch(args);
	
	
	
	}

}
