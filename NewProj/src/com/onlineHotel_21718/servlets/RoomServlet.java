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

/*import com.onlineHotel_21718.dao.CustomerDaoImpl;*/
import com.onlineHotel_21718.dao.RoomDaoImpl;
/*import com.onlineHotel_21718.pojo.Customer;
import com.onlineHotel_21718.pojo.Hotel;*/
import com.onlineHotel_21718.pojo.Room;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Room r=new Room();
		HttpSession session=request.getSession();
		
		boolean flag;
		String operation=request.getParameter("operation");
		RoomDaoImpl rdi=new RoomDaoImpl();
		
		if(operation!=null&&operation.equals("getRooms"))
		{
			int hotelId=Integer.parseInt(request.getParameter("hotelId"));
			List<Room>rlist=rdi.getRoomByHotelId(hotelId);
			session.setAttribute("Room_List",rlist);
			session.setAttribute("hotelID",hotelId);
			response.sendRedirect("RoomList.jsp");
			System.out.println(r);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Room r=new Room();
		RoomDaoImpl rdi=new RoomDaoImpl();
		boolean flag;
		
		int hotelId=Integer.parseInt(request.getParameter("hId"));
		String roomtype=request.getParameter("type");
		double charge=Double.parseDouble(request.getParameter("charge"));
		int rooms=Integer.parseInt(request.getParameter("number"));
		
		r.setHotelId(hotelId);
		r.setRoomType(roomtype);
		r.setRoomCharge(charge);
		r.setRoomNumbers(rooms);
		
		flag=rdi.addRoom(r);
		if(flag)
			{
			request.setAttribute("AddSucces", "Added Succesfully ");
			RequestDispatcher rd=request.getRequestDispatcher("RoomList.jsp");
			rd.forward(request, response);
			}
		else
			{
			request.setAttribute("Failed", "Unable to Delete ");
			RequestDispatcher rd=request.getRequestDispatcher("RoomList.jsp");
			rd.forward(request, response);
			}
	}
}
