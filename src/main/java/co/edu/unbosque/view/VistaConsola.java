package co.edu.unbosque.view;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.persistance.FileHandler;
import jakarta.servlet.ServletContext;

public class VistaConsola {

	public static void msm(String msm, ServletContext req) {
		try {
			System.setOut(new PrintStream(System.out, true, "UTF-8"));
			System.setErr(new PrintStream(System.err, true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(ansi().fgBlue()
				.a(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a")) + ": " + msm));
		FileHandler.writeHistory(
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a")) + ": " + msm, req);
	}

	public static void err(String msm, String err, ServletContext req) {
		try {
			System.setOut(new PrintStream(System.out, true, "UTF-8"));
			System.setErr(new PrintStream(System.err, true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(ansi().fgRgb(255, 77, 0)
				.a(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a")) + " " + msm
						+ " -> \n" + err));
		FileHandler.writeHistory(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, YYYY h:mm:ss a")) + " "
				+ msm + " -> \n" + err, req);
	}
}
