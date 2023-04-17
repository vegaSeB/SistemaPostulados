package co.edu.unbosque.controller;

import co.edu.unbosque.view.VistaConsola;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class ServletUser extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter salida = new PrintWriter(resp.getWriter());
		String nomb = req.getParameter("nombre");
		salida.println("<html>\r\n" + " <head>\r\n" + " </head>\r\n" + " <body>\r\n" + "   <h1>Hello World " + nomb
				+ "<h1>\r\n" + " </body>\r\n" + "</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomb = req.getParameter("nombre");
		VistaConsola.msm(nomb, getServletContext());
		System.err.println(nomb);
	}
}
