package edu.thi.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.sql.ResultSet;

import javax.sql.DataSource;

import edu.thi.uebung5.bean.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class createServlet
 */
@WebServlet(name = "createproductservlet", urlPatterns = {"/createproductservlet"})
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS2")
	private DataSource ds;
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Product form = new Product();
		form.setProductName(request.getParameter("productName"));
		form.setArticleGroup(Integer.valueOf(request.getParameter("articleGroup")));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		form.setPrice(Double.valueOf(request.getParameter("price")));
		

		// Datum im Format yyyy-mm-dd
		String dateString = request.getParameter("proddate");
		String[] dateArray = dateString.split("-");
		Calendar cal = Calendar.getInstance();
		int year = Integer.parseInt(dateArray[0]);
		int month = Integer.parseInt(dateArray[1])-1;
		int day = Integer.parseInt(dateArray[2]);
		cal.set(year, month, day);
		form.setProddate(cal.getTime());
		
		// Zeitfeld auswerten - Eingangsformat hh:mm
		String timeString = request.getParameter("prodtime");
		String[] timeArray = timeString.split(":");
		cal.set(year, month, day, Integer.parseInt(timeArray[0]), Integer.parseInt(timeArray[1]));
		form.setProdtime(cal.getTime());
		
		persist(form);
		request.setAttribute("form", form);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdataProduct.jsp");
		dispatcher.forward(request, response);
	}	
	
	private void persist(Product form) throws ServletException {
		
		String[] generatedKeys = new String[] {"productId"};

		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO produktliste (productName,articleGroup,quantity, price, proddate, prodtime) VALUES (?,?,?,?,?,?)", generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getProductName());
			pstmt.setInt(2, form.getArticleGroup());
			pstmt.setInt(3, form.getQuantity());
			pstmt.setDouble(4, form.getPrice());
			pstmt.setDate(5, new java.sql.Date(form.getProddate().getTime()));
			pstmt.setTime(6, new java.sql.Time(form.getProdtime().getTime()));
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setProductId(rs.getLong(1));
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}