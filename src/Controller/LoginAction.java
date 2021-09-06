package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import bean.User;
import form.UserLoginForm;
import dao.Model;
import dao.UserDAO;

public class LoginAction extends Action {
    private FormBeanFactory<UserLoginForm> formBeanFactory = new FormBeanFactory<>(UserLoginForm.class);
    
    private UserDAO userDAO;

    public LoginAction(Model model) {
        userDAO = model.getUserDAO();
    }

    public String getName() {
        return "login.do";
    }
    
    public String performGet(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
        HttpSession session = request.getSession();
        System.out.println("asd");
        if (session.getAttribute("user") != null) {
            return "main.jsp";
        }
        System.out.println("asd");
        request.setAttribute("form", new UserLoginForm());
        return "login.jsp";
    }
        
    public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return "main.jsp";
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
                form.addFieldError("userEmail", "User Name not found");
                return "login.jsp";
            }

            // Check the password
            if (!user.getPassword().equals(form.getPassword())) {
                form.addFieldError("password", "Incorrect password");
                return "login.jsp";
            }

            // Attach (this copy of) the user bean to the session
            session.setAttribute("user", user);
            request.setAttribute("user", user);
            
            // if user is admin admin return admin-main
            //TODO
            
            request.getSession().setAttribute("log", true);
            
            if (user.getAdminStatus().equals("1")) {
            	return "admin_index.jsp";
            }
            

            // Redirect to the "todolist" action
            return "rent.do";
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }
}
