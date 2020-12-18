package fr.doranco.abonnement.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.abonnement.entity.Abonnement;
import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.entity.User;
import fr.doranco.abonnement.model.connexion.HibernateDataSource;



public class AbonnementDao implements IAbonnementDao{
	
	
	
	@Override
	public Abonnement getAbonnement(Integer id) {
		Session session = null;
		Abonnement abonnement = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
//			abonnement = (Abonnement) session.byId(Abonnement.class);
			abonnement = (Abonnement) session.get(Abonnement.class, id);
		} catch (Exception e) {
			System.out.println("Erreur lors de la récupération d'un abonnement : ");
			System.out.println(e);
		}
		return abonnement;
	}

	@Override
	public Abonnement addAbonnement(Abonnement abonnement) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.save(abonnement);
			transaction.commit();
			return abonnement;
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de l'ajout d'un abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
		return null;
	}

	@Override
	public void updateAbonnement(Abonnement abonnement) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(abonnement);
			transaction.commit();
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de la mise à jour de l'abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
	}

	@Override
	public void removeAbonnement(Abonnement abonnement) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateDataSource.getInstance().getSession();
			transaction = session.beginTransaction();
			session.delete(abonnement);
			transaction.commit();
		} catch(HibernateException ex) {
			System.out.println("Erreur lors de la suppression de l'abonnement : ");
			System.out.println(ex);
			transaction.rollback();
		}
	}

	@Override
	public List<Abonnement> getListAbonnementById(Integer id) throws SQLException {
		Session session = null;
		List<Abonnement> listeAbonnement = null;
		try {
		session = HibernateDataSource.getInstance().getSession();
		listeAbonnement = new ArrayList<Abonnement>();
		listeAbonnement = (List<Abonnement>) session.find(Abonnement.class, id);
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementByTitle(String title) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.title=:title");
			query.setParameter("title", title);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementByDateDeFin(Date dateFin) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.date_fin=:dateFin");
			query.setParameter("date_fin", dateFin);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementTheme(Theme theme) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.theme=:theme");
			query.setParameter("theme", theme);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementByDateDeDebut(Date dateDebut) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.date_fin=:dateDebut");
			query.setParameter("date_fin", dateDebut);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementByPrix(Integer prix) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.prix=:prix");
			query.setParameter("prix", prix);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	@Override
	public List<Abonnement> getListAbonnementByUser(User user) throws SQLException {
		Session session = null;
		Query query = null;
		List<Abonnement> listeAbonnement = null;
		
		
		try {
			session = HibernateDataSource.getInstance().getSession();
			listeAbonnement = new ArrayList<Abonnement>();
			
			query = session.getNamedQuery("from Abonnement e Where e.user=:user");
			query.setParameter("user", user);
			
			listeAbonnement = query.list();
			
		} catch (Exception e) {
			System.out.println("Erreur lors de la recherche de la liste d'abonnement : ");
			System.out.println(e);
		}
		
		return listeAbonnement;
	}

	
}
