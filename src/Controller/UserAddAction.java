package Controller;

import javax.servlet.http.HttpServletRequest;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;
import bean.User;
import form.UserAddForm;
import dao.Model;
import dao.UserDAO;


public class UserAddAction extends Action{
	private FormBeanFactory<UserAddForm> formBeanFactory = new FormBeanFactory<>(UserAddForm.class);
    
    private UserDAO userDAO;
    
    public UserAddAction(Model model) {
        userDAO = model.getUserDAO();
    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userAdd.do";
	}
	
	public String performGet(HttpServletRequest request) {
		// Otherwise, just display the login page.
		request.setAttribute("form", new UserAddForm());
		System.out.println("User Get Method");
		return "admin_add_user.jsp";
	}
	
	public String performPost(HttpServletRequest request) {
        try {
        	System.out.println("Admin Get Method 2");
            UserAddForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            
            // Any validation errors?
            if (form.hasValidationErrors()) {
            	System.out.println(form.getUserEmail());
                return "admin_add_user.jsp";
            }

            if (form.getAction().equals("Create")) {
            	
                User user = new User();
                user.setAdminStatus("0");
                user.setBalance("0");
                user.setUserEmail(form.getUserEmail());
                user.setPassword(form.getPassword());
                
                try {
                    userDAO.create(user);
                    return ("userAdd.do");
                } catch (DuplicateKeyException e) {
                    form.addFieldError("userEmail",
                            "A admin with this email already exists");
                    return "admin_add_user.jsp";
                }
            }

            // Redirect to the "todolist" action
            return "userAdd.do";
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }
	
	

}
