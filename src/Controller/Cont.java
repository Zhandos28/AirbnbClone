package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.genericdao.DAOException;

import bean.User;
import dao.Model;

/**
 * Servlet implementation class Cont
 */
@WebServlet("/Cont")
public class Cont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	public void init() throws ServletException {
		try {
			Model model = new Model(getServletConfig());
			Action.add(new UserLoginAction(model));
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextPage = performTheAction(request);
		System.out.println(nextPage);
        sendToNextPage(nextPage, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String performTheAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String servletPath = request.getServletPath();
        String action = getActionName(servletPath);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // Let the logged in user run his chosen action
            return Action.perform(action, request);
        }
        /*if (cst != null) {
            // Let the logged in user run his chosen action
            return Action.perform(action, request);
        }*/
        
        // If the user hasn't logged in, login is the only option
        // Note in this example, register is in the login action.
        if (action.equals("userLogin.do")) {
            return Action.perform("userLogin.do", request);
        }
        
        // The not-logged user is trying to execute an action other
        // than login.  This is usually due to his session timing
        // out but he could be fooling around.  Let's give him a
        // stale session error message.  Another option would be
        // to send him to login.jsp, instead.
        return "login.jsp";
    }

    /*
     * If nextPage is null, send back 404 If nextPage ends with ".do", redirect
     * to this page. If nextPage ends with ".jsp", dispatch (forward) to the
     * page (the view) This is the common case
     */
    private void sendToNextPage(String nextPage, HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        if (nextPage == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    request.getServletPath());
            return;
        }

        if (nextPage.endsWith(".do")) {
            response.sendRedirect(nextPage);
            return;
        }

        if (nextPage.endsWith(".jsp")) {
            RequestDispatcher d = request.getRequestDispatcher("WEB-INF/" + nextPage);
            d.forward(request, response);
            return;
        }

        throw new ServletException(Controller.class.getName()
                + ".sendToNextPage(\"" + nextPage + "\"): invalid extension.");
    }

    /*
     * Returns the path component after the last slash removing any "extension"
     * if present.
     */
    private String getActionName(String path) {
        // We're guaranteed that the path will start with a slash
        int slash = path.lastIndexOf('/');
        return path.substring(slash + 1);
    }

}
