package com.onlineHotel_21718.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineHotel_21718.dao.BookingDaoImpl;
import com.onlineHotel_21718.pojo.Booking;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*	// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		doGet(request, response);*/
		System.out.println("M -BookingServlet - POST");
		HttpSession session=request.getSession();
		BookingDaoImpl bdi=new BookingDaoImpl();
		Booking b=new Booking();
		
		int count=Integer.parseInt(request.getParameter("roomsCount"));
		String custEmail=(String)session.getAttribute("user");
		String start=request.getParameter("start");
		LocalDate fromDate=LocalDate.parse(start);
		String end=request.getParameter("end");
		LocalDate toDate=LocalDate.parse(end);
		int roomId=Integer.parseInt(request.getParameter("roomId"));
		
		b.setNumberofRooms(count);
		b.setEmailId(custEmail);
		b.setStartDate(start);
		b.setEndDate(end);
		b.setRoomId(roomId);
		Period p=fromDate.until(toDate);
		int period=p.getDays();
		b.setNumberofDays(period);
		
		int bookingId=bdi.addBooking(b);
		if(bookingId>0)
		{
			request.setAttribute("success", "Your booking is confirm !"+bookingId);
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("Failed", "Sorry ! Booking is already existing");
			RequestDispatcher rd=request.getRequestDispatcher("RoomList.jsp");
			rd.forward(request, response);
			
		}
		
	}

}
