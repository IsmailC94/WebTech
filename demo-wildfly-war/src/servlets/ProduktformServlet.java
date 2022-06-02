package edu.thi.servlets;

import java.io.IOException;


import edu.thi.bean.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ProduktformServlet
 */
@WebServlet("/ProduktformServlet")
public class ProduktformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten und Generierung eines Beans zur Weitergabe
		// der Formulardaten an eine JSP
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
												// Alternative: GlassFish dazu bewegen, die Formulardaten gleich
												// als UTF-8 zu interpretieren. Dazu muss GlassFish auf UTF-8 umge-
												// stellt werden. Eine neue Zeile in die Datei glassfish-web.xml
												// ergänzen (zu finden im WEB-INF-Ordner des Projektes):
												// <parameter-encoding default-charset="UTF-8" />
		ProductUebung5 form = new ProductUebung5();
		form.setProductid(request.getParameter("productid"));
		form.setProductname(request.getParameter("productname"));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		form.setSupplier(request.getParameter("supplier"));
		
		// Weiterleiten an JSP per forward() --> Bean in Scope "Request" legen
		request.setAttribute("myProductForm", form);
		// final RequestDispatcher dispatcher = request.getRequestDispatcher("Uebung_4/1_Formular/produktform1c.jsp");
		// dispatcher.forward(request, response);
		
		// Weiterleiten an JSP per redirect() --> Bean in Scope "Session" legen
		HttpSession session = request.getSession();
		session.setAttribute("myProductForm", form);
		response.sendRedirect("uebung4/1_Formular/produktform1c.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
