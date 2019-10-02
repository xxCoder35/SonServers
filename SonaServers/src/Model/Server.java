package Model;

import javafx.beans.property.SimpleStringProperty;

public class Server {

	public SimpleStringProperty getDescription() {
		return Description;
	}
	public void setDescription(SimpleStringProperty description) {
		Description = description;
	}
	private SimpleStringProperty nomS;
	private SimpleStringProperty typeS;
    private SimpleStringProperty versionserver;
    private SimpleStringProperty memoire;
    private SimpleStringProperty CPU;
    private SimpleStringProperty serverOS;
    private SimpleStringProperty versionOS;
    private SimpleStringProperty dateOS;
    private SimpleStringProperty ipv4a;
    private SimpleStringProperty ipv4m;
    private SimpleStringProperty ipv6a;
    private SimpleStringProperty ipv6m;
    private SimpleStringProperty Description;
    private SimpleStringProperty VMCI;
    private SimpleStringProperty SCSI;
    private SimpleStringProperty CDDVD;
    private SimpleStringProperty DD;
    private SimpleStringProperty disquette;
    private SimpleStringProperty adapRes;
    private SimpleStringProperty dns;
    private SimpleStringProperty passerelle;
    private SimpleStringProperty physicalAd;
    private SimpleStringProperty solutionHeb;
  
	//FOR AS
    private SimpleStringProperty cheminSrc;
    //FOR DBS
    private SimpleStringProperty typeBD;
    private SimpleStringProperty versionBD;
//Constructeur for others
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS, SimpleStringProperty versionserver,
			SimpleStringProperty memoire, SimpleStringProperty cPU, SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd) {
		super();
		this.nomS = nomS;
		this.typeS = typeS;
		this.versionserver = versionserver;
		this.memoire = memoire;
		CPU = cPU;
		this.serverOS = serverOS;
		this.versionOS = versionOS;
		this.dateOS = dateOS;
		this.ipv4a = ipv4a;
		this.ipv4m = ipv4m;
		this.ipv6a = ipv6a;
		this.ipv6m = ipv6m;
		Description = description;
		VMCI = vMCI;
		SCSI = sCSI;
		CDDVD = cDDVD;
		DD = dD;
		this.disquette = disquette;
		this.adapRes = adapRes;
		this.dns = dns;
		this.passerelle = passerelle;
		this.physicalAd = physicalAd;
	}
	//COnstructeur AS
	
	public SimpleStringProperty getNomS() {
		return nomS;
	}
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS, SimpleStringProperty versionserver,
			SimpleStringProperty memoire, SimpleStringProperty cPU, SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd, SimpleStringProperty solutionHeb, SimpleStringProperty cheminSrc) {
		super();
		this.nomS = nomS;
		this.typeS = typeS;
		this.versionserver = versionserver;
		this.memoire = memoire;
		CPU = cPU;
		this.serverOS = serverOS;
		this.versionOS = versionOS;
		this.dateOS = dateOS;
		this.ipv4a = ipv4a;
		this.ipv4m = ipv4m;
		this.ipv6a = ipv6a;
		this.ipv6m = ipv6m;
		Description = description;
		VMCI = vMCI;
		SCSI = sCSI;
		CDDVD = cDDVD;
		DD = dD;
		this.disquette = disquette;
		this.adapRes = adapRes;
		this.dns = dns;
		this.passerelle = passerelle;
		this.physicalAd = physicalAd;
		this.solutionHeb = solutionHeb;
		this.cheminSrc = cheminSrc;
	}
	//construct DB 
	
	public void setNomS(SimpleStringProperty nomS) {
		this.nomS = nomS;
	}
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS, SimpleStringProperty versionserver,
			SimpleStringProperty memoire, SimpleStringProperty cPU, SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd, SimpleStringProperty solutionHeb, SimpleStringProperty typeBD,
			SimpleStringProperty versionBD) {
		super();
		this.nomS = nomS;
		this.typeS = typeS;
		this.versionserver = versionserver;
		this.memoire = memoire;
		CPU = cPU;
		this.serverOS = serverOS;
		this.versionOS = versionOS;
		this.dateOS = dateOS;
		this.ipv4a = ipv4a;
		this.ipv4m = ipv4m;
		this.ipv6a = ipv6a;
		this.ipv6m = ipv6m;
		Description = description;
		VMCI = vMCI;
		SCSI = sCSI;
		CDDVD = cDDVD;
		DD = dD;
		this.disquette = disquette;
		this.adapRes = adapRes;
		this.dns = dns;
		this.passerelle = passerelle;
		this.physicalAd = physicalAd;
		this.solutionHeb = solutionHeb;
		this.typeBD = typeBD;
		this.versionBD = versionBD;
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
