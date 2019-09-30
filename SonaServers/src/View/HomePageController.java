package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import Model.DBconnection;
import Model.Server;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.MapChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


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
	    private MenuButton othersShow;

	    @FXML
	    private JFXButton addserver;

	    @FXML
	    private AnchorPane showinfoPane;

	    @FXML
	    private Label cVersionS;

	    @FXML
	    private Label cMemoire;

	    @FXML
	    private Label cCPU;

	    @FXML
	    private Label cCV;

	    @FXML
	    private Label cVMCI;

	    @FXML
	    private Label cSCSI;

	    @FXML
	    private Label cCD;

	    @FXML
	    private Label cAdapres;

	    @FXML
	    private Label cDisquette;

	    @FXML
	    private Label cDD;

	    @FXML
	    private Label cOS;

	    @FXML
	    private Label cVersionOS;

	    @FXML
	    private Label cDateOS;

	    @FXML
	    private Label cipv4;

	    @FXML
	    private Label cipv6;

	    @FXML
	    private Label cDNS;

	    @FXML
	    private Label cPasserelle;

	    @FXML
	    private Label cMAC;

	    @FXML
	    private JFXButton detailsButton;

	    @FXML
	    private Label servername;

	    @FXML
	    private JFXButton delete;

	    @FXML
	    private JFXButton modify;

	    @FXML
	    private GridPane detailAS;

	    @FXML
	    private Label cBDversion1;

	    @FXML
	    private Label cVersionS11111111121;

	    @FXML
	    private GridPane detailDB;

	    @FXML
	    private Label cBDversion;

	    @FXML
	    private Label cBDType;

	    @FXML
	    private Label cVersionS1111111112;

	    @FXML
	    private Label cBDversion2;

	    @FXML
	    private AnchorPane formulairepane;
         
	   

		

		
	    
	    
	    /////////////////////////Code 
  private ObservableMap<String,Server> AS=FXCollections.observableHashMap();
  private ObservableMap<String,Server> DB=FXCollections.observableHashMap();
  private ObservableMap<String,Server> others=FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitems =FXCollections.observableHashMap();//AS
  private ObservableMap<String,MenuItem> menuitemsDB =FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitemsothers =FXCollections.observableHashMap();
  
    

  @FXML
  void modifierServ(ActionEvent event) {

  }

 

  @FXML
  void supprimerServer(ActionEvent event) {
	  String key=servername.getText();
	 if( AS.get(key)!=null) {
		 
		 AS.remove(key);
		 menuitems.remove(key);
		 ASshow.getItems().setAll(menuitems.values());
		 
	 }
	 else if(DB.get(key)!=null) {DB.remove(key);
	 menuitems.remove(key);
	 DBshow.getItems().setAll(menuitemsDB.values());
	 }
	 else {
	 others.remove(key);
	 menuitemsothers.remove(key);
	 othersShow.getItems().setAll(menuitemsDB.values());
	 
	 }
	 showinfoPane.setVisible(false);
      
  }
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showinfoPane.setVisible(false);
		
		String sql="SELECT * from server where typeserver=?";
	try(Connection conn=DBconnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql);)
    	{
    		
    		ps.setString(1,"AS");
    		ResultSet rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    		AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description"))));
    		}
    		rs.close();
    	   
    		ps.setString(1,"DB");
    		 rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    			DB.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description"))));
    		}
    		rs.close();
    		
    		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	/*	AS.add(new Server(new SimpleStringProperty("AS_XXXXXX35"), null, null, null, null, null, null, null, null, null, null));
		AS.add(new Server(new SimpleStringProperty("AS_XXXXXX65"), null, null, null, null, null, null, null, null, null, null));*/	
    	MenuItem m;
    	for(Server serv :AS.values() ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	        
    	     System.out.printf(((MenuItem) e.getSource()).getText()+"choosed!");
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cCPU.setText(AS.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     cMemoire.setText(AS.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     cVersionS.setText(AS.get(((MenuItem) e.getSource()).getText()).getVersionserver().get());
    	     cipv4.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"\\"+AS.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     cipv6.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"\\"+AS.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     showinfoPane.setVisible(true);
    	     
    	     
    	    });
    	
    		menuitems.put(m.getText(), m);
    		
    	}
    	ASshow.getItems().setAll(menuitems.values());
    	
      	for(Server serv :DB.values() ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	        
    	     System.out.printf(((MenuItem) e.getSource()).getText()+"choosed!");
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cCPU.setText(DB.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     cMemoire.setText(DB.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     cVersionS.setText(DB.get(((MenuItem) e.getSource()).getText()).getVersionserver().get());
    	     cipv4.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv4a()+"\\"+DB.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     cipv6.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"\\"+DB.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     cOS.setText(DB.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     
    	     showinfoPane.setVisible(true);
    	     
    	     
    	    });
    	
    		menuitems.put(m.getText(),m);
    		
    	}
    	
    	DBshow.getItems().setAll(menuitemsDB.values());
    	 
   
	}

}