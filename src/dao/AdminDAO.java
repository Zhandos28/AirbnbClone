package dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import bean.Admin;

public class AdminDAO extends GenericDAO<Admin> {
	public AdminDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(Admin.class, tableName, cp);
	}
}
