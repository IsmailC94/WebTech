package edu.thi.demo;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

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
		ErstelleKundeBean form = new ErstelleKundeBean();

		
		form.setEmail(request.getParameter("email"));
		form.setGeschl(request.getParameter("geschlecht"));
		form.setGebDatum(request.getParameter("gebDatum"));
		form.setPLZ(request.getParameter("plz"));
		form.setOrt(request.getParameter("ort"));
		form.setHausNr(Integer.valueOf("hausNr"));
		form.setStr(request.getParameter("strasse"));
		form.setVorname(request.getParameter("vorname"));
		form.setFamName(request.getParameter("nachname"));
		form.setKdNr(Integer.valueOf("kundennummer"));
		form.setPasswort(request.getParameter("password"));
		

		
uebertragung(form);
		// Scope "Request"
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/registerAusgabe.jsp");
		dispatcher.forward(request, response);

	}
	// Dieser String wird in die DB eingefügt
	private void persist(ErstelleKunde form) throws ServletException {
	String eingabe = " insert into kunden (Email, FamName, Geburtsdatum, Geschlecht, Hausnummer, Ort, PLZ, Straße, Vorname, KundenNr)"
		    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";}
	private void uebertragung(ErstelleKundeBean form) throws ServletException {
		String[] generatedKeys = new String[] {"Email"};	
		
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO kunden (Vorname, Nachname, Username, Passwort, Email, Telefon) VALUES (?,?,?,?,?,?)", 
						generatedKeys)){

				// Zugriff über Klasse java.sql.PreparedStatement
				pstmt.setString(1, form.getEmail());
				pstmt.setString(2, form.getGeschl());
				pstmt.setString(3, form.getGebDatum());
				pstmt.setString(4, form.getPasswort());
				pstmt.setString(5, form.getPLZ());
				pstmt.setString(6, form.getOrt());
				pstmt.setLong(7, form.getHausNr());
				pstmt.setString(8, form.getStr());
				pstmt.setString(9, form.getVorname());
				pstmt.setString(10, form.getFamName());
				pstmt.setInt(11, form.getKdNr());
				pstmt.setString(12, form.getPasswort());
				pstmt.executeUpdate();
		
				
				// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					while (rs.next()) {
						form.setKdNr(rs.getInt(1));
					}
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
