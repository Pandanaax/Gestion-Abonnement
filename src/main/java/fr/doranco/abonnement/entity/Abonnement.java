package fr.doranco.abonnement.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "abonnement", catalog = "abonnement")

public class Abonnement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4262165749926929101L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", length = 11)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@NotEmpty
	@Size(min = 2, max = 35, message="La longueur du titre doit être comprise entre 2 et 35 caractères")
	@Column(name = "title", length = 35, nullable = false)
	private String title;
	@Size(min = 2, max = 500, message="La longueur du titre doit être comprise entre 2 et 500 caractères")
	@Column(name = "description", length = 500, nullable = false)
	private String description;
	@NotEmpty
	@Column(name = "prix", length = 11)
	private Double prix;
	@NotEmpty
	@Column(name = "date_debut", length = 11)
	private Date dateDebut;
	@Column(name = "date_fin", length = 11)
	private Date dateFin;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "theme_id")
	private Theme theme;
	
	public Abonnement() {
		
	}

	public Abonnement( String title, String description, Double prix, Date dateDebut, Date dateFin, Theme theme) {
		super();
		this.theme = theme;
		this.title = title;
		this.description = description;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Abonnement [id=" + id + ", user=" + user + ", title=" + title + ", description=" + description
				+ ", prix=" + prix + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", theme=" + theme + "]";
	}

	
	
	
}
