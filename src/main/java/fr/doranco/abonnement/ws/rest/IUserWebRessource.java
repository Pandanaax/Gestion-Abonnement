package fr.doranco.abonnement.ws.rest;

import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.xml.ws.Response;

import fr.doranco.abonnement.entity.User;

public interface IUserWebRessource {

	Response getUser(Integer id) throws SQLException;
	Response addUser(User user) throws URISyntaxException;
	Response updateUser(User user) throws URISyntaxException;
	Response removeUser(User user) throws URISyntaxException;
	Response seConnecter(String url, String pseudo, String motDePasse) throws SQLException;
	Response seDeconnecter(User user) throws SQLException;
	
}
