package Controller;

import javax.servlet.http.HttpServletRequest;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.DuplicateKeyException;
import org.genericdao.RollbackException;

import bean.*;
import form.*;
import dao.Model;
import dao.UserDAO;
import dao.AdminDAO;

public class AdminAddAction extends Action{
	private FormBeanFactory<AdminAddForm> formBeanFactory = new FormBeanFactory<>(AdminAddForm.class);
    
    private AdminDAO adminDAO;
    private UserDAO userDAO;
    
    public AdminAddAction(Model model) {
        adminDAO = model.getAdminDAO();
        userDAO = model.getUserDAO();
    }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "adminAdd.do";
	}
	
	public String performGet(HttpServletRequest request) {
		// Otherwise, just display the login page.
		request.setAttribute("form", new AdminAddForm());
		System.out.println("Admin Get Method");
		return "admin_add_admin.jsp";
	}
	
	public String performPost(HttpServletRequest request) {
        try {
        	System.out.println("Admin Get Method 2");
            AdminAddForm form = formBeanFactory.create(request);
            request.setAttribute("form", form);
            
            // Any validation errors?
            if (form.hasValidationErrors()) {
            	System.out.println(form.getAdminEmail());
                return "admin_add_admin.jsp";
            }

            if (form.getAction().equals("Create")) {
            	System.out.println("Admin Get Method");
                Admin newUser = new Admin();
                newUser.setAdminEmail(form.getAdminEmail());
                newUser.setFirstName(form.getFirstName());
                newUser.setLastName(form.getLastName());
                newUser.setPassword(form.getPassword());
                
                User user = new User();
                user.setAdminStatus("1");
                user.setBalance("0");
                user.setUserEmail(form.getAdminEmail());
                user.setPassword(form.getPassword());
                
                try {
                    adminDAO.create(newUser);
                    userDAO.create(user);
                    return ("adminAdd.do");
                } catch (DuplicateKeyException e) {
                    form.addFieldError("adminEmail",
                            "A admin with this email already exists");
                    return "admin_add_admin.jsp";
                }
            }

            // Redirect to the "todolist" action
            return "adminAdd.do";
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
    }
	
	

}
