package com.onlineHotel_21718.servlets;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.onlineHotel_21718.dao.HotelDaoImpl;
import com.onlineHotel_21718.dao.LoginDaoImpl;
import com.onlineHotel_21718.pojo.Hotel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		HttpSession session=request.getSession();
		
		session.invalidate();
		
		request.setAttribute("success", "You hava logged out successfully");
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDaoImpl ldi=new LoginDaoImpl();
		boolean flag;
		HttpSession session=request.getSession();

		
		String operation=request.getParameter("operation");
		
	 if(operation!=null&&operation.equals("login"))
		{	
		 	
		 String type=request.getParameter("type");
		 	
		 	System.out.println("login model");
			String userEmail=request.getParameter("userid");
			String password=request.getParameter("password");
	
			if(type.equals("user")){
				flag=ldi.UserLogin(userEmail, password);
				if(flag){
					session.setAttribute("user", userEmail);
					request.setAttribute("success", "Welcome "+userEmail);
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					
				}
				else
					response.sendRedirect("Error.html");
			}
			else if(type.equals("admin")){
				
				flag=ldi.adminLogin(userEmail, password);
				if(flag){
					session.setAttribute("admin", userEmail);
					request.setAttribute("success", "Welcome "+userEmail);
					RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
					System.out.println("login success");
				}
					else
					response.sendRedirect("Error.html");
			}
		
		
		}
	 else if(operation!=null&&operation.equals("changeP"))
		{
		 String userEmail=request.getParameter("email");
			String password=request.getParameter("oldPass");
			String newPassword=request.getParameter("newPass");
			
				flag=ldi.adminLogin(userEmail, password);
				if (flag){
					flag=ldi.changePassword(userEmail, newPassword);
					System.out.println("update execute");
					response.sendRedirect("Success.html");
				}
				else{
					response.sendRedirect("Error.html");
				
				}
		}
	}

}
