package Controller;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import dao.AdminDAO;
import dao.Model;

public class ViewAdminList extends Action{

	private AdminDAO adminDAO;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "adminList.do";
	}
	
	public ViewAdminList(Model model) {
		adminDAO = model.getAdminDAO();
	}
	
	public String performGet(HttpServletRequest request) {
        return performPost(request);
    }
	
	public String performPost(HttpServletRequest request) {
		try {
            request.setAttribute("items", adminDAO.match());
//            request.setAttribute("form",  new CustomerFundsForm());
            return ("admin_list_admin.jsp");
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
        
    }
}
