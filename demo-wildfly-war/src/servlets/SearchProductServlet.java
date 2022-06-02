package edu.thi.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "searchproductservlet", urlPatterns = { "/searchproductservlet" })
public class SearchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS2")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		String productName = request.getParameter("productName");

		List<Product> produktliste = search(productName);
		
		request.setAttribute("produktliste", produktliste);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung5/2_searchproduktresult.jsp");
		dispatcher.forward(request, response);	
	}

	private List<Product> search(String productName) throws ServletException {
		productName = (productName == null || productName == "") ? "%" : "%" + productName + "%";
		List<Product> produktliste = new ArrayList<Product>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM produktliste WHERE productName LIKE ?")) {

			pstmt.setString(1, productName);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					Product product = new Product();
					product.setProductId(Long.valueOf(rs.getLong("productId")));
					product.setProductName(rs.getString("productName"));
					product.setArticleGroup(rs.getInt("articleGroup"));
					product.setQuantity(rs.getInt("quantity"));
					product.setPrice(rs.getDouble("price"));
					product.setProddate(rs.getDate("proddate"));
					product.setProdtime(rs.getTime("prodtime"));
					
					produktliste.add(product);
				} // while rs.next()
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return produktliste;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}