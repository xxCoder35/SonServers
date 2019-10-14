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
    private SimpleStringProperty DD2;
    public SimpleStringProperty getDD2() {
		return DD2;
	}
	public void setDD2(SimpleStringProperty dD2) {
		DD2 = dD2;
	}
	private SimpleStringProperty disquette;
    private SimpleStringProperty cartevid;
    private SimpleStringProperty adapRes;
    private SimpleStringProperty dns;
    private SimpleStringProperty passerelle;
    private SimpleStringProperty physicalAd;
   
  
	//FOR AS
    private SimpleStringProperty cheminfmx;
    private SimpleStringProperty cheminrdf;
    //FOR DBS
    private SimpleStringProperty typeBD;
    private SimpleStringProperty versionBD;
    private SimpleStringProperty cheminBD;
//Constructeur for others
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS,
			SimpleStringProperty memoire, SimpleStringProperty cPU,SimpleStringProperty carteVid,SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD, SimpleStringProperty dD2, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd) {
		super();
		this.nomS = nomS;
		this.DD2=dD2;
		this.cartevid=carteVid;
		this.typeS = typeS;
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
	
	public String getNomS() {
		return nomS.get();
	}
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS,
			SimpleStringProperty memoire, SimpleStringProperty cPU,SimpleStringProperty carteVid, SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD,SimpleStringProperty dD2, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd, SimpleStringProperty cheminfmx, SimpleStringProperty cheminrdf) {
		super();
		this.nomS = nomS;
		this.typeS = typeS;
		this.memoire = memoire;
		this.DD2=dD2;
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
	  this.cartevid=carteVid;
		this.cheminfmx = cheminfmx;
		this.cheminrdf=cheminrdf;
	}
	//construct DB 
	
	public SimpleStringProperty getCheminfmx() {
		return cheminfmx;
	}
	public void setCheminfmx(SimpleStringProperty cheminfmx) {
		this.cheminfmx = cheminfmx;
	}
	public SimpleStringProperty getCheminrdf() {
		return cheminrdf;
	}
	public void setCheminrdf(SimpleStringProperty cheminrdf) {
		this.cheminrdf = cheminrdf;
	}
	public SimpleStringProperty getCheminBD() {
		return cheminBD;
	}
	public void setCheminBD(SimpleStringProperty cheminBD) {
		this.cheminBD = cheminBD;
	}
	public void setNomS(SimpleStringProperty nomS) {
		this.nomS = nomS;
	}
	public Server(SimpleStringProperty nomS, SimpleStringProperty typeS,
			SimpleStringProperty memoire, SimpleStringProperty cPU,SimpleStringProperty carteVid, SimpleStringProperty serverOS,
			SimpleStringProperty versionOS, SimpleStringProperty dateOS, SimpleStringProperty ipv4a,
			SimpleStringProperty ipv4m, SimpleStringProperty ipv6a, SimpleStringProperty ipv6m,
			SimpleStringProperty description, SimpleStringProperty vMCI, SimpleStringProperty sCSI,
			SimpleStringProperty cDDVD, SimpleStringProperty dD,SimpleStringProperty dD2, SimpleStringProperty disquette,
			SimpleStringProperty adapRes, SimpleStringProperty dns, SimpleStringProperty passerelle,
			SimpleStringProperty physicalAd, SimpleStringProperty typeBD,
			SimpleStringProperty versionBD,SimpleStringProperty cheminBDD) {
		super();
		this.cartevid=carteVid;
		this.nomS = nomS;
		this.typeS = typeS;
		
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
		 this.cartevid=carteVid;
		VMCI = vMCI;
		SCSI = sCSI;
		CDDVD = cDDVD;
		DD = dD;
		DD2 = dD2;
		this.disquette = disquette;
		this.adapRes = adapRes;
		this.dns = dns;
		this.passerelle = passerelle;
		this.physicalAd = physicalAd;
		
		this.typeBD = typeBD;
		this.versionBD = versionBD;
		this.cheminBD=cheminBDD;
	}
	public SimpleStringProperty getCartevid() {
		return cartevid;
	}
	public void setCartevid(SimpleStringProperty cartevid) {
		this.cartevid = cartevid;
	}
	public SimpleStringProperty getVersionOS() {
		return versionOS;
	}
	public void setVersionOS(SimpleStringProperty versionOS) {
		this.versionOS = versionOS;
	}
	public SimpleStringProperty getDateOS() {
		return dateOS;
	}
	public void setDateOS(SimpleStringProperty dateOS) {
		this.dateOS = dateOS;
	}
	public SimpleStringProperty getVMCI() {
		return VMCI;
	}
	public void setVMCI(SimpleStringProperty vMCI) {
		VMCI = vMCI;
	}
	public SimpleStringProperty getSCSI() {
		return SCSI;
	}
	public void setSCSI(SimpleStringProperty sCSI) {
		SCSI = sCSI;
	}
	public SimpleStringProperty getCDDVD() {
		return CDDVD;
	}
	public void setCDDVD(SimpleStringProperty cDDVD) {
		CDDVD = cDDVD;
	}
	public SimpleStringProperty getDD() {
		return DD;
	}
	public void setDD(SimpleStringProperty dD) {
		DD = dD;
	}
	public SimpleStringProperty getDisquette() {
		return disquette;
	}
	public void setDisquette(SimpleStringProperty disquette) {
		this.disquette = disquette;
	}
	public SimpleStringProperty getAdapRes() {
		return adapRes;
	}
	public void setAdapRes(SimpleStringProperty adapRes) {
		this.adapRes = adapRes;
	}
	public SimpleStringProperty getDns() {
		return dns;
	}
	public void setDns(SimpleStringProperty dns) {
		this.dns = dns;
	}
	public SimpleStringProperty getPasserelle() {
		return passerelle;
	}
	public void setPasserelle(SimpleStringProperty passerelle) {
		this.passerelle = passerelle;
	}
	public SimpleStringProperty getPhysicalAd() {
		return physicalAd;
	}
	public void setPhysicalAd(SimpleStringProperty physicalAd) {
		this.physicalAd = physicalAd;
	}


	public SimpleStringProperty getTypeBD() {
		return typeBD;
	}
	public void setTypeBD(SimpleStringProperty typeBD) {
		this.typeBD = typeBD;
	}
	public SimpleStringProperty getVersionBD() {
		return versionBD;
	}
	public void setVersionBD(SimpleStringProperty versionBD) {
		this.versionBD = versionBD;
	}
	public SimpleStringProperty getTypeS() {
		return typeS;
	}
	public void setTypeS(SimpleStringProperty typeS) {
		this.typeS = typeS;
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
