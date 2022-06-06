package servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.sql.DataSource;

import beans.Artikel;

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
@WebServlet("/produkthinzufuegenservlet")
public class ArtikelHinzufuegen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/IngoShop")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		Artikel form = new Artikel();

		form.setProduktname(request.getParameter("produktname"));
		
		
		
		// Scope "Request"
		persist(form);
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/1_outputdataRegistration.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void persist(Artikel form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO Kunden (Produkt) VALUES (?)", generatedKeys
							)){
                        
					// Zugriff über Klasse java.sql.PreparedStatement
				 	pstmt.setString(1, form.getProduktname());	
				 	
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