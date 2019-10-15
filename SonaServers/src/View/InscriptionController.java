package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Model.DBconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class InscriptionController implements MovePages {

    @FXML
    private JFXTextField nom;

    @FXML
    private JFXTextField prenom;

    @FXML
    private JFXTextField usern;

    @FXML
    private JFXPasswordField mdp;
  
    @FXML
    private Label uidexistant;

    @FXML
    void Cancel(ActionEvent event) {
    	goToLogin(event);
    }

    @FXML
    void confirm(ActionEvent event) {
String SQL1="SELECT * from user where userid=?";
    	
    	try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(SQL1);)
    	{
    		
    		ps.setString(1,usern.getText());
    	
    	ResultSet rs=ps.executeQuery();
    	if(rs.next()) uidexistant.setVisible(true);
    	else {
    		String SQL="INSERT into user (nom,prenom,userid,passwd) values(?,?,?,?)";
    		try(PreparedStatement ps1=conn.prepareStatement(SQL);)
        	{
    		ps1.setString(1,nom.getText());
    		ps1.setString(2,prenom.getText());
    		ps1.setString(3,usern.getText());
    		ps1.setString(4,mdp.getText());
    		ps1.execute();
    		Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setContentText("Compte crée avec succés  ");
            alert.showAndWait();
        	goToLogin(event);
    	}}}
    	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        	
    	

    }

}