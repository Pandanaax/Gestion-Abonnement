package fr.doranco.abonnement.main;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.abonnement.entity.Abonnement;
import fr.doranco.abonnement.entity.Theme;
import fr.doranco.abonnement.entity.User;
import fr.doranco.abonnement.model.dao.AbonnementDao;
import fr.doranco.abonnement.model.dao.IAbonnementDao;
import fr.doranco.abonnement.model.dao.IThemeDao;
import fr.doranco.abonnement.model.dao.IUserDao;
import fr.doranco.abonnement.model.dao.ThemeDao;
import fr.doranco.abonnement.model.dao.UserDao;
import fr.doranco.abonnement.util.Dates;

public class MainAbonnement {

	public static void main(String[] args) throws SQLException {
		
//		IUserDao userDao = new UserDao();
//		User userT = userDao.getUser(5);
//		System.out.println(userT);
//		
//		IThemeDao themeDao = new ThemeDao();
//		Theme themeNetflix = (Theme) themeDao.getTheme(1);
//		System.out.println(themeNetflix);
//		
//		Abonnement abonnement = new Abonnement("Netflix", "Plateforme de film et série", 9.8 , Dates.convertStringToDateUtil("10/10/2020"), Dates.convertStringToDateUtil("10/10/2021"), themeNetflix);
//		IAbonnementDao abonnementDao = new AbonnementDao();
//		Abonnement abonnementAdded = abonnementDao.addAbonnement(abonnement); 
		

	}

}
