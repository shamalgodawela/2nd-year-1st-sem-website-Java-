package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userUtil.userDB;

/**
 * Servlet implementation class UserInsert
 */
@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		String Name=request.getParameter("name");
		String UserName = request.getParameter("userN");
		String Email=request.getParameter("email");
		String ContactNumber=request.getParameter("phone");
		String Password = request.getParameter("PSword");
		
		boolean success;
		
		success=userDB.insertuser(Name, UserName, Email, ContactNumber, Password);
		
		if(success==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('success please login to site');");
			out.println("location='Userlog.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('error');");
			out.println("location='Userlog.jsp'");
			out.println("</script>");
		}
		
	}

}
