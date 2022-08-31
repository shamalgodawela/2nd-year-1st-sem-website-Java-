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
 * Servlet implementation class UpdateUserservlet
 */
@WebServlet("/UpdateUserservlet")
public class UpdateUserservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("uid");
		String name=request.getParameter("name");
		String username=request.getParameter("uname");
		String email=request.getParameter("umail");
		String contactnumber=request.getParameter("cnumber");
		
		
		boolean success;
		
		success=userDB.updateuser(id, name, username, email, contactnumber);
		
		if(success==true) {
			
			List<User> userdetails=userDB.getuserDetails(id);
			request.setAttribute("userdetails", userdetails);
			
			
			RequestDispatcher di=request.getRequestDispatcher("useraccount.jsp");
			di.forward(request, response);
		}
		else {
			RequestDispatcher di=request.getRequestDispatcher("unsuccess.jsp");
			di.forward(request, response);
		}
	}

}
