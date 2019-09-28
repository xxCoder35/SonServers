package View;

import java.sql.Connection;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Model.DBconnection;
import Ressources.ReadConfigProperties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert.AlertType;

public class DBconfigController {
	
	
@FXML
private JFXButton confirm;
@FXML
private JFXButton cancel;
@FXML
private JFXTextField cheminBDD;
@FXML
private JFXTextField user;
@FXML
private JFXPasswordField pwd;
@FXML 
private Label error;



@FXML
protected void Clickconfirm(ActionEvent event)
{
	String url;
	String username;
	String passwd;
	boolean connexionetablie;
	Connection conn = null;
	url=cheminBDD.getText();
	username=user.getText();
	passwd=pwd.getText();
	try {
	Connection con=DBconnection.getConnection();
	
	if(con==null)
    { 
		Alert alert=new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Message d'erreur");
	    alert.setHeaderText("impossible de se connecter � la BDD");
	    alert.setContentText("V�rifiez les informations saisies  :( "); 
	    alert.showAndWait();}
    else {
    	con.close();
    	ReadConfigProperties prop=new ReadConfigProperties();
    	prop.setpropretyvalue("conf.properties","cheminBDD",url);
    	prop.setpropretyvalue("conf.properties","user",username);
    	prop.setpropretyvalue("conf.properties","password",passwd);
    	
    	Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Message");
        alert.setContentText("Informations mise � jour avec succ�s :) ");
        alert.showAndWait();
    }
    }catch(Exception e) {
		Alert alert=new Alert(Alert.AlertType.ERROR);
	    alert.setTitle("Message d'erreur");
	    alert.setHeaderText("impossible de se connecter � la BDD");
	    VBox dialogPaneContent = new VBox();
        Label label = new Label("Stack Trace:");
        TextArea textArea = new TextArea();
        textArea.setText(e.getStackTrace().toString());
        dialogPaneContent.getChildren().addAll(label, textArea);

        alert.getDialogPane().setContent(dialogPaneContent);
	    alert.setContentText("V�rifiez les informations saisies  :( ");
	    alert.showAndWait();
		
	}
   
	
    }


}



