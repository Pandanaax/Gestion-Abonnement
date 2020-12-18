package fr.doranco.abonnement.vue;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.abonnement.control.IUserControl;
import fr.doranco.abonnement.control.UserControl;
import fr.doranco.abonnement.entity.User;








@ManagedBean(name = "userbean")
@SessionScoped
public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4657068041040130084L;

	public String idUser;
	
	@ManagedProperty(name = "nom", value = "Machain")
	private String nom;
	@ManagedProperty(name = "prenom", value = "Hippolyte")
	private String prenom;
	@ManagedProperty(name = "pseudo", value = "Hpos")
	private String pseudo;
	@ManagedProperty(name = "email", value = "hmachain@hotmail.fr")
	private String email;
	@ManagedProperty(name = "motDePasse", value ="hipovietnam")
	private String motDePasse;
	@ManagedProperty(name = "telephone", value = "0622484267")
	private String telephone; 
	@ManagedProperty(name = "messageSuccess", value = "")
	private String messageSuccess = "";

	@ManagedProperty(name = "messageError", value = "")
	private String messageError = "";
	
	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		this.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public UserBean() {
		
	}
	private static final IUserControl userControl = new UserControl();
	private static List<User> listUsers = getUsers();
	
	private final List<User> userList = new ArrayList<User>(Arrays.asList(
			new User("Pacini","Pierre","ppgouin","p.pacini@gmail.com", "hopierre","0668374639"),
			new User("Pacini","Pierre","ppgouin","p.pacini@gmail.com", "hopierre","0668374639"),
			new User("Pacini","Pierre","ppgouin","p.pacini@gmail.com", "hopierre","0668374639"),
			new User("Pacini","Pierre","ppgouin","p.pacini@gmail.com", "hopierre","0668374639")));
	
	public List<User> getListById() {
		return userList;
	}
	
	private static List<User> getUsers() {
		// TODO Auto-generated method stub
		return listUsers;
	}

	private static List<User> getUser() {
		
		try {
			List<User> listeUsers = userControl.getUsers();
			return listeUsers;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String addUser() throws SQLException {
		User user = new User(nom, prenom, pseudo, email, motDePasse, telephone);
		User addedUser = null;
		addedUser = userControl.addUser(user);
		this.idUser = addedUser.getId().toString();
		messageSuccess = "Utilisateur ajouté avec succès."
		return null;
		
	}
	public void removeUser(User user) {
		userList.remove(user);
	}
	
	public void seConnecter(User user) {
		
	}
	
	public void seDeconnecter() {
		
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
	
	
}
