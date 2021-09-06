package dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import bean.Hotel;

public class HotelDAO extends GenericDAO<Hotel> {
	public HotelDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(Hotel.class, tableName, cp);
	}
}
