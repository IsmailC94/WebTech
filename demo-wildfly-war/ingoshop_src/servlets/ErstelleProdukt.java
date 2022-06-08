package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.Pordukte;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/ErstelleProdukt")
public class ErstelleProdukt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/IngoShop")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8"); // 
		Pordukte form = new Pordukte();

		form.setProduktname(request.getParameter("produktname"));
		form.setArtikelgruppe(request.getParameter("artGrp"));
		form.setMenge(request.getParameter("menge"));
		form.setProduktpreis(request.getParameter("preis"));
		
		Part filePart = request.getPart("bildpfad");
		String fileName = filePart.getSubmittedFileName();
		String pfad = "C:\\upload\\"+fileName;
		
		for (Part part:request.getParts()) {
			part.write(pfad);
		}
		
		form.setBildpfad(pfad);
		
		
		
		// Scope "Request"
		persist(form);
		request.setAttribute("form", form);

		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("html/1_outputdataProduct.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void persist(Pordukte form) throws ServletException {
		
		   String[] generatedKeys = new String[] {"id"};
			
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(
							"INSERT INTO Produkte (ArtikelGrp, Produktname, Produktpreis, Menge, bildpfad) VALUES (?,?,?,?,?)", generatedKeys
							)){
                        
					// Zugriff über Klasse java.sql.PreparedStatement
					pstmt.setString(1, form.getArtikelgruppe());
					pstmt.setString(2, form.getProduktname());
					pstmt.setString(3, form.getProduktpreis());			 	
				 	pstmt.setString(4, form.getMenge());
				 	pstmt.setString(5, form.getBildpfad());
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