package fr.doranco.abonnement.model.dao;

import java.sql.SQLException;
import java.util.List;

import fr.doranco.abonnement.entity.Theme;

public interface IThemeDao {

	Theme getTheme(Integer id) throws SQLException;
	Theme addTheme(Theme theme) throws SQLException;
	void updateTheme(Theme theme) throws SQLException;
	void removeTheme(Theme thteme) throws SQLException;
	public List<Theme> getListThemeById(Integer id) throws SQLException;
	public List<Theme> getListThemeByTitle(String title) throws SQLException;
	
}
