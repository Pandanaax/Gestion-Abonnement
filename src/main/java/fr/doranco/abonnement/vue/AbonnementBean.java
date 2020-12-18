package fr.doranco.abonnement.vue;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.abonnement.control.AbonnementControl;
import fr.doranco.abonnement.control.IAbonnementControl;
import fr.doranco.abonnement.entity.Abonnement;
import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.entity.User;
import fr.doranco.abonnement.util.Dates;


@ManagedBean(name = "abonnementbean")
@SessionScoped
public class AbonnementBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8812712214996857248L;
	

	@ManagedProperty(name = "titleAbonnement", value = "Netflix")
	public String titleAbonnement;
	
	@ManagedProperty(name = "descriptionAbonnement", value = "Plateforme de streaming")
	public String descriptionAbonnement;
	
	@ManagedProperty(name = "prix", value = "9")
	public String prix;
	
	@ManagedProperty(name = "dateDebut", value = "10/10/2020")
	public String dateDebut;
	
	@ManagedProperty(name = "dateFin", value = "10/10/2020")
	public String dateFin;
	
	@ManagedProperty(name = "titleTheme", value = "Musique")
	public String titleTheme;
	
	@ManagedProperty(name = "lienDuSite", value = "http://nfgrieg.fgnitreg.fr")
	public String lienDuSite;
	
	@ManagedProperty(name = "lienDeResiliation", value = "http://nfgrieg.fgnitreg.fr")
	public String lienDeResiliation;
	
	@ManagedProperty(name = "descriptionTheme", value = "http://nfgrieg.fgnitreg.fr")
	public String descriptionTheme;
	@ManagedProperty(name = "message", value = "")
	public String message;
	
	public List<Abonnement> listAbonnement;
	
	
	
	public AbonnementBean() {
		
	}
	
	IAbonnementControl abonnementControl = new AbonnementControl();
	
	
	public void addAbonnement() {
		Theme theme = new Theme(titleTheme, lienDuSite, lienDeResiliation, descriptionTheme);
		Abonnement abonnement = new Abonnement("MagicForm", "Salle de sport", 29.90d,
				Dates.convertStringToDateUtil(dateDebut), Dates.convertStringToDateUtil(dateFin), theme);
		try {
			Abonnement abonnementAjoute = abonnementControl.addAbonnement(abonnement);

			if (abonnementAjoute != null) {
				message = "abonnement bien ajouté"; 
			} else {
				message = "abonnement n'a pas été ajouté";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public List<Abonnement> getListByUser() {
		return listAbonnement;
	}
	
	public void removeAbonnement(Abonnement abonnement) {
		listAbonnement.remove(abonnement);
	}

	public void updateAbonnement() {
		
	}

	public String getTitleAbonnement() {
		return titleAbonnement;
	}


	public void setTitleAbonnement(String titleAbonnement) {
		this.titleAbonnement = titleAbonnement;
	}


	public String getDescriptionAbonnement() {
		return descriptionAbonnement;
	}


	public void setDescriptionAbonnement(String descriptionAbonnement) {
		this.descriptionAbonnement = descriptionAbonnement;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}


	public String getDateFin() {
		return dateFin;
	}


	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public String getTitleTheme() {
		return titleTheme;
	}


	public void setTitleTheme(String titleTheme) {
		this.titleTheme = titleTheme;
	}


	public String getLienDuSite() {
		return lienDuSite;
	}


	public void setLienDuSite(String lienDuSite) {
		this.lienDuSite = lienDuSite;
	}


	public String getLienDeResiliation() {
		return lienDeResiliation;
	}


	public void setLienDeResiliation(String lienDeResiliation) {
		this.lienDeResiliation = lienDeResiliation;
	}


	public String getDescriptionTheme() {
		return descriptionTheme;
	}


	public void setDescriptionTheme(String descriptionTheme) {
		this.descriptionTheme = descriptionTheme;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	
	

	

}
