/**
 * 
 */
package co.edu.unbosque.model.persistance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

import co.edu.unbosque.model.PostuladoDTO;
import co.edu.unbosque.view.VistaConsola;
import jakarta.servlet.ServletContext;

/**
 * File management class
 * 
 * @author Johan Silva
 * @author Miguel Linarez
 */
public class FileHandler {

	private static FileInputStream fis;
	private static ObjectInputStream ois;
	private static FileOutputStream fos;
	private static ObjectOutputStream oos;

	/**
	 * Method for writing to a serialized file<br>
	 * <b>pre: </b> It is required to write to the serialized file on condition that
	 * it is "Existing"<br>
	 * <b>post: </b> Write to the serialized file
	 * 
	 * @param o "Object" to be written in the serialized
	 */
	public static void writeSerializable(Object o, ServletContext req) {
		try {
			fos = new FileOutputStream(
					req.getRealPath("/") + "WEB-INF/classes/co/edu/unbosque/model/persistance/guardado.post");
			oos = new ObjectOutputStream(fos);
			VistaConsola.msm("Serialized file opened successfully", req);
		} catch (IOException e) {
			VistaConsola.err("Could not open serialized file because of the following error", e.getLocalizedMessage(),
					req);
		}
		try {
			oos.writeObject(o);
			fos.close();
			oos.close();
			VistaConsola.msm("Wrote to serializable file successfully", req);
		} catch (IOException e) {
			VistaConsola.err("Could not write to serialized file because of the following error",
					e.getLocalizedMessage(), req);
		}
	}

	/**
	 * Method for loading information from a serialized file<br>
	 * <b>pre: </b>The file to be uploaded exists<br>
	 * <b>post: </b> The file information is loaded into the program
	 * 
	 * @return Object with loaded information
	 */
	public static Object loadSerializable(ServletContext req) {
		Object tmp = null;
		try {
			fis = new FileInputStream(
					req.getRealPath("/") + "WEB-INF/classes/co/edu/unbosque/model/persistance/guardado.post");
			ois = new ObjectInputStream(fis);
			tmp = ois.readObject();
			ois.close();
			fis.close();
			VistaConsola.msm("Serialized file uploaded successfully", req);
		} catch (IOException | ClassNotFoundException e) {
			VistaConsola.err("Failed to load serialized file due to the following error", e.getLocalizedMessage(), req);
			tmp = null;
		}
		return tmp;
	}

	public static void writeHistory(String msm, ServletContext req) {
		try {
			FileWriter fw = new FileWriter(
					req.getRealPath("/") + "WEB-INF/classes/co/edu/unbosque/model/persistance/History.txt", true);
			fw.write(msm + "\n");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generarCSV(ArrayList<PostuladoDTO> postulados, String fileName, ServletContext req) {
		try {
			FileWriter fw = new FileWriter(System.getProperty("user.home") + "/" + "Desktop/" + fileName);
			CSVWriter csvW = new CSVWriter(fw, ';', CSVWriter.DEFAULT_QUOTE_CHARACTER,
					CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
			String[] encabezados = { "Nombre/s", "Apellido/s", "Colegio", "Carrera", "Estrato", "Fecha de nacimiento",
					"Homologacion", "Edad", "Foto" };
			csvW.writeNext(encabezados);

			for (PostuladoDTO post : postulados) {
				String[] fila = { post.getNombres(), post.getApellidos(), post.getColegio(), post.getCarrera(),
						post.getEstrato(), post.getFecha().toString(), String.valueOf(post.isHomologacion()),
						String.valueOf(post.getEdad()), post.getFoto() };
				csvW.writeNext(fila);
			}

			csvW.close();
			VistaConsola.msm("CSV file updated successfully", req);
		} catch (Exception e) {
			VistaConsola.err("CSV file updated incorrectly due to the following error", e.getLocalizedMessage(), req);
		}
	}
}
