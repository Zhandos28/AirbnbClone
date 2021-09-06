package Controller;

import javax.servlet.http.HttpServletRequest;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;

import bean.Admin;
import form.EmailForm;
import form.UserEmailForm;
import dao.AdminDAO;
import dao.Model;
import dao.UserDAO;


public class DeleteUserAction extends Action{
	
	private AdminDAO adminDAO;
	private UserDAO userDAO;
	private FormBeanFactory<UserEmailForm> formBeanFactory = new FormBeanFactory<>(UserEmailForm.class);
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "deleteUser.do";
	}
	
	public DeleteUserAction(Model model) {
		adminDAO = model.getAdminDAO();
		userDAO = model.getUserDAO();
	}
	
	public String performPost(HttpServletRequest request) {
        UserEmailForm form = formBeanFactory.create(request);
        EmailForm form2 = new EmailForm();
        form2.setAdminEmail(form.getUserEmail());
        System.out.println(form.getUserEmail());
        if (form.hasValidationErrors()) {
            return "error.jsp";
        }

        try {
        	String adminEmail = form.getUserEmail();
        	System.out.println("3");
        	Admin admin = adminDAO.read(adminEmail);
        	System.out.println("3");
            if (!(admin == null)) {
            	adminDAO.delete(adminEmail, 1);
            }
            
            userDAO.delete(form.getUserEmail(), 1);
            request.setAttribute("items", userDAO.match());
            return "admin_list_users.jsp";

        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }

}
