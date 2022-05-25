package edu.thi.demo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import edu.thi.demo.ErstelleKundeBean;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */


@WebServlet("/ErstelleKunde")
public class ErstelleKunde extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/Ingoshop")
	private DataSource ds;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		ErstelleKunde form = new ErstelleKunde();

		
		form.setVorname(request.getParameter("vorname"));
		form.setNachname(request.getParameter("nachname"));
		form.setUsername(request.getParameter("username"));
		form.setPasswort(request.getParameter("password"));
		form.setEmail(request.getParameter("email"));
		form.setTelefon(Long.valueOf(request.getParameter("telefon")));

		
uebertragung(form);
		// Scope "Request"
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registerAusgabe.jsp");
		dispatcher.forward(request, response);

	}
	// Dieser String wird in die DB eingefügt
	private void persist(ErstelleKunde form) throws ServletException {
	String eingabe = " insert into users (Email, FamName, Geburtsdatum, Geschlecht, Hausnummer, Ort, PLZ, Straße, Vorname)"
		    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private void uebertragung(ErstelleKunde form) throws ServletException {
		String[] generatedKeys = new String[] {"Email"};	
		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO userdata (Vorname, Nachname, Username, Passwort, Email, Telefon) VALUES (?,?,?,?,?,?)", 
						generatedKeys)){

				// Zugriff über Klasse java.sql.PreparedStatement
				pstmt.setString(1, form.getEmail);
				pstmt.setString(2, form.getNachname());
				pstmt.setString(3, form.getUsername());
				pstmt.setString(4, form.getPasswort());
				pstmt.setString(5, form.getEmail());
				pstmt.setLong(6, form.getTelefon());
				pstmt.executeUpdate();
				
				// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
				
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
