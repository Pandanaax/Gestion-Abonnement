package fr.doranco.abonnement.control;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import fr.doranco.abonnement.entity.Abonnement;
import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.entity.User;

public interface IAbonnementControl {

	Abonnement getAbonnement(Integer id) throws SQLException;
	Abonnement addAbonnement (Abonnement abonnement) throws SQLException;
	void updateAbonnement (Abonnement abonnement) throws SQLException;
	void removeAbonnement (Abonnement abonnement) throws SQLException;
	
	public List<Abonnement> getListAbonnementById(Integer id) throws SQLException;
	public List<Abonnement> getListAbonnementByTitle(String title) throws SQLException;
	public List<Abonnement> getListAbonnementByDateDeFin(Date dateFin) throws SQLException;
	public List<Abonnement> getListAbonnementTheme(Theme theme) throws SQLException;
	public List<Abonnement> getListAbonnementByDateDeDebut(Date dateDebut) throws SQLException;
	public List<Abonnement> getListAbonnementByPrix(Integer prix) throws SQLException;
	public List<Abonnement> getListAbonnementByUser(User user) throws SQLException;
}
