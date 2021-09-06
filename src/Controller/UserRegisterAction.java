package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import bean.User;
import form.UserRegisterForm;
import dao.Model;
import dao.UserDAO;

public class UserRegisterAction extends Action{
	private FormBeanFactory<UserRegisterForm> formBeanFactory = new FormBeanFactory<>(UserRegisterForm.class);
    
    private UserDAO userDAO;

    public UserRegisterAction(Model model) {
        userDAO = model.getUserDAO();
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userRegister.do";
	}
	
	public String performGet(HttpServletRequest request) {
		// Otherwise, just display the login page.
		System.out.println("Register Get Method");
		request.setAttribute("form", new UserRegisterForm());
		return "registration.jsp";
	}
	
	public String performPost(HttpServletRequest request) {
		HttpSession session = request.getSession();
        try {
            UserRegisterForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            System.out.println("Register Post Method");
            // Any validation errors?
            if (form.hasValidationErrors()) {
                return "registration.jsp";
            }
            System.out.println("Register Post Method");
            if (form.getAction().equals("Register")) {
                User newUser = new User();
                newUser.setUserEmail(form.getUserEmail());
                newUser.setPassword(form.getPassword());
                newUser.setBalance(0+"");
                try {
                    userDAO.create(newUser);
                    session.setAttribute("user", newUser);
                    return ("main.do");
                } catch (DuplicateKeyException e) {
                    form.addFieldError("userEmail",
                            "A user with this name already exists");
                    return "registration.jsp";
                }
            }
            System.out.println("Register Post Method");

            // Redirect to the "todolist" action
            return "main.jsp";
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }
}
