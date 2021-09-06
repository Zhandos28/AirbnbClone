package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import bean.Hotel;
import bean.User;
import dao.Model;
import dao.UserDAO;
import form.BalanceForm;
import form.UserLoginForm;

public class BalanceAction extends Action {
	private UserDAO userDAO;
	private FormBeanFactory<BalanceForm> formBeanFactory = new FormBeanFactory<>(BalanceForm.class);
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "balance.do";
	}
	public BalanceAction(Model model) {
		userDAO = model.getUserDAO();
	}
	public String performGet(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		request.setAttribute("user", u);
		if (session.getAttribute("user") != null) {
			session.setAttribute("user", u);
			request.setAttribute("form", new BalanceForm());
            return "balance.jsp";
        }
        // Otherwise, just display the login page.
        return "login.jsp";
	}
	public String performPost(HttpServletRequest request) {
		
		List<String> errors = new ArrayList<String>();
        request.setAttribute("errors", errors);
        try {
            
            BalanceForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            System.out.println("POST last");
            if (form.hasValidationErrors()) {
            	System.out.println("POST last2");
                return "balance.jsp";
            }
            System.out.println("POST last1");
            User user = (User) request.getSession().getAttribute("user");
            user.setBalance((Double.parseDouble(user.getBalance()) + Double.parseDouble(form.getBalance()) )+"");
            userDAO.update(user);
            request.getSession().setAttribute("user", user);
            request.setAttribute("user", user);
            return "balance.jsp";

        } catch (RollbackException e) {
            errors.add(e.getMessage());
            return "error.jsp";
        }
    }
}

