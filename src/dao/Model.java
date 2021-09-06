package dao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.genericdao.ConnectionPool;
import org.genericdao.DAOException;

public class Model {
	private UserDAO userDAO;
	private HotelDAO hotelDAO;
	private HotelInfoDAO hotelinfoDAO;
	private AdminDAO adminDAO;
    public HotelDAO getHotelDAO() {
		return hotelDAO;
	}

	public HotelInfoDAO getHotelinfoDAO() {
		return hotelinfoDAO;
	}

	public Model(ServletConfig config) throws ServletException, DAOException {
        String jdbcDriver = config.getInitParameter("jdbcDriverName");
		String jdbcURL = config.getInitParameter("jdbcURL");

		ConnectionPool pool = new ConnectionPool(jdbcDriver, jdbcURL);
		userDAO = new UserDAO(pool, "users_bnb");
		hotelDAO = new HotelDAO(pool, "hotel");
		hotelinfoDAO = new HotelInfoDAO(pool, "hotel_info");
		adminDAO = new AdminDAO(pool, "admins");
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
    public AdminDAO getAdminDAO() { return adminDAO; }
}