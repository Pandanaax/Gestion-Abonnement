package fr.doranco.abonnement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



@Entity
@Table(name = "user", catalog = "abonnement")

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8014561904117435133L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id", length = 11)
	private Integer id;
	@NotEmpty
	@Size(min = 2, max = 25, message="La longueur du nom doit être comprise entre 2 et 25 caractères")
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	@NotEmpty
	@Size(min = 2, max = 25, message="La longueur du prenom doit être comprise entre 2 et 25 caractères")
	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;
	@NotEmpty
	@Size(min = 2, max = 15, message="La longueur du pseudo doit être comprise entre 2 et 15 caractères")
	@Column(name = "pseudo", length = 15, nullable = false)
	private String pseudo;
	@NotEmpty
	@Size(min = 2, max = 45, message="La longueur du email doit être comprise entre 2 et 45 caractères")
	@Column(name = "email", length = 45, nullable = false)
	private String email;
	@NotEmpty
	@Size(min = 2, max = 35, message="La longueur du mot de passe doit être comprise entre 2 et 35 caractères")
	@Column(name = "mot_de_passe", length = 35, nullable = false)
	private String motDePasse;
	@NotEmpty
	@Column(name = "telephone", length = 11, nullable = false)
	private String telephone; 
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Abonnement> mesAbonnements;
	
	public User() {
		
	}

	public User(String nom, String prenom, String pseudo, String email, String motDePasse, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.email = email;
		this.motDePasse = motDePasse;
		this.telephone = telephone;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Abonnement> getMesAbonnements() {
		return mesAbonnements;
	}

	public void setMesAbonnements(List<Abonnement> mesAbonnements) {
		this.mesAbonnements = mesAbonnements;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pseudo=" + pseudo + ", mail=" + email
				+ ", motDePasse=" + motDePasse + ", telephone=" + telephone + "]";
	}



}
