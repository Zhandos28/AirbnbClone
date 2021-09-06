package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import bean.Hotel;
import bean.User;
import dao.UserDAO;
import form.UserLoginForm;
import dao.HotelDAO;
import dao.HotelInfoDAO;
import dao.Model;

public class RentAction extends Action{
	private HotelDAO hotelDAO;
	private HotelInfoDAO hotelinfoDAO;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "rent.do";
	}
	public RentAction(Model model) {
		hotelDAO = model.getHotelDAO();
		hotelinfoDAO = model.getHotelinfoDAO();
    }
	public String performGet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		request.setAttribute("user", u);
		
		if (request.getSession().getAttribute("log")==null)
			return "login.do";
		
        if (session.getAttribute("user") != null) {
        	Hotel[] hotels;
			try {
				hotels = hotelDAO.match();
				System.out.println(hotels.length);
				request.setAttribute("hotels", hotels);
				session.setAttribute("user", u);
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return "list-of-hotels.jsp";
        }
        // Otherwise, just display the login page.
        return "login.jsp";
    }
	public String performPost(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        
        try {
            Hotel hotel = hotelDAO.read(request.getParameter("id"));
            User user = (User) request.getSession().getAttribute("user");
            request.setAttribute("hotel", hotel);
            request.getSession().setAttribute("hotell", hotel);
            request.getSession().setAttribute("user", user);
            request.setAttribute("user", user);
            return "booking.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}
