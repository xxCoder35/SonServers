package Model;

import javafx.beans.property.SimpleStringProperty;

public class CompteUser {
	
	private SimpleStringProperty nom;
	private SimpleStringProperty prenom;
    private String role; 
    private SimpleStringProperty Userid;
    private String password ;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SimpleStringProperty getUserid() {
		return Userid;
	}
	public void setUserid(SimpleStringProperty userid) {
		Userid = userid;
	}
	public SimpleStringProperty getNom() {
		return nom;
	}
	public SimpleStringProperty getPrenom() {
		return prenom;
	}
    
	public boolean Seconnecter()
	{
		
		
		
		
		return false;
		
		
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
