package edu.thi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
@WebServlet(name = "registrationservlet", urlPatterns = { "/registrationservlet" })
public class RegistrationServlet extends HttpServlet {
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

		form.setAnrede(request.getParameter("anrede"));
		form.setVorname(request.getParameter("vorname"));
		form.setNachname(request.getParameter("nachname"));
		form.setStrasse(request.getParameter("strasse")); 
		form.setPlz(Integer.valueOf(request.getParameter("plz")));
		form.setOrt(request.getParameter("ort"));
		form.setBenutzername(request.getParameter("benutzername"));
		form.setPasswort(request.getParameter("passwort"));
		
		
		//später passwort vergleichen mit JavaScript - siehe code unten
//		<script>
//		$(document).ready(function()
//		{
//		    var $passwordFirst = $('.password-first');
//		    var $passwordSecond = $('.password-second');
//		    var $button = $('form input[type=submit]');
//
//		    $('.password').change(function()
//		    {
//		        if ($passwordFirst.val() == $passwordSecond.val()) {
//		            $button.removeAttr('disabled');
//		        } else {
//		            $button.attr('disabled', true);
//		        }
//		    });
//		});
//		</script>
//		
		
		// Scope "Request"
		persist(form);
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/1_outputdataRegistration.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void persist(Kunde form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO customers (anrede, vorname,nachname,strasse, plz, ort, benutzername, passwort) VALUES (?,?,?,?,?,?,?,?)", generatedKeys
							)){

					// Zugriff über Klasse java.sql.PreparedStatement
					pstmt.setString(1, form.getAnrede());
				 	pstmt.setString(2, form.getVorname());
				    pstmt.setString(3, form.getNachname());
				    pstmt.setString(4, form.getStrasse()); 
				    pstmt.setInt(5, form.getPlz());
				    pstmt.setString(6, form.getOrt());
				    pstmt.setString(7, form.getBenutzername());
				    pstmt.setString(8, form.getPasswort());
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