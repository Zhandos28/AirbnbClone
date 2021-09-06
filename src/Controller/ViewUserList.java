package Controller;

import javax.servlet.http.HttpServletRequest;

import org.genericdao.RollbackException;

import bean.User;
import dao.UserDAO;
import dao.Model;

public class ViewUserList extends Action{

	private UserDAO userDAO;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userList.do";
	}
	
	public ViewUserList(Model model) {
		userDAO = model.getUserDAO();
	}
	
	public String performGet(HttpServletRequest request) {
        return performPost(request);
    }
	
	public String performPost(HttpServletRequest request) {
		try {
			User[] users = userDAO.match();
			int count = 0;
			for (User user : users) {
				if (user.getAdminStatus().equals("0"))
					count++;
			}
			User[] userss = new User[count];
			int ind = 0;
			for (int i = 0; i < users.length; i++) {
				if (users[i].getAdminStatus().equals("0") && ind < count)
					userss[ind++] = users[i];
			}
            request.setAttribute("items", userss);
//            request.setAttribute("form",  new CustomerFundsForm());
            return ("admin_list_users.jsp");
        } catch (RollbackException e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
        
    }
}

