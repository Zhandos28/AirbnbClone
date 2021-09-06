package Controller;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import dao.Model;

public class Main extends Action{
	
	public String getName() {
        return "main.do";
    }
	
	public Main(Model model) {
    }
	
	public String performGet(HttpServletRequest request) {
		Object log = request.getSession().getAttribute("log");
		request.setAttribute("log", log);
		User us = (User) request.getSession().getAttribute("user");
		
		request.getSession().setAttribute("user", us);
		request.setAttribute("user", us);
        return "main.jsp";
    }
	public String performPost(HttpServletRequest request) {
        // If user is already logged in, redirect to todolist.do

        try {
            return "main.do";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            return "";
        }
    }
}
