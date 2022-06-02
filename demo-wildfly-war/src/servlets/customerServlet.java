package edu.thi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.sql.DataSource;

import edu.thi.uebung5.bean.Kunde;
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
@WebServlet(name = "customerservlet", urlPatterns = { "/customerservlet" })
public class customerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS2")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		Kunde form = new Kunde();

		
		form.setVorname(request.getParameter("vorname"));
		form.setNachname(request.getParameter("nachname"));
		form.setStrasse(request.getParameter("strasse")); //gemeint ist hier addresse -> schlechte Bezeichnung
		form.setPlz(Integer.valueOf(request.getParameter("plz")));
		form.setOrt(request.getParameter("ort"));
		
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
		// Scope "Request"
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdataKunde.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void persist(Kunde form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO customers2 (vorname,nachname,strasse, plz, ort, proddate, prodtime) VALUES (?,?,?,?,?,?,?)", generatedKeys
							)){

					// Zugriff über Klasse java.sql.PreparedStatement
				
				 	pstmt.setString(1, form.getVorname());
				    pstmt.setString(2, form.getNachname());
				    pstmt.setString(3, form.getStrasse()); 
				    pstmt.setInt(4, form.getPlz());
				    pstmt.setString(5, form.getOrt());
				    pstmt.setDate(6, new java.sql.Date(form.getProddate().getTime()));
					pstmt.setTime(7, new java.sql.Time(form.getProdtime().getTime()));
					pstmt.executeUpdate();
					
					
			
					
					ResultSet rs = pstmt.getGeneratedKeys();				
						while (rs.next()) {
							form.setId(rs.getLong(1));
						}
					
				} catch (Exception ex) {
					throw new ServletException(ex.getMessage());
				}
			}
		
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

	}
