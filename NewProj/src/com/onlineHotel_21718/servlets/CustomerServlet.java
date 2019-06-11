package com.onlineHotel_21718.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineHotel_21718.dao.CustomerDaoImpl;
import com.onlineHotel_21718.dao.HotelDaoImpl;
import com.onlineHotel_21718.pojo.Customer;
import com.onlineHotel_21718.pojo.Hotel;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		Customer c=new Customer();
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		boolean flag;
		
		HttpSession session =request.getSession();
		String operation=request.getParameter("operation");
		if(operation!=null&&operation.equals("getCust"))
		{
			String custEmail=(String)session.getAttribute("user");
			//String custEmail=request.getParameter("custEmail");
			c=cdi.getCustomerByEmail(custEmail);
			session.setAttribute("customer",c);
			RequestDispatcher rd=request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
			System.out.println(c);
		}
		else if(operation!=null&&operation.equals("delete"))
		{
			int custId=Integer.parseInt (request.getParameter("custId"));
			flag=cdi.deleteCustomerById(custId);
			List<Customer>clist=cdi.displayAllCustomers();
			session.setAttribute("customer_List",clist);

			response.sendRedirect("CustomerList.jsp");
		}
		else
		{
		List<Customer>clist=cdi.displayAllCustomers();
		session.setAttribute("customer_List",clist);
		request.setAttribute("Success", "Customer DLEATED Succesfully");
		RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
		rd.forward(request, response);
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		{
			Customer c=new Customer();
		
		CustomerDaoImpl cdi=new CustomerDaoImpl();
		boolean flag;
		HttpSession session=request.getSession();
		String operation=request.getParameter("operation");
		if(operation!=null&&operation.equals("updateCustomer"))
		{	
			int customerId=Integer.parseInt(request.getParameter("cid"));
			String customerName=request.getParameter("cname");
			String customerEmail=request.getParameter("cemail");
			String Password=request.getParameter("password");
			String address=request.getParameter("address");
			int Contact=Integer.parseInt(request.getParameter("contact"));
			
			c.setCustName(customerName);
			c.setCustEmail(customerEmail);
			c.setCustPass(Password);
			c.setCustAddress(address);
			c.setCustContact(Contact);
			c.setCustId(customerId);
			
			flag=cdi.updateCustomer(c);
			request.setAttribute("success", "Profile Updated Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		
		}
		else if(operation!=null&&operation.equals("addCustomer"))
		{
		
		String customerName=request.getParameter("cname");
		String customerEmail=request.getParameter("cemail");
		String Password=request.getParameter("password");
		String address=request.getParameter("address");
		int Contact=Integer.parseInt(request.getParameter("contact"));
		
		c.setCustName(customerName);
		c.setCustEmail(customerEmail);
		c.setCustPass(Password);
		c.setCustAddress(address);
		c.setCustContact(Contact);
		
		flag=cdi.addCustomer(c);
		if(flag)
			response.sendRedirect("Success.html");
		else
			response.sendRedirect("Error.html");
		
		}
		
		}
	}

}
