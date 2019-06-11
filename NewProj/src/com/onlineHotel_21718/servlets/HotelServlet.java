package com.onlineHotel_21718.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.onlineHotel_21718.dao.HotelDaoImpl;
import com.onlineHotel_21718.pojo.Hotel;

/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/HotelServlet")
@MultipartConfig(maxFileSize=16777215)
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HotelServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		Hotel h=new Hotel();
		

		HotelDaoImpl hdi=new HotelDaoImpl();
		
		HttpSession session =request.getSession();
		String operation=request.getParameter("operation");
		boolean flag;
		
		if(operation!=null&&operation.equals("update"))
		{
			int hotelId=Integer.parseInt(request.getParameter("hotelId"));
			h=hdi.getHotelById(hotelId);
			session.setAttribute("hotel",h);
			response.sendRedirect("UpdateHotel.jsp");
			
		}
		else if(operation!=null&&operation.equals("delete"))
		{
			int hotelId=Integer.parseInt(request.getParameter("hotelId"));
			flag=hdi.deleteHotelById(hotelId);
			
			List<Hotel>hlist=hdi.displayAllHotels();
			session.setAttribute("hotel_List",hlist);

			response.sendRedirect("HotelList.jsp");
			
		}
		else
		{
		List<Hotel>hlist=hdi.displayAllHotels();
		session.setAttribute("hotel_List",hlist);

		response.sendRedirect("HotelList.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			Hotel h=new Hotel();
			HotelDaoImpl hdi=new HotelDaoImpl();
			boolean flag;
			HttpSession session=request.getSession();
	
			
			String operation=request.getParameter("operation");
			
			if(operation!=null&&operation.equals("updateHotel"))
			{
				int hotelId=Integer.parseInt(request.getParameter("hid"));
				String hotelName=request.getParameter("hname");
				String hotelLocation=request.getParameter("location");
				//String hotelContact=request.getParameter("contact");
				int hotelContact=Integer.parseInt(request.getParameter("contactnumber"));
				Part getPart=request.getPart("hotelImage");
				InputStream is=getPart.getInputStream();
				
				h.setHotelId(hotelId);
				h.setHotelName(hotelName);
				h.setHotelLocation(hotelLocation);
				h.setHotelContact(hotelContact);
				if(getPart.getSize()!=0){
					h.setIs(is);
				}else
				{
				h.setIs(((Hotel)session.getAttribute("hotel")).getIs());
				}
				
				flag=hdi.updateHotel(h);
				List<Hotel>hlist=hdi.displayAllHotels();
				session.setAttribute("hotel_List",hlist);
				response.sendRedirect("HotelList.jsp");
			}
			
			else if(operation!=null&&operation.equals("addHotel"))
			{			
				String hotelName=request.getParameter("hname");
				String hotelLocation=request.getParameter("location");
				//String hotelContact=request.getParameter("contact");
				int hotelContact=Integer.parseInt(request.getParameter("contactnumber"));
				Part getpart=request.getPart("hotelImage");
				InputStream is=getpart.getInputStream();
				
			h.setHotelName(hotelName);
			h.setHotelLocation(hotelLocation);
			h.setHotelContact(hotelContact);
			h.setIs(is);
			
			flag=hdi.addHotel(h);
			if(flag){
				request.setAttribute("AddSuccess", "Hotel Added Succesfully");
				List<Hotel>hlist=hdi.displayAllHotels();
				session.setAttribute("hotel_List",hlist);
				RequestDispatcher rd=request.getRequestDispatcher("HotelList.jsp");
				rd.forward(request, response);
			}
			else
				response.sendRedirect("Error.html");
			}
	
		}
		}

}
