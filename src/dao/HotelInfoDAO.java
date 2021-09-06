package dao;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;
import org.genericdao.GenericDAO;

import bean.HotelInfo;

public class HotelInfoDAO extends GenericDAO<HotelInfo> {
	public HotelInfoDAO(ConnectionPool cp, String tableName) throws DAOException {
		super(HotelInfo.class, tableName, cp);
	}
}
