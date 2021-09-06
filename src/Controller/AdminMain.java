package Controller;

import javax.servlet.http.HttpServletRequest;



import dao.Model;

public class AdminMain extends Action{
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "adminMain.do";
	}
	
	public AdminMain(Model model) {
	}
	
	public String performGet(HttpServletRequest request) {
        return performPost(request);
    }
	
	public String performPost(HttpServletRequest request) {
		try {
            
//            request.setAttribute("form",  new CustomerFundsForm());
            return ("admin_index.jsp");
        } catch (Exception e) {
            request.setAttribute("error",e.getMessage());
            return "error.jsp";
        }
        
    }
}
