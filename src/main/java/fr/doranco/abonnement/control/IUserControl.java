package fr.doranco.abonnement.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.abonnement.entity.User;

public interface IUserControl {

	User getUser(Integer id) throws SQLException;
	User addUser(User user) throws SQLException;
	void updateUser(User user) throws SQLException;
	void removeUser(User user) throws SQLException;
	User seConnecter(String pseudo, String motDePasse) throws SQLException;
	boolean seDeconnecter(User user) throws SQLException;
	List<User> getUsers() throws SQLException;
}
