package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import bean.User;
import dao.UserDAO;
import form.UserLoginForm;
import dao.Model;

public class UserLoginAction extends Action{
	
	private FormBeanFactory<UserLoginForm> formBeanFactory = new FormBeanFactory<>(UserLoginForm.class);
	private UserDAO userDAO;
	public UserLoginAction(Model model) {
		userDAO = model.getUserDAO();
    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userLogin.do";
	}
	public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null) {
            return "userLogin.do";
        }

        // Otherwise, just display the login page.
        request.setAttribute("form", new UserLoginForm());
        return "login.jsp";
    }
	
	public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
        HttpSession session = request.getSession();
        if (session.getAttribute("email") != null) {
            return "userLogged.do";
        }

        try {
        	UserLoginForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);

            // Any validation errors?
            if (form.hasValidationErrors()) {
                return "login.jsp";
            }

            // Look up the user
            User user = userDAO.read(form.getUserEmail());
            if (user == null) {
                form.addFieldError("email", "Email not found");
                return "login.jsp";
            }

            // Check the password
            if (!user.getPassword().equals(form.getPassword())) {
                form.addFieldError("password", "Incorrect password");
                return "login.jsp";
            }
            // Attach (this copy of) the user bean to the session
            session.setAttribute("user", user);
            // If redirectTo is null, redirect to the "todolist" action
            return "userLogged.do";
        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "";
        }
    }
}
