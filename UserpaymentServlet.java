package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import userUtil.userDB;

/**
 * Servlet implementation class UserpaymentServlet
 */
@WebServlet("/UserpaymentServlet")
public class UserpaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("Owner");
		String cvv=request.getParameter("pwd");
		String card=request.getParameter("card");
		String month=request.getParameter("months");
		String year=request.getParameter("years");
		
		
		boolean success;
		
		success=userDB.insertpayment(username, cvv, card, month, year);
		if(success==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('payment success');");
			out.println("location='Userlog.jsp'");
			out.println("</script>");
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('invalid payment');");
			out.println("location='Userlog.jsp'");
			out.println("</script>");
		}
		
		
		
	}

}
