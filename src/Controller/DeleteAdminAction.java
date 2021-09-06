package Controller;

import javax.servlet.http.HttpServletRequest;

import org.formbeanfactory.FormBeanFactory;
import org.genericdao.RollbackException;


import form.EmailForm;
import dao.AdminDAO;
import dao.UserDAO;
import dao.Model;

public class DeleteAdminAction extends Action{
	
	private AdminDAO adminDAO;
	private UserDAO userDAO;
	private FormBeanFactory<EmailForm> formBeanFactory = new FormBeanFactory<>(EmailForm.class);
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "deleteAdmin.do";
	}
	
	public DeleteAdminAction(Model model) {
		adminDAO = model.getAdminDAO();
		userDAO = model.getUserDAO();
	}
	
	public String performPost(HttpServletRequest request) {
        EmailForm form = formBeanFactory.create(request);
        System.out.println(form.getAdminEmail());
        if (form.hasValidationErrors()) {
            return "error.jsp";
        }

        try {
        	System.out.println(form.getAdminEmail());
            adminDAO.delete(form.getAdminEmail());
            userDAO.delete(form.getAdminEmail());
            request.setAttribute("items", adminDAO.match());
            return "admin_list_admin.jsp";

        } catch (RollbackException e) {
            request.setAttribute("error", e.getMessage());
            return "error.jsp";
        }
    }

}
