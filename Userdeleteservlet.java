package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userUtil.userDB;
import model.User;
/**
 * Servlet implementation class Userdeleteservlet
 */
@WebServlet("/Userdeleteservlet")
public class Userdeleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("uid");
		
		boolean success;
		success=userDB.deleteuser(id);
		
		
		if(success==true) {
			RequestDispatcher di=request.getRequestDispatcher("userinsert.jsp");
			di.forward(request, response);
			
		}
		else {
			
			List<User> userdetails=userDB.getuserDetails(id);
			request.setAttribute("userdetails", userdetails);
			
			RequestDispatcher di=request.getRequestDispatcher("useraccount.jsp");
			di.forward(request, response);
			
			
		}
	}

}
