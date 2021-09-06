package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import bean.Hotel;
import bean.User;
import dao.HotelDAO;
import dao.Model;
import dao.UserDAO;
public class VisitAction extends Action {
	private HotelDAO hotelDAO;
	private UserDAO userDAO;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "hotel.do";
	}
	
	public VisitAction(Model model) {
		hotelDAO = model.getHotelDAO();
		userDAO = model.getUserDAO();
	}
	
	public String performGet(HttpServletRequest request) {
		Hotel hotel = (Hotel) request.getSession().getAttribute("hotell");
		request.setAttribute("hotel", hotel);
		request.setAttribute("user", request.getSession().getAttribute("user"));
		return "booking.jsp";
	}
	public String performPost(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Hotel hotel = (Hotel) request.getSession().getAttribute("hotell");
		user.setBalance((Double.parseDouble(user.getBalance())-(hotel.getPrice_for_night()*0.8 * 18 - (int) (hotel.getPrice_for_night()*0.8 * 18 * 0.12)))+"");
        request.setAttribute("hotel", hotel);
        request.getSession().setAttribute("hotell", hotel);
        request.getSession().setAttribute("user", user);
        request.setAttribute("user", user);
		try {
			userDAO.update(user);
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "booking.jsp";
	}

}
