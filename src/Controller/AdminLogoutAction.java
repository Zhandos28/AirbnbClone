package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import form.UserLoginForm;
import dao.Model;




public class AdminLogoutAction extends Action {

    public AdminLogoutAction(Model model) {
    }

    public String getName() {
        return "adminLogout.do";
    }

    public String performGet(HttpServletRequest request) {
        return performPost(request);
    }

    public String performPost(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("user", null);

        request.setAttribute("form", new UserLoginForm());
        return "login.jsp";
    }
}
