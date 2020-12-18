package fr.doranco.abonnement.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.abonnement.entity.Abonnement;
import fr.doranco.abonnement.entity.User;
import fr.doranco.abonnement.model.connexion.HibernateDataSource;

public class UserDao implements IUserDao {

	Session session = HibernateDataSource.getInstance().getSession();

	@Override
	public User getUser(Integer id) throws SQLException {
		Session session = null;
		User user = null;
		user = session.get(User.class, id);
		return user;
	}

	@Override
	public User addUser(User user) throws SQLException {
		Transaction transaction = null;
		Session session = null;
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		Transaction transaction = null;
		Session session = null;
		transaction = session.beginTransaction();
		session.saveOrUpdate(user);
		transaction.commit();

	}

	@Override
	public void removeUser(User user) throws SQLException {
		Transaction transaction = null;
		Session session = null;

		transaction = session.beginTransaction();
		session.delete(user);
		transaction.commit();

	}

	@Override
	public User seConnecter(String pseudo, String motDePasse) throws SQLException {
		Session session = null;
		Query query = null;
		query = session.createQuery("from Abonnement e Where e.pseudo=:pseudo, e.mot_de_passe=:motDePasse");
		query.setParameter("pseudo", pseudo);
		User user = (User) query.getSingleResult();
		if (user != null && user.getMotDePasse().equals(motDePasse)) {
			return user;
		}
		return null;
	}

	@Override
	public boolean seDeconnecter(User user) throws SQLException {
		Session session = null;
		Query query = null;
		User user1 = null;
		query = session.createQuery("from Abonnement e Where e.pseudo=:pseudo, e.mot_de_passe=:motDePasse");
		user1 = (User) query.setTimeout(0);
		return true;

	}

	@Override
	public List<Abonnement> getListById(Integer id) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;

		listeAbonnement = new ArrayList<Abonnement>();

		query = session.getNamedQuery("from User e Where e.id=:id");
		query.setParameter("id", id);

		listeAbonnement = query.list();

		return listeAbonnement;
	}

	@Override
	public List<User> getUsers() throws SQLException {
		return null;
	}

}
