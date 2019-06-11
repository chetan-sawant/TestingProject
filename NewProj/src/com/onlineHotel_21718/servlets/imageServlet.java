package com.onlineHotel_21718.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineHotel_21718.dao.HotelDaoImpl;
import com.onlineHotel_21718.pojo.Hotel;

/**
 * Servlet implementation class imageServlet
 */
@WebServlet("/img")
public class imageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());*/
		
		int hotelId=Integer.parseInt(request.getParameter("hotelId"));
		HotelDaoImpl hdi=new HotelDaoImpl();
		Hotel h=hdi.getHotelById(hotelId);
		InputStream is=h.getIs();
		response.setContentType("image/*");
		OutputStream os=response.getOutputStream();
		 if(is!=null)
		 {
			 int d=is.read();
			 while(d!=-1)
			 {
				 os.write(d);
				 d=is.read();
			 }
			 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
