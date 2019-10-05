package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import Model.DBconnection;
import Model.Server;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
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
    private JFXTextField servername;

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
    private JFXButton maj;
    @FXML
    private AnchorPane details;

    @FXML
    private AnchorPane formulairepane;
    @FXML
    private JFXTextField osserver;
    @FXML
    private JFXComboBox<String> osCB;
  String SrvnameActif=null;

		

		
	    
	    
	    /////////////////////////Code 
  private ObservableMap<String,Server> AS=FXCollections.observableHashMap();
  private ObservableMap<String,Server> DB=FXCollections.observableHashMap();
  private ObservableMap<String,Server> others=FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitems =FXCollections.observableHashMap();//AS
  private ObservableMap<String,MenuItem> menuitemsDB =FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitemsothers =FXCollections.observableHashMap();
  private List<String> changedAttr=new ArrayList();

    

  @FXML
  void modifierServ(ActionEvent event) {
       servername.setEditable(true);
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
	    osCB.setValue(osserver.getText());
	    maj.setVisible(true);
	     }

  @FXML
  void Confirmermaj(ActionEvent event) {
	  String SQL="UPDATE server SET ";
	  boolean isAS=false;
	  boolean isDB=false;
	  
	  
	Server serv;
	if(AS.containsKey(SrvnameActif)) {isAS=true;  serv=AS.get(SrvnameActif);}
	else if(DB.containsKey(SrvnameActif)) {serv= DB.get(SrvnameActif); isDB=true;}
	else { serv= others.get(SrvnameActif);}
	
	
	for (String att:changedAttr)
	  { System.out.println(" xx" +att);
		  switch(att)
		  {
		  case "description":
		  { 
			  boolean change = false;
			if(description.getText().compareTo(serv.getDescription().get())!=0 && change==false)
			  {
				  SQL=SQL+"description='"+description.getText()+"',";change=true;
				  if(isAS==true) AS.get(serv.getNomS().get()).setDescription(new SimpleStringProperty(description.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setDescription(new SimpleStringProperty(description.getText()));
				  else others.get(serv.getNomS().get()).setDescription(new SimpleStringProperty(description.getText()));
			  }
			  
			  
		  }
		  break;
		  case "memoire":
		  { System.out.print("memoire\n");
			  if(memoire.getText().compareTo(serv.getMemoire().get())!=0)
			  {
				  SQL=SQL+"memoire='"+memoire.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setMemoire(new SimpleStringProperty(memoire.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setMemoire(new SimpleStringProperty(memoire.getText()));
				  else others.get(serv.getNomS().get()).setMemoire(new SimpleStringProperty(memoire.getText()));
			  }
			  
			  
		  }
		  break;
		  case "cpu":
		  { 
			  System.out.print(serv.getCPU().get());
			  if(cpu.getText().compareTo(serv.getCPU().get())!=0 )
			  {
				  SQL=SQL+"cpu='"+cpu.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setCPU(new SimpleStringProperty(cpu.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setCPU(new SimpleStringProperty(cpu.getText()));
				  else others.get(serv.getNomS().get()).setCPU(new SimpleStringProperty(cpu.getText()));
			  }
			  
			  
		  }
		  break;
		  case "versionserver":
		  { 
			  if(versionserver.getText().compareTo(serv.getVersionserver().get())!=0)
			  {
				  if(isAS==true) AS.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionserver.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionserver.getText()));
				  else others.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionserver.getText()));
			  }
			 
		  }
		  break;
		  case "mvci":
		  {
			  if(mvci.getText().compareTo(serv.getVMCI().get())!=0)
			  {
				  SQL=SQL+"mvci='"+mvci.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setVMCI(new SimpleStringProperty(mvci.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setVMCI(new SimpleStringProperty(mvci.getText()));
				  else others.get(serv.getNomS().get()).setVMCI(new SimpleStringProperty(mvci.getText()));
			  }
			 
		  }
		  break;
		  case "cartevideo":
		  {
			  if(cartevideo.getText().compareTo(serv.getCartevid().get())!=0)
			  {
				  SQL=SQL+"cartevideo='"+cartevideo.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
				  else others.get(serv.getNomS().get()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
			  }
			  
			  
		  }
		  break;
		  case "scsi":
		  {
			  if(scsi.getText().compareTo(serv.getSCSI().get())!=0)
			  {
				  SQL=SQL+"scsi='"+scsi.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setSCSI(new SimpleStringProperty(scsi.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setSCSI(new SimpleStringProperty(scsi.getText()));
				  else others.get(serv.getNomS().get()).setSCSI(new SimpleStringProperty(scsi.getText()));
			  }
			  
			  
		  }
		  break;
		  case "cddvd":
		  {
			  if(cddvd.getText().compareTo(serv.getCDDVD().get())!=0)
			  {
				  SQL=SQL+"cddvd='"+scsi.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
				  else others.get(serv.getNomS().get()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
			  }
		  }
		  break;
		  case "disquedur": {
			  if(disquedur.getText().compareTo(serv.getDD().get())!=0)
			  {
				  SQL=SQL+"disquedur='"+disquedur.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setDD(new SimpleStringProperty(disquedur.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setDD(new SimpleStringProperty(disquedur.getText()));
				  else others.get(serv.getNomS().get()).setDD(new SimpleStringProperty(disquedur.getText()));
			  }
		  }
		  break;
		  case "disquette": {
			  if(disquette.getText().compareTo(serv.getDisquette().get())!=0)
			  {
				  SQL=SQL+"disquette='"+disquette.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setDisquette(new SimpleStringProperty(disquette.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setDisquette(new SimpleStringProperty(disquette.getText()));
				  else others.get(serv.getNomS().get()).setDisquette(new SimpleStringProperty(disquette.getText()));
			  }
		  }
		  break;
		  case "adaptateurres":
		  {
			  if(adaptateurres.getText().compareTo(serv.getAdapRes().get())!=0)
			  {
				  SQL=SQL+"adaptateurres='"+adaptateurres.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
				  else others.get(serv.getNomS().get()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
			  }
		  }
		  break;
		  case "dateinstalation" :{
			  if(dateinstalation.getText().matches("..../../.."))
			  {
				  
				  SQL=SQL+"dateinstalation='"+dateinstalation.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  else others.get(serv.getNomS().get()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  
			  }
			  
			  
		  }
		  break;
		  case "servername" :{
			    System.out.print(isAS);
				  SQL=SQL+"servername='"+servername.getText()+"',";
				  if(isAS==true) {
				  String oldkey=serv.getNomS().get();
				  AS.get(serv.getNomS().get()).setNomS(new SimpleStringProperty(servername.getText()));
				  AS.put(servername.getText(),AS.get(oldkey));
				  AS.remove(oldkey);
				  majMenuButton(AS,ASshow);}
				  else if(isDB==true) {String oldkey=serv.getNomS().get();
				  DB.get(serv.getNomS().get()).setNomS(new SimpleStringProperty(servername.getText()));
				  DB.put(servername.getText(),DB.get(oldkey));
				  DB.remove(oldkey);
				  majMenuButton(DB,DBshow);}
				  else {
					  String oldkey=serv.getNomS().get();
					  others.get(serv.getNomS().get()).setNomS(new SimpleStringProperty(servername.getText()));
					  others.put(servername.getText(),others.get(oldkey));
					  others.remove(oldkey);
					  majMenuButton(others,othersShow);
				  }
				  
			  
			  
		  }
		  break;
	    case "versionOs" :{ 
	
			  if(versionOs.getText().compareTo(serv.getVersionOS().get())!=0)
		  {
			  SQL=SQL+"versionOs='"+versionOs.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
			  else if(isDB==true) DB.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
			  else others.get(serv.getNomS().get()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
		  }
		  }
	    break;
	      case"ipv4":{ if(ipv4.getText().matches("(.*).(.*).(.*).(.*)/(.*)"))
	               { SQL=SQL+"ipv4='"+ipv4.getText().substring(0,ipv4.getText().indexOf("/"))+"',";
	                 SQL=SQL+"ipv4m='"+ipv4.getText().substring(ipv4.getText().indexOf("/")+1)+"',";
	                 if(isAS==true) { AS.get(serv.getNomS().get()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	                                  AS.get(serv.getNomS().get()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1))); }
	   			  else if(isDB==true) {DB.get(serv.getNomS().get()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	   			                       DB.get(serv.getNomS().get()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1)));}
	   			  else {others.get(serv.getNomS().get()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	   			        others.get(serv.getNomS().get()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1)));}  }
	    	  }
	      break;
		  case "ipv6":{
			  if(ipv6.getText().matches("(.*)/(.*)"))
              { SQL=SQL+"ipv6='"+ipv6.getText().substring(0,ipv6.getText().indexOf("/"))+"',";
                SQL=SQL+"ipv6m='"+ipv6.getText().substring(ipv6.getText().indexOf("/")+1)+"',";
                if(isAS==true) {AS.get(serv.getNomS().get()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
                AS.get(serv.getNomS().get()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
  			  else if(isDB==true) {DB.get(serv.getNomS().get()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
                DB.get(serv.getNomS().get()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
  			  else {others.get(serv.getNomS().get()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
  			others.get(serv.getNomS().get()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
                }
		  }break;
		  case "dns":{
			  if(dns.getText().compareTo(serv.getDns().get())!=0)
			  {
				  SQL=SQL+"dns='"+dns.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setDns(new SimpleStringProperty(dns.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setDns(new SimpleStringProperty(dns.getText()));
				  else others.get(serv.getNomS().get()).setDns(new SimpleStringProperty(dns.getText()));
			  }
			  }
		  break;
	      case "passerelle":{
			  
			  if(passerelle.getText().compareTo(serv.getPasserelle().get())!=0)
			  {
				  SQL=SQL+"passerelle='"+passerelle.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
				  else others.get(serv.getNomS().get()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
			  }
		  } 
	      break;
		  case "mac":{
			  if(mac.getText().compareTo(serv.getPhysicalAd().get())!=0)
			  {
				  SQL=SQL+"mac='"+mac.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS().get()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
				  else others.get(serv.getNomS().get()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
			  }
			  
		  }
		  break;
	     
		  
		  
		  
		  }
		  
		
		  
		  
	  }
	  
		if(osCB.getValue().compareTo(serv.getServerOS().get())!=0) {
				
				SQL=SQL+"os='"+osCB.getSelectionModel().getSelectedItem()+"',";
				osserver.setText(osCB.getSelectionModel().getSelectedItem());
				 if(isAS==true) AS.get(serv.getNomS().get()).setServerOS(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
				  else if(isDB==true) DB.get(serv.getNomS().get()).setServerOS(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
				  else others.get(serv.getNomS().get()).setPhysicalAd(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
			}
			SQL=SQL.substring(0,SQL.length()-1)+" where servername=? ";
			System.out.print("La requete "+SQL);
			if(!SQL.equals("UPDATE server SET where servername=? "))try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(SQL);)
			{
				ps.setString(1,SrvnameActif);
				
				ps.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  
	  
	
	  //end
		servername.setEditable(false);
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
	    maj.setVisible(false);
	    
	

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
		changedAttr.clear();
		showinfoPane.setVisible(false);
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
		    osserver.setEditable(false);
		    osCB.setVisible(false);
		    maj.setVisible(false);
		   ObservableList<String> os=FXCollections.observableArrayList();
			String sql1="SELECT nameOs from os ";
			try(Connection conn=DBconnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql1);)
		    	{
		    	ResultSet rs=ps.executeQuery();
		    	while(rs.next()) { os.add(rs.getString("nameOs"));}
		    	rs.close();
		    	
		    	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			osCB.setItems(os);
		    ///////////////////////
		    versionserver.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&&newValue.equals(""))  { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("versionserver")) changedAttr.add("versionserver");}
			
		    
		});
		
		    memoire.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("memoire")) changedAttr.add("memoire");}
					
				    
			});
			
		    cpu.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj") && !newValue.equals("")) 
		     	{	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("cpu"))changedAttr.add("cpu");  } 
			});
			
		    cartevideo.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("cartevideo"))changedAttr.add("cartevideo");}
					
				    
			});
		    servername.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("servername")) changedAttr.add("servername");}
					
				    
			});
			
		    mvci.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& newValue.equals("")) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("mvci"))changedAttr.add("mvci");}
					
				    
			});
			
		    scsi.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj") && newValue.equals("")) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("scsi"))	changedAttr.add("scsi");}
				    
			});
			
		    cddvd.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&&newValue.equals("")) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("cddvd"))changedAttr.add("cddvd");}
				    
			});
			
		    disquedur.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&&newValue.equals("")) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("disquedur"))changedAttr.add("disquedur");}
				    
			});
			
	        disquette.textProperty().addListener((observable, oldValue, newValue) -> {
	         	if(!oldValue.equals("jjhjhj")&&newValue.equals("")) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
	         	if(!changedAttr.contains("disquette"))changedAttr.add("disquette");	}
				    
			});
			
		    adaptateurres.textProperty().addListener((observable, oldValue, newValue) -> {
			   	if(!oldValue.equals("jjhjhj")&&newValue.equals("")) {System.out.println("textfield changed from " + oldValue + " to " + newValue);
			   	if(!changedAttr.contains("adaptateurres"))changedAttr.add("adaptateurres");		
			   	}
			});
			
		    dateinstalation.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
				
		     	if(!changedAttr.contains("dateinstalation"))changedAttr.add("dateinstalation");	}	  
			});
			
		    versionOs.textProperty().addListener((observable, oldValue, newValue) -> {
		    	System.out.println("changement : "+oldValue+newValue);
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("versionOs"))changedAttr.add("versionOs");	}		
				    
			});
			
		    ipv4.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) {  	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("ipv4"))changedAttr.add("ipv4");}	 
			});
			
		    ipv6.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) { 	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("ipv6")) changedAttr.add("ipv6");	 } 
			});
			
		    dns.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) { 	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("dns"))	changedAttr.add("dns");	}	
				    
			});
			
		    passerelle.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("jjhjhj")&& !newValue.equals("")) {  	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("passerelle"))changedAttr.add("passerelle");	}
				    
			});
			
		    mac.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(!oldValue.equals("jjhjhj") && !newValue.equals("")) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("mac"))changedAttr.add("mac");	   }
			});
			
		    description.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(!oldValue.matches("Description") && !newValue.equals("")) {
		    System.out.println("textfield changed from " + oldValue + " to " + newValue);
			if(!changedAttr.contains("description")) changedAttr.add("description");	 
		    	}	});
		
		
		String sql="SELECT * from server where typeserver=?";
	try(Connection conn=DBconnection.getConnection(); PreparedStatement ps=conn.prepareStatement(sql);)
    	{
    		
    		ps.setString(1,"AS");
    		ResultSet rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    		AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("cartevideo")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac"))));
    		}
    		rs.close();
    	   
    		ps.setString(1,"DB");
    		 rs=ps.executeQuery();
    		while (rs.next())
    		{
    			
    			AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("versionserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("cartevideo")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac")),new SimpleStringProperty(rs.getString("solHeb")),new SimpleStringProperty(rs.getString("typeBD")), new SimpleStringProperty(rs.getString("versionBD"))));
    		}
    		rs.close();
    		
    		
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	/*	AS.add(new Server(new SimpleStringProperty("AS_XXXXXX35"), null, null, null, null, null, null, null, null, null, null));
		AS.add(new Server(new SimpleStringProperty("AS_XXXXXX65"), null, null, null, null, null, null, null, null, null, null));*/	
    	initialiserMenuButton();
    	details.setVisible(false);
    	 servername.setEditable(false);
   
	}
    @FXML
    void shwDetails(ActionEvent event) {  	
details.setVisible(true);
    }
    void initialiserMenuButton(){
    	
    	MenuItem m;
    	for(Server serv :AS.values() ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    			SrvnameActif=((MenuItem) e.getSource()).getText(); 
    	    
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cpu.setText(AS.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     memoire.setText(AS.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     versionserver.setText(AS.get(((MenuItem) e.getSource()).getText()).getVersionserver().get());
    	     ipv4.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"/"+AS.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     ipv6.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"/"+AS.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     osserver.setText(AS.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     cartevideo.setText(AS.get(((MenuItem) e.getSource()).getText()).getCartevid().get());
    	     mvci.setText(AS.get(((MenuItem) e.getSource()).getText()).getVMCI().get());
    	     scsi.setText(AS.get(((MenuItem) e.getSource()).getText()).getSCSI().get());
    	     cddvd.setText(AS.get(((MenuItem) e.getSource()).getText()).getCDDVD().get());
    	     disquedur.setText(AS.get(((MenuItem) e.getSource()).getText()).getDD().get());
    	     disquette.setText(AS.get(((MenuItem) e.getSource()).getText()).getDisquette().get());
    	     adaptateurres.setText(AS.get(((MenuItem) e.getSource()).getText()).getAdapRes().get());
    	     dateinstalation.setText(AS.get(((MenuItem) e.getSource()).getText()).getDateOS().get());
    	     versionOs.setText(AS.get(((MenuItem) e.getSource()).getText()).getVersionOS().get());
    	     dns.setText(AS.get(((MenuItem) e.getSource()).getText()).getDns().get());
    	     passerelle.setText(AS.get(((MenuItem) e.getSource()).getText()).getPasserelle().get());
    	     mac.setText(AS.get(((MenuItem) e.getSource()).getText()).getPhysicalAd().get());
    	     osserver.setText(AS.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     description.setText(AS.get(((MenuItem) e.getSource()).getText()).getDescription().get());
    	     showinfoPane.setVisible(true);
    	     
    	     
    	    });
    	
    		menuitems.put(m.getText(), m);
    		
    	}
    	ASshow.getItems().setAll(menuitems.values());
    	
      	for(Server serv :DB.values() ) {
    		m=new MenuItem(serv.getNomS().get());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    	     SrvnameActif=((MenuItem) e.getSource()).getText();
    	     System.out.printf(SrvnameActif+"choosed!");
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
   void majMenuButton (ObservableMap<String,Server> map,MenuButton button) {
	   MenuItem m;
		ObservableMap<String,MenuItem> menuitem =FXCollections.observableHashMap();
		for(Server serv :map.values() ) {
    	 m=new MenuItem(serv.getNomS().get());
    	 menuitem.put(m.getText(),m);
		}
		button.getItems().setAll(menuitem.values());
   }
}