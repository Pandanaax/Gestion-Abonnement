package fr.doranco.abonnement.control;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.abonnement.entity.User;
import fr.doranco.abonnement.model.dao.IUserDao;
import fr.doranco.abonnement.model.dao.UserDao;

public class UserControl implements IUserControl{

	private final IUserDao userDao = new UserDao();
	
	@Override
	public User getUser(Integer id) throws SQLException {
		return userDao.getUser(id);
	}

	@Override
	public User addUser(User user) throws SQLException {
		return userDao.addUser(user);

	}

	@Override
	public void updateUser(User user) throws SQLException {
			userDao.updateUser(user);

	}

	@Override
	public void removeUser(User user) throws SQLException{
			userDao.removeUser(user);
	}

	@Override
	public User seConnecter(String pseudo, String motDePasse) throws SQLException {
		return userDao.seConnecter(pseudo, motDePasse);
	}

	@Override
	public boolean seDeconnecter(User user) throws SQLException {
		return userDao.seDeconnecter(user);
	}
	
	@Override
	public List<User> getUsers() throws SQLException {
		
		return userDao.getUsers();
	}



}
