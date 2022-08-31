package servlet;

import java.io.IOException;
import model.Payment;
import java.io.PrintWriter;
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
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")


public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("userN");
		String passWord = request.getParameter("PSword");
		boolean success;
		
		String UserName = request.getParameter("userN");
		boolean suc;
		
		suc=userDB.paymentvalidate(UserName);
		
		success=userDB.validate(userName, passWord);
		
		if(success==true) {
			List<User> userdetails=userDB.getuser(userName);
			request.setAttribute("userdetails", userdetails);
			
			List<Payment> paydetails=userDB.getpayment(UserName);
			request.setAttribute("paydetails", paydetails);
			
			
			RequestDispatcher dispa=request.getRequestDispatcher("useraccount.jsp");
			dispa.forward(request, response);
		}
		else {
			
			out.println("<script type='text/javascript'>");
			out.println("alert('username or email is incorrect');");
			out.println("location='Userlog.jsp'");
			out.println("</script>");
			
		}
		
		
		
	
	}
	
	

}