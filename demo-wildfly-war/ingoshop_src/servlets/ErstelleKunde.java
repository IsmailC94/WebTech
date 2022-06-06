package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Date;

import javax.sql.DataSource;

import beans.Kunde;
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
@WebServlet("/ErstelleKunde")
public class ErstelleKunde extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/IngoShop")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		Kunde form = new Kunde();

		form.setFamName(request.getParameter("FamName"));
		form.setVorname(request.getParameter("vorname"));
		form.setStrasse(request.getParameter("strasse")); 
		form.setHausnummer(request.getParameter("hausnummer")); 
		form.setOrt(request.getParameter("ort"));
		form.setPlz(request.getParameter("plz")); 
		form.setPasswort(request.getParameter("passwort"));
		form.setGeschlecht(request.getParameter("geschlecht"));
		form.setGeburtsdatum(request.getParameter("geburtsdatum"));
		form.seteMail(request.getParameter("email"));
	
		
		// Scope "Request"
		persist(form);
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/1_outputdataRegistration.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void persist(Kunde form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO Kunden (FamName, Vorname, Straße, Hausnummer, Ort, PLZ, Passwort, geschlecht, eMail, Geburtsdatum, admin) VALUES (?,?,?,?,?,?,?,?,?,?,?)", generatedKeys
							)){
                        
					// Zugriff über Klasse java.sql.PreparedStatement
				 	pstmt.setString(1, form.getFamName());	
				 	pstmt.setString(2, form.getVorname());
				 	 pstmt.setString(3, form.getStrasse()); 
				    pstmt.setString(4, form.getHausnummer()); 
				    pstmt.setString(5, form.getOrt()); 
				    pstmt.setString(6, form.getPlz());
				    pstmt.setString(7, form.getPasswort());
				    pstmt.setString(8, form.getGeschlecht());
				    pstmt.setString(9, form.geteMail());
				    pstmt.setString(9, form.geteMail());   
				    pstmt.setString(10, form.getGeburtsdatum());
				    pstmt.setInt(11, 0);
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