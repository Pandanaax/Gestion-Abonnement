package fr.doranco.abonnement.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.model.connexion.HibernateDataSource;

public class ThemeDao implements IThemeDao {

	@Override
	public Theme getTheme(Integer id) {
		Session session = null;
		Theme theme = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			theme = (Theme) session.get(Theme.class, id);
		} catch (Exception e) {
			System.out.println("Erreur lors de la récupération d'un abonnement : ");
			System.out.println(e);
		}
		return theme;
	}

	@Override
	public Theme addTheme(Theme theme) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.save(theme);
			transaction.commit();
			return theme;
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de l'ajout d'un abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
		return null;
	}

	@Override
	public void updateTheme(Theme theme) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(theme);
			transaction.commit();
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de la mise à jour de l'abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
		
	}

	@Override
	public void removeTheme(Theme theme) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.delete(theme);
			transaction.commit();
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de la suppression de l'abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
		
	}

	@Override
	public List<Theme> getListThemeById(Integer id) throws SQLException {
		Session session = null;
		List<Theme> listeTheme = null;
		try {
		session = HibernateDataSource.getInstance().getSession();
		listeTheme = new ArrayList<Theme>();
		listeTheme = (List<Theme>) session.find(Theme.class, id);
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste Theme : ");
			System.out.println(e);
		}
		
		return listeTheme;
	}

	@Override
	public List<Theme> getListThemeByTitle(String title) throws SQLException {
		Session session = null;
		Query query = null;
		List<Theme> listeTheme = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeTheme = new ArrayList<Theme>();
			
			query = session.getNamedQuery("Theme:findByTitle");
			query.setParameter("title", title);
			
			listeTheme = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeTheme;
	}

}
