package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import Model.DBconnection;
import Model.Server;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    private JFXTextField versionserver;

    @FXML
    private JFXTextField memoire;

    @FXML
    private JFXTextField cpu;

    @FXML
    private JFXTextField cartevideo;

    @FXML
    private JFXTextField mvci;

    @FXML
    private JFXTextField scsi;

    @FXML
    private JFXTextField cddvd;

    @FXML
    private JFXTextField disquedur;

    @FXML
    private JFXTextField disquette;

    @FXML
    private JFXTextField adaptateurres;

    @FXML
    private JFXTextField dateinstalation;

    @FXML
    private JFXTextField versionOs;

    @FXML
    private JFXTextField ipv4;

    @FXML
    private JFXTextField ipv6;

    @FXML
    private JFXTextField dns;

    @FXML
    private JFXTextField passerelle;

    @FXML
    private JFXTextField mac;

    @FXML
    private JFXButton detailsButton;

    @FXML
    private Label servername;

    @FXML
    private JFXButton delete;

    @FXML
    private JFXButton modify;

    @FXML
    private JFXTextArea description;

    @FXML
    private GridPane detailAS;

    @FXML
    private GridPane detailDB;

    @FXML
    private Label cBDType;

    @FXML
    private AnchorPane formulairepane;
    @FXML
    private JFXTextField osserver;
    @FXML
    private JFXComboBox<String> osCB;


		

		
	    
	    
	    /////////////////////////Code 
  private ObservableMap<String,Server> AS=FXCollections.observableHashMap();
  private ObservableMap<String,Server> DB=FXCollections.observableHashMap();
  private ObservableMap<String,Server> others=FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitems =FXCollections.observableHashMap();//AS
  private ObservableMap<String,MenuItem> menuitemsDB =FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitemsothers =FXCollections.observableHashMap();
  
    

  @FXML
  void modifierServ(ActionEvent event) {
  
	    versionserver.setEditable(true);
	    memoire.setEditable(true);
	    cpu.setEditable(true);
	    cartevideo.setEditable(true);
	    mvci.setEditable(true);
	    scsi.setEditable(true);
	    cddvd.setEditable(true);
	    disquedur.setEditable(true);
        disquette.setEditable(true);
	    adaptateurres.setEditable(true);
	    dateinstalation.setEditable(true);
	    versionOs.setEditable(true);
	    ipv4.setEditable(true);
	    ipv6.setEditable(true);
	    dns.setEditable(true);
	    passerelle.setEditable(true);
	    mac.setEditable(true);
	    description.setEditable(true);
	    osserver.setVisible(false);
	    osCB.setVisible(true);
	    
	    

	 
	  
	  
	  
	  
	
  }

  @FXML
  void Confirmermaj(ActionEvent event) {
	  
	  
	  versionserver.setEditable(false);
	    memoire.setEditable(false);
	    cpu.setEditable(false);
	    cartevideo.setEditable(false);
	    mvci.setEditable(false);
	    scsi.setEditable(false);
	    cddvd.setEditable(false);
	    disquedur.setEditable(false);
      disquette.setEditable(false);
	    adaptateurres.setEditable(false);
	    dateinstalation.setEditable(false);
	    versionOs.setEditable(false);
	    ipv4.setEditable(false);
	    ipv6.setEditable(false);
	    dns.setEditable(false);
	    passerelle.setEditable(false);
	    mac.setEditable(false);
	    description.setEditable(false);
	    osserver.setVisible(true);
	    osserver.setText(osCB.getSelectionModel().getSelectedItem());
	    osCB.setVisible(false);
	    
	    
	

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
    			
    		AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac"))));
    		}
    		rs.close();
    	   
    		ps.setString(1,"DB");
    		 rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    			AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac")),new SimpleStringProperty(rs.getString("solHeb")),new SimpleStringProperty(rs.getString("typeBD")), new SimpleStringProperty(rs.getString("versionBD"))));
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
    	     cpu.setText(AS.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     memoire.setText(AS.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     versionserver.setText(AS.get(((MenuItem) e.getSource()).getText()).getVersionserver().get());
    	     ipv4.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"\\"+AS.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     ipv6.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"\\"+AS.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     showinfoPane.setVisible(true);
    	     
    	     
    	    });
    	
    		menuitems.put(m.getText(), m);
    		
    	}
    	ASshow.getItems().setAll(menuitems.values());
    	
      	for(Server serv :DB.values() ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	        
    	     System.out.printf(((MenuItem) e.getSource()).getText()+"choosed!");
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cpu.setText(DB.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     memoire.setText(DB.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     versionserver.setText(DB.get(((MenuItem) e.getSource()).getText()).getVersionserver().get());
    	     ipv4.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv4a()+"\\"+DB.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     ipv6.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"\\"+DB.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     osserver.setText(DB.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     
    	     showinfoPane.setVisible(true);
    	     
    	     
    	    });
    	
    		menuitems.put(m.getText(),m);
    		
    	}
    	
    	DBshow.getItems().setAll(menuitemsDB.values());
    	 
   
	}

}