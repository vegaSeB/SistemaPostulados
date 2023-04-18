package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@SuppressWarnings("serial")
@MultipartConfig
public class ServletUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nomb = req.getParameter("nombre");
		String apell = req.getParameter("apellido");
		String cole = req.getParameter("colegio");
		String fecha = req.getParameter("fecha");
		String carrera = req.getParameter("carrera");
		String estrato = req.getParameter("apellio");
		System.out.println(nomb);
		//
		String regex = "image/(jpeg|png)";
		Pattern pattern = Pattern.compile(regex);
		Part filePart = req.getPart("foto");
		String contentType = filePart.getContentType();
		Matcher matcher = pattern.matcher(contentType);
		if (!matcher.matches()) {
			resp.getWriter().println("Tipo de archivo no válido. Solo se permiten archivos JPEG y PNG.");
			return;
		}
		String fileName = UUID.randomUUID().toString();
		if (contentType.equals("image/jpeg")) {
			fileName += ".jpg";
		} else if (contentType.equals("image/png")) {
			fileName += ".png";
		}
		Path filePath = Paths.get(
				this.getServletContext().getRealPath("/") + "WEB-INF/classes/co/edu/unbosque/model/persistance/",
				fileName);
		try (InputStream inputStream = filePart.getInputStream()) {
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.err.println("Archivo cargado con éxito. " + this.getServletContext().getRealPath("/")
				+ "WEB-INF/classes/co/edu/unbosque/model/persistance/" + fileName);
	}
}
