package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.DBconnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class HomePageController implements Initializable{
	
	

    @FXML
    private Label Nomconnected;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String nom; 
		String prenom; 
     
     
	       String query = "SELECT nom,prenom FROM `user` WHERE `userid` =? ";
	try (
		       Connection conn=DBconnection.getConnection(); PreparedStatement pr=conn.prepareStatement(query); ){
			
		pr.setString(1,LoginController.getUserConnected());
  
            ResultSet rs = pr.executeQuery();		        
		        if (rs.next()) {
		        	nom= rs.getString(1);
		        	prenom= rs.getString(2);
		      	rs.close();
		Nomconnected.setText(nom+" "+prenom);
		
	}
    
    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
    
}
