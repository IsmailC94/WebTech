package edu.thi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "searchservlet", urlPatterns = { "/searchservlet" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		String productname = request.getParameter("productname");
		
		// DB-Zugriff
		List<ProductUebung5> products = search(productname);
				
		// Scope "Request"
		request.setAttribute("products", products);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/2_searchresult.jsp");
		dispatcher.forward(request, response);	
	}

	private List<ProductUebung5> search(String productname) throws ServletException {
		productname = (productname == null || productname == "") ? "%" : "%" + productname + "%";
		List<ProductUebung5> products = new ArrayList<ProductUebung5>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM products WHERE productname LIKE ?")) {

			pstmt.setString(1, productname);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					ProductUebung5 product = new ProductUebung5();
					product.setId(Long.valueOf(rs.getLong("id")));
					product.setProductname(rs.getString("productname"));
					product.setQuantity(rs.getInt("quantity"));
					product.setProddate(rs.getDate("proddate"));
					product.setProdtime(rs.getTime("prodtime"));
					
					products.add(product);
				} // while rs.next()
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return products;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
