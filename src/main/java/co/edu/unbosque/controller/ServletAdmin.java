package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import co.edu.unbosque.model.PostuladoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ServletAdmin extends HttpServlet {
	private PostuladoDAO postul;

	public ServletAdmin() {
		postul = new PostuladoDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String referer = req.getHeader("Referer");
		if (referer != null && referer.contains("adm.jsp")) {
			postul.cotext(this.getServletContext());
			PrintWriter salida = new PrintWriter(resp.getWriter());
			salida.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "    <head>\r\n"
					+ "        <meta charset='utf-8'>\r\n" + "        <script\r\n"
					+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"\r\n"
					+ "            integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\"\r\n"
					+ "            crossorigin=\"anonymous\"></script>\r\n" + "        <title>(Admin) Lista</title>\r\n"
					+ "<style type=\"text/css\">\r\n"
					+ "@import url('https://fonts.googleapis.com/css?family=Raleway');\r\n" + "\r\n" + "@import\r\n"
					+ "	url(https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css)\r\n"
					+ "	;\r\n" + "\r\n" + "body::before {\r\n" + "	content: '';\r\n"
					+ "	background-color: rgba(0, 128, 0, 0.5);\r\n" + "	position: absolute;\r\n" + "	top: 0;\r\n"
					+ "	left: 0;\r\n" + "	bottom: 0;\r\n" + "	right: 0;\r\n" + "	z-index: -1;\r\n" + "}\r\n" + "\r\n"
					+ ".ini {\r\n" + "	font-family: 'Raleway', serif;\r\n"
					+ "	background-color: rgba(158, 255, 78, 0.5);\r\n" + "	background-image:\r\n"
					+ "		url(\"https://tecnomarketingnews.com/wp-content/uploads/2016/08/ubosquejpfg.jpg\");\r\n"
					+ "	background-repeat: no-repeat;\r\n" + "	background-size: cover;\r\n"
					+ "	background-attachment: fixed;\r\n" + "    overflow: scroll;\r\n" + "	position: relative;\r\n"
					+ "	margin: 0;\r\n" + "	padding: 0;\r\n" + "}\r\n" + "\r\n" + ".container {\r\n"
					+ "	height: 100vh;\r\n" + "}\r\n" + "\r\n" + "#pr {\r\n" + "	background-color: azure;\r\n"
					+ "	border-radius: 5px;\r\n" + "}\r\n" + "\r\n" + "#tit {\r\n" + "	font-size: 20px;\r\n" + "}\r\n"
					+ "</style>" + "    </head>\r\n" + "    <body class=\"ini\">\r\n"
					+ "        <h1 class=\"d-block p-2 text-bg-success text-center\"> Universidad el\r\n"
					+ "            Bosque</h1>\r\n" + "        <div class=\"container pt-lg-3\">\r\n"
					+ "            <div id=\"pr\">\r\n" + "                <div class=\"row pt-lg-3\">");
			salida.println(postul.getPostulados());
			salida.println(" <div class=\"position-fixed fixed-bottom fixed-right p-3\">\r\n"
					+ "            <a class=\"btn btn-success\" href=\"adm.jsp\">Volver</a>\r\n" + "        </div>\r\n"
					+ "    </body>\r\n" + "</html>");
			salida.close();
		} else if (referer != null && referer.contains("bus.jsp")) {
			postul.cotext(this.getServletContext());
			PrintWriter salida = new PrintWriter(resp.getWriter());
			String apell = req.getParameter("apellido");
			LocalDate fecha = LocalDate.parse(req.getParameter("fecha"));
			String tmp = postul.buscar(apell, fecha);
			if (tmp != null) {
				salida.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "    <head>\r\n"
						+ "        <meta charset='utf-8'>\r\n" + "        <script\r\n"
						+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"\r\n"
						+ "            integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\"\r\n"
						+ "            crossorigin=\"anonymous\"></script>\r\n"
						+ "        <title>(Admin) Lista</title>\r\n" + "<style type=\"text/css\">\r\n"
						+ "@import url('https://fonts.googleapis.com/css?family=Raleway');\r\n" + "\r\n" + "@import\r\n"
						+ "	url(https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css)\r\n"
						+ "	;\r\n" + "\r\n" + "body::before {\r\n" + "	content: '';\r\n"
						+ "	background-color: rgba(0, 128, 0, 0.5);\r\n" + "	position: absolute;\r\n"
						+ "	top: 0;\r\n" + "	left: 0;\r\n" + "	bottom: 0;\r\n" + "	right: 0;\r\n"
						+ "	z-index: -1;\r\n" + "}\r\n" + "\r\n" + ".ini {\r\n" + "	font-family: 'Raleway', serif;\r\n"
						+ "	background-color: rgba(158, 255, 78, 0.5);\r\n" + "	background-image:\r\n"
						+ "		url(\"https://tecnomarketingnews.com/wp-content/uploads/2016/08/ubosquejpfg.jpg\");\r\n"
						+ "	background-repeat: no-repeat;\r\n" + "	background-size: cover;\r\n"
						+ "	background-attachment: fixed;\r\n" + "    overflow: scroll;\r\n"
						+ "	position: relative;\r\n" + "	margin: 0;\r\n" + "	padding: 0;\r\n" + "}\r\n" + "\r\n"
						+ ".container {\r\n" + "	height: 100vh;\r\n" + "}\r\n" + "\r\n" + "#pr {\r\n"
						+ "	background-color: azure;\r\n" + "	border-radius: 5px;\r\n" + "}\r\n" + "\r\n"
						+ "#tit {\r\n" + "	font-size: 20px;\r\n" + "}\r\n" + "</style>" + "    </head>\r\n"
						+ "    <body class=\"ini\">\r\n"
						+ "        <h1 class=\"d-block p-2 text-bg-success text-center\"> Universidad el\r\n"
						+ "            Bosque</h1>\r\n" + "        <div class=\"container pt-lg-3\">\r\n"
						+ "            <div id=\"pr\">\r\n" + "                <div class=\"row pt-lg-3\">");
				salida.println(tmp);
				salida.println(" <div class=\"position-fixed fixed-bottom fixed-right p-3\">\r\n"
						+ "            <a class=\"btn btn-success\" href=\"adm.jsp\">Volver</a>\r\n"
						+ "        </div>\r\n" + "    </body>\r\n" + "</html>");
			} else if (tmp == null) {

				salida.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "    <head>\r\n"
						+ "        <meta charset='utf-8'>\r\n" + "        <script\r\n"
						+ "            src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js\"\r\n"
						+ "            integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe\"\r\n"
						+ "            crossorigin=\"anonymous\"></script>\r\n"
						+ "        <title>Operacion exitosa</title>\r\n" + "<style type=\"text/css\">\r\n"
						+ "@import url('https://fonts.googleapis.com/css?family=Raleway');\r\n" + "\r\n" + "@import\r\n"
						+ "	url(https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css)\r\n"
						+ "	;\r\n" + "\r\n" + "body::before {\r\n" + "	content: '';\r\n"
						+ "	background-color: rgba(0, 128, 0, 0.5);\r\n" + "	position: absolute;\r\n"
						+ "	top: 0;\r\n" + "	left: 0;\r\n" + "	bottom: 0;\r\n" + "	right: 0;\r\n"
						+ "	z-index: -1;\r\n" + "}\r\n" + "\r\n" + ".ini {\r\n" + "	font-family: 'Raleway', serif;\r\n"
						+ "	background-color: rgba(158, 255, 78, 0.5);\r\n" + "	background-image:\r\n"
						+ "		url(\"https://tecnomarketingnews.com/wp-content/uploads/2016/08/ubosquejpfg.jpg\");\r\n"
						+ "	background-repeat: no-repeat;\r\n" + "	background-size: cover;\r\n"
						+ "	background-attachment: fixed;\r\n" + "    overflow: scroll;\r\n"
						+ "	position: relative;\r\n" + "	margin: 0;\r\n" + "	padding: 0;\r\n" + "}\r\n" + "\r\n"
						+ ".container {\r\n" + "	height: 100vh;\r\n" + "}\r\n" + "\r\n" + "#pr {\r\n"
						+ "	background-color: azure;\r\n" + "	border-radius: 5px;\r\n" + "}\r\n" + "\r\n"
						+ "#tit {\r\n" + "	font-size: 20px;\r\n" + "}\r\n" + "</style>" + "\r\n" + "    </head>\r\n"
						+ "    <body class=\"ini\">\r\n"
						+ "        <h1 class=\"d-block p-2 text-bg-success text-center\"> Universidad el Bosque</h1>\r\n"
						+ "        <div class=\"container pt-lg-3\">\r\n"
						+ "            <div id=\"pr\" class=\"d-flex flex-column justify-content-center align-items-center py-5\">\r\n"
						+ "                <div class=\"alert alert-warning\" role=\"alert\">\r\n"
						+ "                    No se pudo encontrar correctamente a <strong>" + apell + "</strong>.\r\n"
						+ "                </div>                      \r\n"
						+ "                <a class=\"btn btn-danger mt-auto\" href=\"bus.jsp\">Volver a buscar</a>\r\n"
						+ "            </div>\r\n" + "        </div>\r\n" + "    </body>\r\n" + "    \r\n" + "</html>");
			}
			salida.close();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String referer = req.getHeader("Referer");
		if (referer != null && referer.contains("mod.jsp")) {
			postul.cotext(this.getServletContext());
			PrintWriter salida = new PrintWriter(resp.getWriter());
			salida.close();
		} else if (referer != null && referer.contains("eli.jsp")) {
			postul.cotext(this.getServletContext());
			PrintWriter salida = new PrintWriter(resp.getWriter());
			salida.close();
		}
	}
}
