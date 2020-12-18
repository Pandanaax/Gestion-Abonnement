package fr.doranco.abonnement.main;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.model.dao.ThemeDao;


public class MainTheme {

	public static void main(String[] args) throws SQLException {
		
		Transaction transaction = null;
		Session session = null;
		session = fr.doranco.abonnement.model.connexion.HibernateDataSource.getInstance().getSession();
		transaction = session.beginTransaction();

	
		ThemeDao themeDao  = new ThemeDao();
		
		Theme theme = new Theme("Sfr","http://www.sfr.fr","http://www.resilisation-sfr.fr","Forfait mobile.");
		themeDao.addTheme(theme);
		
		List<Theme> listeThemes = themeDao.getListThemeByTitle("Spotify");
		for (Theme theme1 : listeThemes) {
			System.out.println(theme1);
		}

		System.exit(0);
		
	}

}
