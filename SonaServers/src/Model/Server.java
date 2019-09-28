package Model;

import javafx.beans.property.SimpleStringProperty;

public class Server {
	private SimpleStringProperty nomS;
	private SimpleStringProperty typeS;
    private SimpleStringProperty versionserver;
    private SimpleStringProperty memoire;
    private SimpleStringProperty CPU;
    private SimpleStringProperty serverOS;
    //Réseau
    private SimpleStringProperty ipv4a;
    private SimpleStringProperty ipv4m;
    private SimpleStringProperty ipv6a;
    private SimpleStringProperty ipv6m;
    public SimpleStringProperty getNomS() {
		return nomS;
	}
	public void setNomS(SimpleStringProperty nomS) {
		this.nomS = nomS;
	}
	public SimpleStringProperty getTypeS() {
		return typeS;
	}
	public void setTypeS(SimpleStringProperty typeS) {
		this.typeS = typeS;
	}
	public SimpleStringProperty getVersionserver() {
		return versionserver;
	}
	public void setVersionserver(SimpleStringProperty versionserver) {
		this.versionserver = versionserver;
	}
	public SimpleStringProperty getMemoire() {
		return memoire;
	}
	public void setMemoire(SimpleStringProperty memoire) {
		this.memoire = memoire;
	}
	public SimpleStringProperty getCPU() {
		return CPU;
	}
	public void setCPU(SimpleStringProperty cPU) {
		CPU = cPU;
	}
	public SimpleStringProperty getServerOS() {
		return serverOS;
	}
	public void setServerOS(SimpleStringProperty serverOS) {
		this.serverOS = serverOS;
	}
	public SimpleStringProperty getIpv4a() {
		return ipv4a;
	}
	public void setIpv4a(SimpleStringProperty ipv4a) {
		this.ipv4a = ipv4a;
	}
	public SimpleStringProperty getIpv4m() {
		return ipv4m;
	}
	public void setIpv4m(SimpleStringProperty ipv4m) {
		this.ipv4m = ipv4m;
	}
	public SimpleStringProperty getIpv6a() {
		return ipv6a;
	}
	public void setIpv6a(SimpleStringProperty ipv6a) {
		this.ipv6a = ipv6a;
	}
	public SimpleStringProperty getIpv6m() {
		return ipv6m;
	}
	public void setIpv6m(SimpleStringProperty ipv6m) {
		this.ipv6m = ipv6m;
	}
	

}
