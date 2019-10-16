package View;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
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
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;



public class HomePageController implements Initializable{

	  @FXML
	    private Label updatephrase;
	@FXML
    private MenuButton ASshow;

    @FXML
    private MenuButton DBshow;

    @FXML
    private JFXTextField cheminfxm;
    @FXML
    private JFXTextField cheminrdf;

    @FXML
    private MenuButton othersShow;

    @FXML
    private JFXTextField vrsBD;

    @FXML
    private JFXTextField typeBD;

    @FXML
    private AnchorPane showinfoPane;


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
    private JFXTextField disquedur3;

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
    @FXML
    private JFXTextField cheminBD;
  

    @FXML
    private JFXTextField cheminf1;

    
    @FXML
    private AnchorPane configPane;
    
    //Les formulaires 
    @FXML
    private VBox HardwareForm;

    @FXML
    private JFXTextField nomserveur;

    @FXML
    private JFXTextField memoire1;

    @FXML
    private JFXTextField cpu1;

    @FXML
    private JFXTextField cartevd;

    @FXML
    private JFXTextField vmci;

    @FXML
    private JFXTextField controleur;

    @FXML
    private JFXTextField lectcd;

    @FXML
    private JFXTextField disquedur1;
    @FXML
    private JFXTextField disquedur2;

    @FXML
    private JFXTextField lecteurdedisquette1;

    @FXML
    private JFXTextField adaptateurrs1;
    //Res SYs
    @FXML
    private JFXTextField ipv4f;

    @FXML
    private JFXTextField msqipv4f;

    @FXML
    private JFXTextField passerellef;

    @FXML
    private JFXTextField dnsf;

    @FXML
    private JFXTextField ipv6f;

    @FXML
    private JFXTextField msqipv6f;

    @FXML
    private JFXTextField macf;

    @FXML
    private JFXComboBox<String> sof;

    @FXML
    private JFXDatePicker datef;

    @FXML
    private JFXTextField versionf;
    @FXML
    private VBox descriptionForm;

    @FXML
    private JFXTextArea descriptionf;
    @FXML
    private AnchorPane addospane;
    @FXML
    private AnchorPane pwdpane;

    @FXML
    private JFXTextField cheminfmxf;
    @FXML
    private JFXTextField cheminrdff;

    @FXML
    private JFXTextField typeBDDf;
    @FXML
    private JFXTextField cheminBDf;

    @FXML
    private JFXTextField versionBDDf;
    @FXML
    private JFXTextField searchbar;

    @FXML
    private AnchorPane searchpane;
    @FXML
    private AnchorPane configmenu;

    @FXML
    
    private TableView<Server> tableresult;
    @FXML
    private  JFXPasswordField oldpwd;
    @FXML
    private TableColumn<Server, String> noms=new TableColumn<Server, String>();
    @FXML 
    private JFXComboBox<String> unit;
    @FXML 
    private GridPane materiel;
    @FXML 
    private GridPane systmres;
 
    @FXML 
    private VBox matbox;
    @FXML 
    private VBox sysbox;



    

   
	private String nomserv;
	private String memoir;
	private String cpuu;
	private String cartvd;
	private String vm;
	private String cntrlr; 
	private String lctcd;
	private String disqdr1;
	private String lectdisq;
	private String adptrs;
	private String ipv44;
	private String masqipv4;
	private String psrl;
	private String ipv66;
	private String dnns;
	private String masqipv6; 
	private String adressePhysique;
	private String versio;
	private LocalDate  dat;
	private String versionsys;
	private String pathBD;
	private String chemFMX;
	private String chemRDF;
	private String mott ;
	
	final ObservableList<String> data  =  FXCollections.observableArrayList();
	final ObservableList<Server> rechercherr  =  FXCollections.observableArrayList();
	 @FXML
	private VBox reseausystem;

    
  String SrvnameActif=null;
  Boolean isAS=false,isDB=false;

		

		
	    
	    
	    /////////////////////////Code 
  private ObservableMap<String,Server> AS=FXCollections.observableHashMap();
  private ObservableMap<String,Server> DB=FXCollections.observableHashMap();
  private ObservableMap<String,Server> others=FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitems =FXCollections.observableHashMap();//AS
  private ObservableMap<String,MenuItem> menuitemsDB =FXCollections.observableHashMap();
  private ObservableMap<String,MenuItem> menuitemsothers =FXCollections.observableHashMap();
  private ObservableList<String> unity=FXCollections.observableArrayList("Mo","Go","To");
 
  private List<String> changedAttr=new ArrayList<String>();

private String os;

private String disqdr2;

private String previous_serv="init";

private boolean NO_CHG=true;



    

  @FXML
  void modifierServ(ActionEvent event) {
       servername.setEditable(true);
	   cheminfxm.setEditable(true);
	   cheminrdf.setEditable(true);
	    memoire.setEditable(true);
	    cpu.setEditable(true);
	    cartevideo.setEditable(true);
	    mvci.setEditable(true);
	    scsi.setEditable(true);
	    cddvd.setEditable(true);
	    disquedur.setEditable(true);
	    disquedur3.setEditable(true);
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
	    changedAttr.clear();}

