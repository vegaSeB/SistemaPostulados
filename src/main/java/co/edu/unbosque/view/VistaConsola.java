package co.edu.unbosque.view;

import static org.fusesource.jansi.Ansi.ansi;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import co.edu.unbosque.model.persistance.FileHandler;
import jakarta.servlet.ServletContext;

/**
 * The console view class
 * 
 * @author Johan Silva
 * @author Sebastian Vega
 * @author Miguel Linarez
 */
public class VistaConsola {

	/**
	 * A method to show a message to the console if it is needed
	 * @param msm the message to be shown
	 * @param req the context of the server
	 */
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

	/**
	 * This shows a messages and the error when something goes wrong in the program
	 * @param msm the message of the cause of the error
	 * @param err the error message
	 * @param req the server context
	 */
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
