package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import Model.DBconnection;
import Model.Server;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class HomePageController implements Initializable {

	
	
	 @FXML
	    private MenuButton ASshow;

	    @FXML
	    private MenuButton DBshow;

    @FXML
    private JFXButton addAS;
     @FXML
    private JFXButton addDB;

    @FXML
    private ContextMenu MenuAS1;

 

    @FXML
    private Label servername;

  private ObservableList<Server> AS=FXCollections.observableArrayList();
  private ObservableList<Server> DB=FXCollections.observableArrayList();
   
    
    @FXML
    void showDBS(ActionEvent event) {
     	

    }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		String sql="SELECT * from server where typeserver=?";
	/*	try(Connection conn=DBconnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql);)
    	{
    		
    		ps.setString(1,"AS");
    		ResultSet rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    		AS.add(new Server(null, null, null, null, null, null, null, null, null, null));
    		}
    		rs.close();
    	   
    		ps.setString(1,"DB");
    		 rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    			DB.add(new Server(null, null, null, null, null, null, null, null, null, null));
    		}
    		rs.close();
    		
    		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/
		AS.add(new Server(new SimpleStringProperty("AS_XXXXXX35"), null, null, null, null, null, null, null, null, null));
		AS.add(new Server(new SimpleStringProperty("AS_XXXXXX65"), null, null, null, null, null, null, null, null, null));	
		ObservableList<MenuItem> menuitems =FXCollections.observableArrayList();
    	MenuItem m;
    	for(Server serv :AS ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	        
    	     System.out.printf(((MenuItem) e.getSource()).getText()+"choosed!");
    	    });
    		menuitems.add(m);
    		
    	}
    	ASshow.getItems().setAll(menuitems);
    	ObservableList<MenuItem> menuitemsDB =FXCollections.observableArrayList();
    	for(Server serv :DB ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	        
       	     System.out.printf(((MenuItem) e.getSource()).getText()+"choosed!");
       	    });
       		menuitemsDB.add(m);
       		
    	}
    	DBshow.getItems().setAll(menuitemsDB);
    	 
   
    	System.out.printf("executed !");
	}

}