package edu.thi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.sql.DataSource;

import edu.thi.uebung5.bean.ProductUebung5;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet(name = "createservlet", urlPatterns = { "/createservlet" })
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS2")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Speicherung der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		ProductUebung5 form = new ProductUebung5();
		form.setProductname(request.getParameter("productname"));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		
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
		
		// DB-Zugriff
		persist(form);
		
		// Scope "Request"
		request.setAttribute("form", form);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdataKunde.jsp");
		dispatcher.forward(request, response);
	}

	private void persist(ProductUebung5 form) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO products (productname,quantity,proddate,prodtime) VALUES (?,?,?,?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getProductname());
			pstmt.setInt(2, form.getQuantity());
			pstmt.setDate(3, new java.sql.Date(form.getProddate().getTime()));
			pstmt.setTime(4, new java.sql.Time(form.getProdtime().getTime()));
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setId(rs.getLong(1));
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
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