  @FXML
  void Confirmermaj(ActionEvent event) {
	  String SQL="UPDATE server SET ";
	  boolean isAS=false;
	  boolean isDB=false;
	  
	  
	Server serv;
	if(AS.containsKey(SrvnameActif)) {isAS=true;  serv=AS.get(SrvnameActif);}
	else if(DB.containsKey(SrvnameActif)) {serv= DB.get(SrvnameActif); isDB=true;}
	else { serv= others.get(SrvnameActif);}
	
	 System.out.println("****"+NO_CHG);
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
				  if(isAS==true) AS.get(serv.getNomS()).setDescription(new SimpleStringProperty(description.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDescription(new SimpleStringProperty(description.getText()));
				  else others.get(serv.getNomS()).setDescription(new SimpleStringProperty(description.getText()));
			  }
			  
			  
		  }
		  break;
		  case "memoire":
		  { System.out.print("memoire\n");
			  if(memoire.getText().compareTo(serv.getMemoire().get())!=0)
			  {
				  SQL=SQL+"memoire='"+memoire.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setMemoire(new SimpleStringProperty(memoire.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setMemoire(new SimpleStringProperty(memoire.getText()));
				  else others.get(serv.getNomS()).setMemoire(new SimpleStringProperty(memoire.getText()));
			  }
			  
			  
		  }
		  break;
		  case "cpu":
		  { 
			  System.out.print(serv.getCPU().get());
			  if(cpu.getText().compareTo(serv.getCPU().get())!=0 )
			  {
				  SQL=SQL+"cpu='"+cpu.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setCPU(new SimpleStringProperty(cpu.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setCPU(new SimpleStringProperty(cpu.getText()));
				  else others.get(serv.getNomS()).setCPU(new SimpleStringProperty(cpu.getText()));
			  }
			  
			  
		  }
		  break;
		
		  case "mvci":
		  {
			  if(mvci.getText().compareTo(serv.getVMCI().get())!=0)
			  {
				  SQL=SQL+"mvci='"+mvci.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setVMCI(new SimpleStringProperty(mvci.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setVMCI(new SimpleStringProperty(mvci.getText()));
				  else others.get(serv.getNomS()).setVMCI(new SimpleStringProperty(mvci.getText()));
			  }
			 
		  }
		  break;
		  case "cartevideo":
		  {
			  if(cartevideo.getText().compareTo(serv.getCartevid().get())!=0)
			  {
				  SQL=SQL+"cartevideo='"+cartevideo.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
				  else others.get(serv.getNomS()).setCartevid(new SimpleStringProperty(cartevideo.getText()));
			  }
			  
			  
		  }
		  break;
		  case "scsi":
		  {
			  if(scsi.getText().compareTo(serv.getSCSI().get())!=0)
			  {
				  SQL=SQL+"scsi='"+scsi.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setSCSI(new SimpleStringProperty(scsi.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setSCSI(new SimpleStringProperty(scsi.getText()));
				  else others.get(serv.getNomS()).setSCSI(new SimpleStringProperty(scsi.getText()));
			  }
			  
			  
		  }
		  break;
		  case "cddvd":
		  {
			  if(cddvd.getText().compareTo(serv.getCDDVD().get())!=0)
			  {
				  SQL=SQL+"cddvd='"+cddvd.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
				  else others.get(serv.getNomS()).setCDDVD(new SimpleStringProperty(cddvd.getText()));
			  }
		  }
		  break;
		  case "disquedur": {
			  if(disquedur.getText().compareTo(serv.getDD().get())!=0)
			  {
				  SQL=SQL+"disquedur='"+disquedur.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setDD(new SimpleStringProperty(disquedur.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDD(new SimpleStringProperty(disquedur.getText()));
				  else others.get(serv.getNomS()).setDD(new SimpleStringProperty(disquedur.getText()));
			  }
		  }
		  break;
		  case "disquedur2": {
			  if(disquedur3.getText().compareTo(serv.getDD2().get())!=0)
			  {
				  SQL=SQL+"disquedur2='"+disquedur3.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setDD2(new SimpleStringProperty(disquedur3.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDD2(new SimpleStringProperty(disquedur3.getText()));
				  else others.get(serv.getNomS()).setDD2(new SimpleStringProperty(disquedur3.getText()));
			  }
		  }
		  break;
		  case "disquette": {
			  if(disquette.getText().compareTo(serv.getDisquette().get())!=0)
			  {
				  SQL=SQL+"disquette='"+disquette.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setDisquette(new SimpleStringProperty(disquette.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDisquette(new SimpleStringProperty(disquette.getText()));
				  else others.get(serv.getNomS()).setDisquette(new SimpleStringProperty(disquette.getText()));
			  }
		  }
		  break;
		  case "adaptateurres":
		  {
			  if(adaptateurres.getText().compareTo(serv.getAdapRes().get())!=0)
			  {
				  SQL=SQL+"adaptateurres='"+adaptateurres.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
				  else others.get(serv.getNomS()).setAdapRes(new SimpleStringProperty(adaptateurres.getText()));
			  }
		  }
		  break;
		  case "dateinstalation" :{
			  if(dateinstalation.getText().matches("..../../.."))
			  {
				  
				  SQL=SQL+"dateinstalation='"+dateinstalation.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  else others.get(serv.getNomS()).setDateOS(new SimpleStringProperty(dateinstalation.getText()));
				  
			  }
			  
			  
		  }
		  break;
		  case "servername" :{
			    System.out.print(isAS);
				  SQL=SQL+"servername='"+servername.getText()+"',";
				  if(isAS==true) {
				  String oldkey=serv.getNomS();
				  AS.get(serv.getNomS()).setNomS(new SimpleStringProperty(servername.getText()));
				  AS.put(servername.getText(),AS.get(oldkey));
				  AS.remove(oldkey);
				  majMenuButton(AS,ASshow);}
				  else if(isDB==true) {String oldkey=serv.getNomS();
				  DB.get(serv.getNomS()).setNomS(new SimpleStringProperty(servername.getText()));
				  DB.put(servername.getText(),DB.get(oldkey));
				  DB.remove(oldkey);
				  majMenuButton(DB,DBshow);}
				  else {
					  String oldkey=serv.getNomS();
					  others.get(serv.getNomS()).setNomS(new SimpleStringProperty(servername.getText()));
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
			  if(isAS==true) AS.get(serv.getNomS()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
			  else others.get(serv.getNomS()).setVersionOS(new SimpleStringProperty(versionOs.getText()));
		  }
		  }
	    break;
	      case"ipv4":{ if(ipv4.getText().matches("(.*).(.*).(.*).(.*)/(.*)"))
	               { SQL=SQL+"ipv4='"+ipv4.getText().substring(0,ipv4.getText().indexOf("/"))+"',";
	                 SQL=SQL+"ipv4m='"+ipv4.getText().substring(ipv4.getText().indexOf("/")+1)+"',";
	                 if(isAS==true) { AS.get(serv.getNomS()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	                                  AS.get(serv.getNomS()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1))); }
	   			  else if(isDB==true) {DB.get(serv.getNomS()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	   			                       DB.get(serv.getNomS()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1)));}
	   			  else {others.get(serv.getNomS()).setIpv4a(new SimpleStringProperty(ipv4.getText().substring(0,ipv4.getText().indexOf("/"))));
	   			        others.get(serv.getNomS()).setIpv4m(new SimpleStringProperty(ipv4.getText().substring(ipv4.getText().indexOf("/")+1)));}  }
	    	  }
	      break;
		  case "ipv6":{
			  if(ipv6.getText().matches("(.*)/(.*)"))
              { SQL=SQL+"ipv6='"+ipv6.getText().substring(0,ipv6.getText().indexOf("/"))+"',";
                SQL=SQL+"ipv6m='"+ipv6.getText().substring(ipv6.getText().indexOf("/")+1)+"',";
                if(isAS==true) {AS.get(serv.getNomS()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
                AS.get(serv.getNomS()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
  			  else if(isDB==true) {DB.get(serv.getNomS()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
                DB.get(serv.getNomS()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
  			  else {others.get(serv.getNomS()).setIpv6a(new SimpleStringProperty(ipv6.getText().substring(0,ipv6.getText().indexOf("/"))));
  			others.get(serv.getNomS()).setIpv6m(new SimpleStringProperty(ipv6.getText().substring(ipv6.getText().indexOf("/")+1)));}
                }
		  }break;
		  case "dns":{
			  if(dns.getText().compareTo(serv.getDns().get())!=0)
			  {
				  SQL=SQL+"dns='"+dns.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setDns(new SimpleStringProperty(dns.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setDns(new SimpleStringProperty(dns.getText()));
				  else others.get(serv.getNomS()).setDns(new SimpleStringProperty(dns.getText()));
			  }
			  }
		  break;
	      case "passerelle":{
			  
			  if(passerelle.getText().compareTo(serv.getPasserelle().get())!=0)
			  {
				  SQL=SQL+"passerelle='"+passerelle.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
				  else others.get(serv.getNomS()).setPasserelle(new SimpleStringProperty(passerelle.getText()));
			  }
		  } 
	      break;
		  case "mac":{
			  if(mac.getText().compareTo(serv.getPhysicalAd().get())!=0)
			  {
				  SQL=SQL+"mac='"+mac.getText()+"',";
				  if(isAS==true) AS.get(serv.getNomS()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
				  else if(isDB==true) DB.get(serv.getNomS()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
				  else others.get(serv.getNomS()).setPhysicalAd(new SimpleStringProperty(mac.getText()));
			  }
			  
		  }
		  break;
		  case "cheminfxm" :{ 
				
			  if(cheminfxm.getText().compareTo(serv.getCheminfmx().get())!=0)
		  {
			  SQL=SQL+"cheminfmx='"+cheminfxm.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS()).setCheminfmx(new SimpleStringProperty(cheminfxm.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setCheminfmx(new SimpleStringProperty(cheminfxm.getText()));
			  else others.get(serv.getNomS()).setCheminfmx(new SimpleStringProperty(cheminfxm.getText()));
		  }
		  }
	    break;
		  case "cheminrdf" :{ 
				
			  if(cheminrdf.getText().compareTo(serv.getCheminrdf().get())!=0)
		  {
			  SQL=SQL+"cheminrdf='"+cheminrdf.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS()).setCheminrdf(new SimpleStringProperty(cheminrdf.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setCheminrdf(new SimpleStringProperty(cheminrdf.getText()));
			  else others.get(serv.getNomS()).setCheminrdf(new SimpleStringProperty(cheminrdf.getText()));
		  }
		  }
	    break;
		  case "versionBDD" :{ 
				
			  if(vrsBD.getText().compareTo(serv.getVersionBD().get())!=0)
		  {
			  SQL=SQL+"cheminrdf='"+vrsBD.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS()).setVersionBD(new SimpleStringProperty(vrsBD.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setVersionBD(new SimpleStringProperty(vrsBD.getText()));
			  else others.get(serv.getNomS()).setVersionBD(new SimpleStringProperty(vrsBD.getText()));
		  }
		  }
	    break;
	     
		  case "typeBDD" :{ 
				
			  if(typeBD.getText().compareTo(serv.getTypeBD().get())!=0)
		  {
			  SQL=SQL+"typeBDD='"+typeBD.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS()).setTypeBD(new SimpleStringProperty(typeBD.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setTypeBD(new SimpleStringProperty(typeBD.getText()));
			  else others.get(serv.getNomS()).setTypeBD(new SimpleStringProperty(typeBD.getText()));
		  }
		  }
	    break;
		  case "cheminBDD" :{ 
				
			  if(cheminBD.getText().compareTo(serv.getCheminBD().get())!=0)
		  {
			  SQL=SQL+"cheminBDD='"+cheminBD.getText()+"',";
			  if(isAS==true) AS.get(serv.getNomS()).setCheminBD(new SimpleStringProperty(cheminBD.getText()));
			  else if(isDB==true) DB.get(serv.getNomS()).setCheminBD(new SimpleStringProperty(cheminBD.getText()));
			  else others.get(serv.getNomS()).setCheminBD(new SimpleStringProperty(cheminBD.getText()));
		  }
		  }
	    break;
	     
		  
		  
		  
		  
		  }
		  
		
		  
		  
	  }
	  
		if(osCB.getValue()!=null && osCB.getValue().compareTo(serv.getServerOS().get())!=0) {
				
				SQL=SQL+"os='"+osCB.getSelectionModel().getSelectedItem()+"',";
				osserver.setText(osCB.getSelectionModel().getSelectedItem());
				 if(isAS==true) AS.get(serv.getNomS()).setServerOS(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
				  else if(isDB==true) DB.get(serv.getNomS()).setServerOS(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
				  else others.get(serv.getNomS()).setPhysicalAd(new SimpleStringProperty(osCB.getSelectionModel().getSelectedItem()));
			}
			SQL=SQL.substring(0,SQL.length()-1)+" where servername=? ";
			System.out.print("La requete "+SQL);
			if(!SQL.equals("UPDATE server SET where servername=? ")) {try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(SQL);)
			{
				ps.setString(1,SrvnameActif);
				
				ps.execute();
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SQL="INSERT INTO historique (`nomserver`,`userid`,`datechange`) Values(?,?,?)";
			try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(SQL);)
			{
				LocalDateTime date = LocalDateTime.now(); // gets the current date
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:ss");
				java.sql.Timestamp datetime=java.sql.Timestamp.valueOf(date);
				ps.setString(1,SrvnameActif);
				ps.setString(2,LoginController.getUserConnected());
				ps.setObject(3,datetime);
				ps.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	  
	
	  //end
		servername.setEditable(false);
	    memoire.setEditable(false);
	    cpu.setEditable(false);
	    cartevideo.setEditable(false);
	    mvci.setEditable(false);
	    scsi.setEditable(false);
	    cddvd.setEditable(false);
	    disquedur.setEditable(false);
	    disquedur3.setEditable(false);
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
	 String sql="Delete from server where servername=? ";
	 try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(sql);)
	 { 
		 ps.setString(1,servername.getText());
		 ps.execute();
		 Alert alert=new Alert(Alert.AlertType.INFORMATION);
		    alert.setTitle("Message de confirmation");
		    alert.setHeaderText("Opération exécutée");
		 
		    alert.setContentText("Le serveur "+servername.getText()+"a été supprimé définitivement ");
		    alert.showAndWait();
		 
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 showinfoPane.setVisible(false);
      
  }
	@Override
	public void initialize(URL location, ResourceBundle resources) throws NullPointerException {
		unit.setItems(unity);
		unit.setValue("Mo");
	 configPane.setVisible(false);
	 searchpane.setVisible(false);
		try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement("SELECT nameOs FROM os");)
		{
			  ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	 
	                 
	               data.add(rs.getString("nameOs"));
	               sof.setItems(null);
	               sof.setItems(data); 
	                  
	            }
				
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		changedAttr.clear();
		HardwareForm.setVisible(true);
		reseausystem.setVisible(false);
		descriptionForm.setVisible(false);
		formulairepane.setVisible(false);
		showinfoPane.setVisible(false);
	
		    memoire.setEditable(false);
		    cpu.setEditable(false);
		    cartevideo.setEditable(false);
		    mvci.setEditable(false);
		    scsi.setEditable(false);
		    cddvd.setEditable(false);
		    disquedur.setEditable(false);
		    disquedur3.setEditable(false);
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
		 		
		    memoire.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("memoire")) changedAttr.add("memoire");}
					
				    
			});
			
		    cpu.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) 
		     	{	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("cpu"))changedAttr.add("cpu");  } 
			});
			
		    cartevideo.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("cartevideo"))changedAttr.add("cartevideo");}
					
				    
			});
		    servername.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) 	if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("servername")) changedAttr.add("servername");}
					
				    
			});
			
		    mvci.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) 	if(!oldValue.equals("") || newValue.equals("")&& NO_CHG==false) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("mvci"))changedAttr.add("mvci");}
					
				    
			});
			
		    scsi.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("") || newValue.equals("")&& NO_CHG==false) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("scsi"))	changedAttr.add("scsi");}
				    
			});
			
		    cddvd.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")||newValue.equals("")&& NO_CHG==false) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("cddvd"))changedAttr.add("cddvd");}
				    
			});
			
		    disquedur.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")||newValue.equals("")&& NO_CHG==false) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("disquedur"))changedAttr.add("disquedur");}
				    
			});
		    disquedur3.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")||newValue.equals("")&& NO_CHG==false) {	 
		     	if(!changedAttr.contains("disquedur2"))changedAttr.add("disquedur2");}
				    
			});
			
	        disquette.textProperty().addListener((observable, oldValue, newValue) -> {
	        	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")||newValue.equals("")&& NO_CHG==false) {	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
	         	if(!changedAttr.contains("disquette"))changedAttr.add("disquette");	}
				    
			});
			
		    adaptateurres.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")||newValue.equals("")&& NO_CHG==false) {System.out.println("textfield changed from " + oldValue + " to " + newValue);
			   	if(!changedAttr.contains("adaptateurres"))changedAttr.add("adaptateurres");		
			   	}
			});
			
		    dateinstalation.textProperty().addListener((observable, oldValue, newValue) -> {
		     if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) { System.out.println("textfield changed from " + oldValue + " to " + newValue);
				
		     	if(!changedAttr.contains("dateinstalation"))changedAttr.add("dateinstalation");	}	  
			});
			
		    versionOs.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null&& NO_CHG==false)
		     	if(!oldValue.equals("")|| !newValue.equals("")&& oldValue!=null && newValue!=null) {	 if(!changedAttr.contains("versionOs"))changedAttr.add("versionOs");	}		
				    
			});
			
		    ipv4.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) {  	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("ipv4"))changedAttr.add("ipv4");}	 
			});
			
		    ipv6.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) { 	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		     	if(!changedAttr.contains("ipv6")) changedAttr.add("ipv6");	 } 
			});
			
		    dns.textProperty().addListener((observable, oldValue, newValue) -> {
		     	if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) { 	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("dns"))	changedAttr.add("dns");	}	
				    
			});
			
		    passerelle.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("")|| !newValue.equals("")&& NO_CHG==false) {  	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
		     	if(!changedAttr.contains("passerelle"))changedAttr.add("passerelle");	}
				    
			});
			
		    mac.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("mac"))changedAttr.add("mac");	   }
			});

		    cheminfxm.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null)	if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("cheminfxm"))changedAttr.add("cheminfxm");	   }
			});
		    cheminrdf.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("cheminrdf"))changedAttr.add("cheminrdf");	   }
			});
		    vrsBD.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("versionBDD"))changedAttr.add("versionBDD");	   }
			});
		    typeBD.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("typeBDD"))changedAttr.add("typeBDD");	   }
			});
		    cheminBD.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.equals("") || !newValue.equals("")&& NO_CHG==false) {   	 System.out.println("textfield changed from " + oldValue + " to " + newValue);
					
		    	if(!changedAttr.contains("cheminBDD"))changedAttr.add("cheminBDD");	   }
			});
			
		    description.textProperty().addListener((observable, oldValue, newValue) -> {
		    	if(oldValue!=null && newValue!=null) if(!oldValue.matches("Description") && !newValue.equals("")&& NO_CHG==false) {
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
    			
    		AS.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("cartevideo")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquedur2")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac")),new SimpleStringProperty(rs.getString("cheminfxm")),new SimpleStringProperty(rs.getString("cheminrdf"))));
    		}
    		rs.close();
    		ps.setString(1,"DB");
    		 rs=ps.executeQuery();
    	
    		 while (rs.next())
    		{
    			
    			DB.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("cartevideo")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquedur2")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac")),new SimpleStringProperty(rs.getString("typeBDD")), new SimpleStringProperty(rs.getString("versionBDD")),new SimpleStringProperty(rs.getString("cheminBDD"))));
    		}
    	rs.close();
    	ps.setString(1,"autres");
   		 rs=ps.executeQuery();
   		 others.clear();
   		while (rs.next())
   		{
   			System.out.print(rs.getString("servername"));
   		others.put(rs.getString("servername"),new Server(new SimpleStringProperty(rs.getString("servername")),new SimpleStringProperty(rs.getString("typeserver")),new SimpleStringProperty(rs.getString("memoire")),new SimpleStringProperty(rs.getString("cpu")),new SimpleStringProperty(rs.getString("cartevideo")),new SimpleStringProperty(rs.getString("os")),new SimpleStringProperty(rs.getString("versionOs")),new SimpleStringProperty(rs.getString("dateinstalation")),new SimpleStringProperty(rs.getString("ipv4")),new SimpleStringProperty(rs.getString("ipv4m")),new SimpleStringProperty(rs.getString("ipv6")),new SimpleStringProperty(rs.getString("ipv6m")),new SimpleStringProperty(rs.getString("description")),new SimpleStringProperty(rs.getString("mvci")),new SimpleStringProperty(rs.getString("scsi")),new SimpleStringProperty(rs.getString("scsi")), new SimpleStringProperty(rs.getString("cddvd")),new SimpleStringProperty(rs.getString("disquedur")),new SimpleStringProperty(rs.getString("disquedur2")),new SimpleStringProperty(rs.getString("disquette")), new SimpleStringProperty(rs.getString("adaptateurres")),new SimpleStringProperty(rs.getString("dns")),new SimpleStringProperty(rs.getString("mac"))));
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
    	System.out.print(isAS+"jjjjjjjjjjjjjjj");
      details.setVisible(true);
      if(isAS==true) {detailAS.setVisible(true);detailDB.setVisible(false); }
      else if(isDB==true) {detailAS.setVisible(false);detailDB.setVisible(true);}
      else {detailAS.setVisible(false);detailDB.setVisible(false);}
    }
    void initialiserMenuButton() throws NullPointerException{
    	
    	MenuItem m;
    	for(Server serv :AS.values() ) {
    		m=new MenuItem(serv.getNomS());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    			 if(!((MenuItem) e.getSource()).getText().equals(previous_serv) || previous_serv.equals("init")) {
        			 NO_CHG=true; previous_serv=((MenuItem) e.getSource()).getText();
        		 }
        		 else {NO_CHG=false;previous_serv=((MenuItem) e.getSource()).getText();}
    	   
    			 SrvnameActif=((MenuItem) e.getSource()).getText(); 
    		System.out.println("===="+SrvnameActif);
    	     isAS=true;
    	     isDB=false;
    	     String sql="SELECT userid,max(datechange) FROM sonatrach_servers.historique where nomserver=?" ;
    	     
			try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(sql);){
    	    	 ps.setString(1,((MenuItem) e.getSource()).getText());
    	    	 ResultSet rs=ps.executeQuery();
    	      if(rs.next())   updatephrase.setText("Dernière mise à jour à " +rs.getString("max(datechange)")+" Par "+rs.getString("userid"));
    	   updatephrase.setUnderline(true);
			rs.close();} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cpu.setText(AS.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     memoire.setText(AS.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     
    	     ipv4.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"/"+AS.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     ipv6.setText(AS.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"/"+AS.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     osserver.setText(AS.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     cartevideo.setText(AS.get(((MenuItem) e.getSource()).getText()).getCartevid().get());
    	     mvci.setText(AS.get(((MenuItem) e.getSource()).getText()).getVMCI().get());
    	     scsi.setText(AS.get(((MenuItem) e.getSource()).getText()).getSCSI().get());
    	     cddvd.setText(AS.get(((MenuItem) e.getSource()).getText()).getCDDVD().get());
    	      configPane.setVisible(false);
    	     disquedur.setText(AS.get(((MenuItem) e.getSource()).getText()).getDD().get());
    	     disquedur3.setText(AS.get(((MenuItem) e.getSource()).getText()).getDD().get());
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
    	     details.setVisible(false);
    	     formulairepane.setVisible(false);
    	     searchpane.setVisible(false);
    	     cheminfxm.setText(AS.get(((MenuItem) e.getSource()).getText()).getCheminfmx().get());;//fmx
    	     cheminrdf.setText(AS.get(((MenuItem) e.getSource()).getText()).getCheminrdf().get());;//rdf
    	     
    	    });
    	
    		menuitems.put(m.getText(), m);
    		
    	}
    	ASshow.getItems().setAll(menuitems.values());
    	menuitems.clear();
      	for(Server serv :DB.values() ) {
    		m=new MenuItem(serv.getNomS());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    			 if(((MenuItem) e.getSource()).getText().equals(previous_serv) || previous_serv.equals("init")) {
        			 NO_CHG=true; 
        		 }
        		 else {NO_CHG=false;previous_serv=((MenuItem) e.getSource()).getText();}
    			isAS=false;
        	    isDB=true;
        	      configPane.setVisible(false);
        	      details.setVisible(false);
    	     SrvnameActif=((MenuItem) e.getSource()).getText();
    	     String sql="SELECT userid,max(datechange) FROM sonatrach_servers.historique where nomserver=?" ;
    	     
 			try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(sql);){
     	    	 ps.setString(1,((MenuItem) e.getSource()).getText());
     	    	 ResultSet rs=ps.executeQuery();
     	      if(rs.next())   updatephrase.setText("Dernière mise à jour à " +rs.getString("max(datechange)")+" Par "+rs.getString("userid"));
     	   updatephrase.setUnderline(true);
 			rs.close();} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
     	
       	     servername.setText(((MenuItem) e.getSource()).getText());
       	 memoire.setText(DB.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
   	     ipv4.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"/"+DB.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
   	     ipv6.setText(DB.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"/"+DB.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
   	     osserver.setText(DB.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
   	     cartevideo.setText(DB.get(((MenuItem) e.getSource()).getText()).getCartevid().get());
   	     mvci.setText(DB.get(((MenuItem) e.getSource()).getText()).getVMCI().get());
   	     scsi.setText(DB.get(((MenuItem) e.getSource()).getText()).getSCSI().get());
   	     cddvd.setText(DB.get(((MenuItem) e.getSource()).getText()).getCDDVD().get());
   	     disquedur.setText(DB.get(((MenuItem) e.getSource()).getText()).getDD().get());
   	    disquedur3.setText(DB.get(((MenuItem) e.getSource()).getText()).getDD2().get());
   	     disquette.setText(DB.get(((MenuItem) e.getSource()).getText()).getDisquette().get());
   	     adaptateurres.setText(DB.get(((MenuItem) e.getSource()).getText()).getAdapRes().get());
   	     dateinstalation.setText(DB.get(((MenuItem) e.getSource()).getText()).getDateOS().get());
   	     versionOs.setText(DB.get(((MenuItem) e.getSource()).getText()).getVersionOS().get());
   	     dns.setText(DB.get(((MenuItem) e.getSource()).getText()).getDns().get());
   	     passerelle.setText(DB.get(((MenuItem) e.getSource()).getText()).getPasserelle().get());
   	     mac.setText(DB.get(((MenuItem) e.getSource()).getText()).getPhysicalAd().get());
   	     osserver.setText(DB.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
   	     description.setText(DB.get(((MenuItem) e.getSource()).getText()).getDescription().get());
    	 	vrsBD.setText(DB.get(((MenuItem) e.getSource()).getText()).getVersionBD().get());
 	    	typeBD.setText(DB.get(((MenuItem) e.getSource()).getText()).getTypeBD().get());
 	    	cheminBD.setText(DB.get(((MenuItem) e.getSource()).getText()).getCheminBD().get());;
    	     showinfoPane.setVisible(true);
    	     formulairepane.setVisible(false);
    	     searchpane.setVisible(false);
    	     
    	    });
    	
    		menuitems.put(m.getText(),m);
    		
    	}
    	
    	DBshow.getItems().setAll(menuitems.values());
    	menuitems.clear();
    	for(Server serv :others.values() ) {
    		m=new MenuItem(serv.getNomS());m.addEventHandler(ActionEvent.ACTION,(e) -> {
    			 if(((MenuItem) e.getSource()).getText().equals(previous_serv) || previous_serv.equals("init")) {
        			 NO_CHG=true; 
        		 }
        		 else {NO_CHG=false;previous_serv=((MenuItem) e.getSource()).getText();}
    	     SrvnameActif=((MenuItem) e.getSource()).getText(); 
    	    isAS=false;
    	    isDB=false;
    	    details.setVisible(false);
    	      configPane.setVisible(false);
    	     servername.setText(((MenuItem) e.getSource()).getText());
    	     cpu.setText(others.get(((MenuItem) e.getSource()).getText()).getCPU().get());
    	     memoire.setText(others.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
    	     String sql="SELECT userid,max(datechange) FROM sonatrach_servers.historique where nomserver=?" ;
    	     
 			try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(sql);){
     	    	 ps.setString(1,((MenuItem) e.getSource()).getText());
     	    	 ResultSet rs=ps.executeQuery();
     	      if(rs.next())   updatephrase.setText("Dernière mise à jour à " +rs.getString("max(datechange)")+" Par "+rs.getString("userid"));
     	   updatephrase.setUnderline(true);
 			rs.close();} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
     	
    	     ipv4.setText(others.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"/"+others.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
    	     ipv6.setText(others.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"/"+others.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
    	     osserver.setText(others.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     cartevideo.setText(others.get(((MenuItem) e.getSource()).getText()).getCartevid().get());
    	     mvci.setText(others.get(((MenuItem) e.getSource()).getText()).getVMCI().get());
    	     scsi.setText(others.get(((MenuItem) e.getSource()).getText()).getSCSI().get());
    	     cddvd.setText(others.get(((MenuItem) e.getSource()).getText()).getCDDVD().get());
    	     disquedur.setText(others.get(((MenuItem) e.getSource()).getText()).getDD().get());
    	     disquedur3.setText(others.get(((MenuItem) e.getSource()).getText()).getDD2().get());
    	     disquette.setText(others.get(((MenuItem) e.getSource()).getText()).getDisquette().get());
    	     adaptateurres.setText(others.get(((MenuItem) e.getSource()).getText()).getAdapRes().get());
    	     dateinstalation.setText(others.get(((MenuItem) e.getSource()).getText()).getDateOS().get());
    	     versionOs.setText(others.get(((MenuItem) e.getSource()).getText()).getVersionOS().get());
    	     dns.setText(others.get(((MenuItem) e.getSource()).getText()).getDns().get());
    	     passerelle.setText(others.get(((MenuItem) e.getSource()).getText()).getPasserelle().get());
    	     mac.setText(others.get(((MenuItem) e.getSource()).getText()).getPhysicalAd().get());
    	     osserver.setText(others.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
    	     description.setText(others.get(((MenuItem) e.getSource()).getText()).getDescription().get());
    	     showinfoPane.setVisible(true);
    	     formulairepane.setVisible(false);
    	     searchpane.setVisible(false);
 
    	     
    	    });
    	
    		menuitems.put(m.getText(), m);
    		
    	}
    	
    	othersShow.getItems().setAll(menuitems.values());
    	menuitems.clear();
    	
    	
    	
    }
   void majMenuButton (ObservableMap<String,Server> map,MenuButton button) throws NullPointerException{
	   MenuItem m;
		ObservableMap<String,MenuItem> menuitem =FXCollections.observableHashMap();
		for(Server serv :map.values() ) {
    	 m=new MenuItem(serv.getNomS());
    	 m.addEventHandler(ActionEvent.ACTION,(e) -> {
    		 if(!((MenuItem) e.getSource()).getText().equals(previous_serv) || previous_serv.equals("init")) {
    			 NO_CHG=true; 
    			 previous_serv=((MenuItem) e.getSource()).getText();
    		 }
    		 else {NO_CHG=false;previous_serv=((MenuItem) e.getSource()).getText();}
    		 String sql="SELECT userid,max(datechange) FROM sonatrach_servers.historique where nomserver=?" ;
    	     
 			try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(sql);){
     	    	 ps.setString(1,((MenuItem) e.getSource()).getText());
     	    	 ResultSet rs=ps.executeQuery();
     	      if(rs.next())   updatephrase.setText("Dernière mise à jour à " +rs.getString("max(datechange)")+" Par "+rs.getString("userid"));
     	   updatephrase.setUnderline(true);
 			rs.close();} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
     	
    		 
    		 
    		 showinfoPane.setVisible(true);
    		   formulairepane.setVisible(false);
    		   searchpane.setVisible(false);
    	details.setVisible(false);
    	SrvnameActif=((MenuItem) e.getSource()).getText(); 
        configPane.setVisible(false);
 	     servername.setText(((MenuItem) e.getSource()).getText());
 	     cpu.setText(map.get(((MenuItem) e.getSource()).getText()).getCPU().get());
 	     memoire.setText(map.get(((MenuItem) e.getSource()).getText()).getMemoire().get());
 	   
 	     ipv4.setText(map.get(((MenuItem) e.getSource()).getText()).getIpv4a().get()+"/"+map.get(((MenuItem) e.getSource()).getText()).getIpv4m().get());
 	     ipv6.setText(map.get(((MenuItem) e.getSource()).getText()).getIpv6a().get()+"/"+map.get(((MenuItem) e.getSource()).getText()).getIpv6m().get());
 	     osserver.setText(map.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
 	     cartevideo.setText(map.get(((MenuItem) e.getSource()).getText()).getCartevid().get());
 	     mvci.setText(map.get(((MenuItem) e.getSource()).getText()).getVMCI().get());
 	     scsi.setText(map.get(((MenuItem) e.getSource()).getText()).getSCSI().get());
 	     cddvd.setText(map.get(((MenuItem) e.getSource()).getText()).getCDDVD().get());
 	     disquedur.setText(map.get(((MenuItem) e.getSource()).getText()).getDD().get());
 	    disquedur3.setText(map.get(((MenuItem) e.getSource()).getText()).getDD2().get());
 	     disquette.setText(map.get(((MenuItem) e.getSource()).getText()).getDisquette().get());
 	     adaptateurres.setText(map.get(((MenuItem) e.getSource()).getText()).getAdapRes().get());
 	     dateinstalation.setText(map.get(((MenuItem) e.getSource()).getText()).getDateOS().get());
 	     versionOs.setText(map.get(((MenuItem) e.getSource()).getText()).getVersionOS().get());
 	     dns.setText(map.get(((MenuItem) e.getSource()).getText()).getDns().get());
 	     passerelle.setText(map.get(((MenuItem) e.getSource()).getText()).getPasserelle().get());
 	     mac.setText(map.get(((MenuItem) e.getSource()).getText()).getPhysicalAd().get());
 	     osserver.setText(map.get(((MenuItem) e.getSource()).getText()).getServerOS().get());
 	     description.setText(map.get(((MenuItem) e.getSource()).getText()).getDescription().get());
 	     showinfoPane.setVisible(true);
 	     if (button.getText()=="Application Servers")
 	     {

 	        cheminfxm.setText(map.get(((MenuItem) e.getSource()).getText()).getCheminfmx().get());;
 	        cheminrdf.setText(map.get(((MenuItem) e.getSource()).getText()).getCheminrdf().get());;
 	        isAS=true;
 	        isDB=false;
 	     }
 	     else if(button.getText()=="DB Servers") {
 	    	vrsBD.setText(map.get(((MenuItem) e.getSource()).getText()).getVersionBD().get());
 	    	typeBD.setText(map.get(((MenuItem) e.getSource()).getText()).getTypeBD().get());
 	    	 cheminBD.setText(map.get(((MenuItem) e.getSource()).getText()).getCheminBD().get());
 	       isAS=false;
	       isDB=true;
 	     }
 	     else {   isAS=false;
	        isDB=false;}
 	       
 	     
 	    });
 	
    	 menuitem.put(m.getText(),m);
		}
		button.getItems().setAll(menuitem.values());
   }
   @FXML
   void addAS(ActionEvent event) {
       isDB=false;       
	   isAS=true;
	   showinfoPane.setVisible(false);
              formulairepane.setVisible(true);
              configPane.setVisible(false);
       	   searchpane.setVisible(false);
              HardwareForm.setVisible(true);
              
   }

   @FXML
   void addDB(ActionEvent event) {
	   isAS=false;
       isDB=true;
    
     showinfoPane.setVisible(false);
      configPane.setVisible(false);
	   searchpane.setVisible(false);
     formulairepane.setVisible(true);
     HardwareForm.setVisible(true);
   }

   @FXML
   void addserver(ActionEvent event) {
	   configPane.setVisible(false);
	   isAS=false;isDB=false;
	   showinfoPane.setVisible(false);
	   formulairepane.setVisible(true);

	   searchpane.setVisible(false);
	   HardwareForm.setVisible(true);
   }
   //HardForm
   @FXML
   void suivant1(ActionEvent event) { 
	      	 nomserv=nomserveur.getText();
	      	 
	      	 memoir=memoire1.getText()+unit.getSelectionModel().getSelectedItem();
	      	 
	 		 cpuu=cpu1.getText();
	 		 
	 		 cartvd=cartevd.getText();
	 		 
	 		 vm=vmci.getText();
	 		 
	 		 cntrlr=controleur.getText(); 
	 		 
	 		 lctcd=lectcd.getText();
	 		 
	 	     disqdr1=disquedur1.getText();
	 	     disqdr2=disquedur2.getText();
	 		 lectdisq=lecteurdedisquette1.getText();
	 		 adptrs=adaptateurrs1.getText();
	 		 HardwareForm.setVisible(false);
	 		 reseausystem.setVisible(true);
   }
   //ResSysForm
   @FXML
   void suivant2(ActionEvent event) {
	   
	   ipv44=ipv4f.getText();
       masqipv4=msqipv4f.getText();   

        psrl=  passerellef.getText();
        dnns=dnsf.getText();
         ipv66=ipv6f.getText();
        masqipv6=msqipv6f.getText(); 
          adressePhysique=macf.getText();
          os=sof.getSelectionModel().getSelectedItem();
         dat = datef.getValue();
         versionsys=versionf.getText();
         reseausystem.setVisible(false);
     
	   if(isAS==true) {
		   cheminfmxf.setDisable(false);
		   cheminrdff.setDisable(false);
		   versionBDDf.setDisable(true);
		   typeBDDf.setDisable(true);
		   cheminBDf.setDisable(true);
	   }
	   else if(isDB==true) {
		   versionBDDf.setDisable(false);
		   typeBDDf.setDisable(false);
		   cheminBDf.setDisable(false);
		   cheminfmxf.setDisable(true);
		   cheminrdff.setDisable(true);
	   }
	   else {
		   versionBDDf.setDisable(true);
		   typeBDDf.setDisable(true);
		   cheminBDf.setDisable(true);
		   cheminfmxf.setDisable(true);
		   cheminrdff.setDisable(true);
		   
	   }
	    descriptionForm.setVisible(true);

   }

   @FXML
   void retour1(ActionEvent event) {
	   
		 HardwareForm.setVisible(true);
 		 reseausystem.setVisible(false);

   }
   @FXML
   void search(ActionEvent event) {
	   showinfoPane.setVisible(false);
	   formulairepane.setVisible(false);
	   searchpane.setVisible(true);
	   	mott= searchbar.getText();
    	
        String query = " select servername from server where  memoire =? or cpu =? or cartevideo =? or mvci =? or scsi =? or cddvd =? or disquedur =? or disquette =? or adaptateurres =? or os =? or ipv4 =? or ipv4m=? or dns =? or ipv6 =? or ipv6m =? or mac =?  or passerelle=?";
    	 try(Connection conn=DBconnection.getConnection();PreparedStatement preparedStmt = conn.prepareStatement(query);){
      	
      	  preparedStmt.setString (1, mott);
      	  preparedStmt.setString (2,mott );
      	  preparedStmt.setString (3, mott);
      	  preparedStmt.setString (4, mott);
      	  preparedStmt.setString (5, mott);
      	  preparedStmt.setString (6, mott);
      	  preparedStmt.setString (7, mott);
       	  preparedStmt.setString (8, mott);
      	  preparedStmt.setString (9, mott);
      	  preparedStmt.setString (10, mott);
      	  preparedStmt.setString (11, mott);
      	  preparedStmt.setString (12, mott);
      	  preparedStmt.setString (13, mott);
      	  preparedStmt.setString (14, mott);
      	  preparedStmt.setString (15, mott);
      	  preparedStmt.setString (16, mott);
      
      	  preparedStmt.setString(17,mott);
      	
      	  
    	
    	
    	
    	ResultSet rs = preparedStmt.executeQuery();
    	 noms.setCellValueFactory(new PropertyValueFactory<Server,String>("nomS"));
      
            while (rs.next()) {
            	rechercherr.add(new Server(new SimpleStringProperty(rs.getString("servername")),null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
            	                         
            }
         //    noms.setCellValueFactory(new PropertyValueFactory<>("servername"));
    	   //  tableresult.getItems().addAll("serv");
            tableresult.setItems(rechercherr);
    	 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

   }

   @FXML
   void enregistrer(ActionEvent event) {
	   String query="";
	   if(isAS==true) {
		   query = " insert into server (servername,memoire,cpu,cartevideo,mvci,scsi,cddvd,disquedur,disquette,adaptateurres"
		   		+    ",os,ipv4,ipv4m,dns,ipv6,ipv6m,mac,dateinstalation,versionOs,passerelle,"
		   		+ "description,cheminfxm,typeserver,cheminrdf,disquedur2)"
     		        + " values (?,?,?,?,?,?,?,?,?,?"
     		        + ",?,?,?,?,?,?,?,?,?,?"
     		        + ",?,?,?,?"
     		        + ",?)";
	   }
	   else if(isDB==true) {
		    query = " insert into server (servername,memoire,cpu,cartevideo,mvci,scsi,cddvd,disquedur,disquette,adaptateurres"
			   		+    ",os,ipv4,ipv4m,dns,ipv6,ipv6m,mac,dateinstalation,versionOs,passerelle,"
			   		+ "description,versionBDD,typeBDD,typeserver,cheminBDD,disquedur2)"
	     		        + " values (?,?,?,?,?,?,?,?,?,?"
	     		        + ",?,?,?,?,?,?,?,?,?,?"
	     		        + ",?,?,?,?,?,"
	     		        + "?)";
		
	   }
	   else {
		    query = " insert into server (servername,memoire,cpu,cartevideo,mvci,scsi,cddvd,disquedur,disquette,adaptateurres"
			   		+    ",os,ipv4,ipv4m,dns,ipv6,ipv6m,mac,dateinstalation,versionOs,passerelle,"
			   		+ "description,disquedur2)" + " values (?,?,?,?,?,?,?,?,?,?"
     		        + ",?,?,?,?,?,?,?,?,?,?"
     		        + ",?,?)";   
	   }
	   
	   try(Connection conn=DBconnection.getConnection();PreparedStatement ps=conn.prepareStatement(query);)
	   {  
		   ps.setString (1, nomserv);
	      	  ps.setString (2, memoir);
	      	  ps.setString (3,cpuu );
	      	  ps.setString (4, cartvd);
	      	  ps.setString (5, vm);
	      	  ps.setString (6, cntrlr);
	      	  ps.setString (7, lctcd);
	      	  ps.setString (8, disqdr1);
	       	  ps.setString (9, lectdisq);
	      	  ps.setString (10, adptrs);
	      	  ps.setString (11,os);
	      	  ps.setString (12, ipv44);
	      	  ps.setString (13, masqipv4);
	      	  ps.setString (14, dnns);
	      	  ps.setString (15, ipv66);
	      	  ps.setString (16, masqipv6);
	      	  ps.setString (17, adressePhysique);
	      if(dat!=null) ps.setDate(18,java.sql.Date.valueOf(dat));
	      else ps.setDate(18,null);
	      	  ps.setString (19, versio);
	      	  ps.setString(20,psrl);
	      	  ps.setString(21,descriptionf.getText());
	      	 ps.setString (25, disqdr2);
		   if(isAS==true)
		   {ps.setString (22,cheminfmxf.getText()); ps.setString (24,cheminrdff.getText());
		   if (dat!=null) 
		   AS.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("AS"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio), new SimpleStringProperty(dat.getYear()+"/"+dat.getMonthValue()+"/"+dat.getDayOfMonth())
		   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique),new SimpleStringProperty(cheminfmxf.getText()), new SimpleStringProperty(cheminrdff.getText())));
		   else 
			   AS.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("AS"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio),null
					   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique),new SimpleStringProperty(cheminfmxf.getText()), new SimpleStringProperty(cheminrdff.getText())));
		   majMenuButton(AS, ASshow);
		   ps.setString(23,"AS");
			 ps.setString (25, disqdr2);}
		   else if(isDB==true) {
		   ps.setString (22,versionBDDf.getText());
		   ps.setString (23,typeBDDf.getText());
		   ps.setString (25,cheminBDf.getText());
		   ps.setString(24,"DB");
		   ps.setString (26, disqdr2);
		   
		   if (dat!=null)  DB.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("DB"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio), new SimpleStringProperty(dat.getYear()+"/"+dat.getMonthValue()+"/"+dat.getDayOfMonth())
				   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique),new SimpleStringProperty(typeBDDf.getText()),
					new SimpleStringProperty(versionBDDf.getText()),new SimpleStringProperty(cheminBDf.getText())));
		   else DB.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("DB"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio), new SimpleStringProperty(null)
				   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique),new SimpleStringProperty(typeBDDf.getText()),
					new SimpleStringProperty(versionBDDf.getText()),new SimpleStringProperty(cheminBDf.getText())));
		   majMenuButton(DB, DBshow);}
		   else {	   ps.setString (22, disqdr2);
		   if (dat!=null)  others.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("autres"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio), new SimpleStringProperty(dat.getYear()+"/"+dat.getMonthValue()+"/"+dat.getDayOfMonth())
				   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique)));
		   else others.put(nomserv,new Server(new SimpleStringProperty(nomserv),new SimpleStringProperty("autres"),new SimpleStringProperty( memoir), new SimpleStringProperty(cpuu),new SimpleStringProperty( cartvd),new SimpleStringProperty(os), new SimpleStringProperty(versio), new SimpleStringProperty(null)
				   , new SimpleStringProperty(ipv44),new SimpleStringProperty(masqipv4),new SimpleStringProperty( ipv66), new SimpleStringProperty(masqipv6),new SimpleStringProperty( descriptionf.getText()),new SimpleStringProperty(vm),new SimpleStringProperty(cntrlr),new SimpleStringProperty(lctcd),new SimpleStringProperty(disqdr1),new SimpleStringProperty(disqdr2),new SimpleStringProperty(lectdisq),new SimpleStringProperty(adptrs), new SimpleStringProperty(dnns),new SimpleStringProperty(psrl),new SimpleStringProperty(adressePhysique)));
		   majMenuButton(others, othersShow);}
		
		   ps.execute();
		   
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   descriptionForm.setVisible(false);
	   formulairepane.setVisible(false);
	   showinfoPane.setVisible(false);
	   configPane.setVisible(false);
	   

   }

   @FXML
   void Parametres(ActionEvent event) {
	 	   formulairepane.setVisible(false);
	   showinfoPane.setVisible(false);
	   searchpane.setVisible(false);
	   configPane.setVisible(true);
	   configmenu.setVisible(true);
	   addospane.setVisible(false);
   }
   @FXML
   JFXTextField sys;
   @FXML
   void AddOS(ActionEvent event) {
	   configmenu.setVisible(false);
	   addospane.setVisible(true);}
   @FXML
   void confirmadd(ActionEvent event) {
	if(sys.getText()!="")   try(Connection conn=DBconnection.getConnection();PreparedStatement preparedStmt = conn.prepareStatement("insert into os (nameOs) values(?)");){
		   
		   preparedStmt.setString(1,sys.getText());
		   preparedStmt.execute();
		   
		   
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	 configmenu.setVisible(true);
	 addospane.setVisible(false);
	 sys.clear();
   }
   @FXML
   JFXPasswordField newpwd;
   
   @FXML
   void changepwd(ActionEvent event) {
	   configmenu.setVisible(false);
	   pwdpane.setVisible(true);}
   
   
   @FXML
   void confirmpwdchange(ActionEvent event) {
	if(oldpwd.getText()!="")   try(Connection conn=DBconnection.getConnection();PreparedStatement preparedStmt = conn.prepareStatement("select passwd from user where userid=?");){
		   
		   preparedStmt.setString(1,LoginController.getUserConnected());
		   ResultSet rs=preparedStmt.executeQuery();
		  if(rs.next()) 
		  {
			   if(rs.getString("passwd").equals(oldpwd.getText())){  
				try(PreparedStatement ps=conn.prepareStatement("UPDATE user SET passwd=? where userid=?");){
					 ps.setString(1,newpwd.getText());
					 ps.setString(2,LoginController.getUserConnected());
					   ps.execute();
                       configPane.setVisible(false);
                       pwdpane.setVisible(false);
					
				}
				
		   }
			   else {
				   
				   
				   
				   Alert alert=new Alert(Alert.AlertType.ERROR);
				    alert.setTitle("Message d'erreur");
				    alert.setHeaderText("");
				 
				    alert.setContentText("ancien mot de passe erroné :( ");
				    alert.showAndWait();
			   }
		  		   }
		   
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	 configmenu.setVisible(true);
	 addospane.setVisible(false);
	 sys.clear();
   }
   @FXML
  private AnchorPane header;
   @FXML
   void imprimer(ActionEvent event) {
	   VBox v=new VBox();
	   v.getChildren().add(servername);
	   v.getChildren().add(materiel);
	   v.getChildren().add(systmres);
	
	   v.setSpacing(10);
	   print(v);

   }
   public void print(final Node node) {
       Printer printer = Printer.getDefaultPrinter();
      
       PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
       double oldX,oldY;
       oldX=node.getBoundsInParent().getWidth();
       oldY=node.getBoundsInParent().getHeight();
      double scaleX = pageLayout.getPrintableWidth() / node.getBoundsInLocal().getWidth();
       double scaleY = pageLayout.getPrintableHeight() /node.getBoundsInLocal().getHeight();
   //   node.getTransforms().add(new Scale(scaleX, scaleY));     
    
       PrinterJob job = PrinterJob.createPrinterJob();
       
       if (job != null  ) {
    	   job.showPrintDialog(null);
    	   
          boolean success = job.printPage(pageLayout,node);
          job.endJob();
 
        
       
      /*
        if (success) {
        	   System.out.print("ennnd2");
        	  
               adminjob.endJob();}
             */
   //         
           
       }
       
       if(!matbox.getChildren().contains(materiel))   matbox.getChildren().add(materiel);
       if(!sysbox.getChildren().contains(systmres))   sysbox.getChildren().add(systmres);
       servername.setTranslateX(25.0);
       servername.setTranslateY(8.0);
       if(!header.getChildren().contains(servername))   header.getChildren().add(servername);
   }




}