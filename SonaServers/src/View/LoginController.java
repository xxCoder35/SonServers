package View;

import java.net.URL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import Model.DBconnection;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LoginController implements Initializable,MovePages {
	@FXML
    private BorderPane bP;

    @FXML
    private JFXTextField nomu;

    @FXML
    private JFXPasswordField mdp;

    @FXML
    private JFXButton connect;

    @FXML
    private JFXButton changepath;
@FXML

    private Label erroru;
@FXML

private Label errorm;
public static String getUserConnected() {
	return userConnected;
}


public static void setUserConnected(String userConnected) {
	LoginController.userConnected = userConnected;
}

private static String userConnected;

    

	@FXML
    void seconnecter(ActionEvent event) {
		
		if(nomu.getText().equals(""))
	        {
	            erroru.setVisible(true);
	        }
		else  if(mdp.getText().equals(""))
	        {
	        	errorm.setVisible(true);
	        }
		 else {
    		        	String uname = nomu.getText();
    			        String pass = mdp.getText();
 			             String query = "SELECT * FROM `user` WHERE `userid` =? AND `passwd` =?";
					try (
    		    		       Connection conn=DBconnection.getConnection();PreparedStatement pr=conn.prepareStatement(query); ){
							
						pr.setString(1,uname);
				         pr.setString(2,pass);
                               ResultSet rs = pr.executeQuery();		        
						        if (rs.next()) {
						        	rs.close();
						           	userConnected=uname;
						    
						          goToHome(event);
						        }
						        else
						        { 
						    		Alert alert=new Alert(Alert.AlertType.ERROR);
								    alert.setTitle("Message d'erreur");
								    alert.setHeaderText("impossible de se connecter");
								 
								    alert.setContentText("Données de connexion peuvent etre erronées :( ");
								    alert.showAndWait();
						        }
    				
    		    				
    			}
    			catch ( SQLException e) {
    				Alert alert=new Alert(Alert.AlertType.ERROR);
    			    alert.setTitle("Message d'erreur");
    			    alert.setHeaderText("impossible de se connecter à la BDD");
    			    VBox dialogPaneContent = new VBox();
    		        Label label = new Label("Stack Trace:");
    		        TextArea textArea = new TextArea();
    		        textArea.setText(e.getMessage());
    		        dialogPaneContent.getChildren().addAll(label, textArea);

    		        alert.getDialogPane().setContent(dialogPaneContent);
    			    alert.setContentText("Données de connexion peuvent etre erronées :( ");
    			    alert.showAndWait();
    			}}
					 
    	
    	 

    }

    @FXML
    void pathchangeAction(ActionEvent event) {
      
   
    	
    		 goToDBConfig(event);
		
    	
    	
    }
    @FXML
    void sinscrire(ActionEvent event) {
 goToInscrire(event);
    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomu.focusedProperty().addListener(new ChangeListener<Boolean>() {	
		public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
            if (newValue.booleanValue()) {
             erroru.setVisible(false);
            }}
    });
		mdp.focusedProperty().addListener(new ChangeListener<Boolean>() {	
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
	            if (newValue.booleanValue()) {
	             errorm.setVisible(false);
	            }}
	    });
	
		
	}
    

}
