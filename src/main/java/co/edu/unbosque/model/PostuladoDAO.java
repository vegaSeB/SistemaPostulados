package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.VistaConsola;
import jakarta.servlet.ServletContext;

public class PostuladoDAO {
	private ArrayList<PostuladoDTO> postulados;
	private ServletContext context;
	
	/**
	 * @param context the path to the required information of the app
	 */
	public PostuladoDAO(ServletContext context) {
		this.context = context;
		cargar(context);
	}

	@SuppressWarnings("unchecked")
	/**
	 * @param context the path to the required information of the app
	 */
	public void cargar(ServletContext cont) {
		ArrayList<PostuladoDTO> tmp = (ArrayList<PostuladoDTO>) FileHandler.loadSerializable(cont);
		if (tmp != null) {
			postulados = tmp;
		} else {
			postulados = new ArrayList<>();
			VistaConsola.msm("Postulates loaded successfully", context);
			postulados = new ArrayList<>();
			VistaConsola.msm("ArrayList Postulates created successfully", context);
		}
	}

	/**
	 * @param context the path to the required information of the app
	 */
	public void guardar(ServletContext cont) {
		FileHandler.writeSerializable(postulados, cont);
		VistaConsola.msm("ArrayList Postulates saved serialized correctly", context);
	}

	/**
	 * @param nombres name or names of the candidate
	 * @param apellidos last names of the candidate
	 * @param colegio the school which candidate have graduated from
	 * @param carrera the career of of interest for the candidate
	 * @param estrato the stratum of the candidate
	 * @param foto a picture of the candidate
	 * @param fecha the birthday of the candidate
	 * @param homologacion if there is any subject the candidate have seen in other college
	 */
	public boolean crear(String nombres, String apellidos, String colegio, String carrera, String estrato, String foto,
			LocalDate fecha, boolean homologacion) {
		try {
			if (!isExistente(apellidos, fecha, foto)) {
				postulados.add(new PostuladoDTO(nombres, apellidos, colegio, carrera, estrato, foto, fecha,
						homologacion, calcularEdad(fecha)));
				guardar(context);
				FileHandler.generarCSV(postulados, "Datos.csv", context);
				VistaConsola.msm("Postulate " + apellidos + " successfully created", context);
				return true;
			} else {
				VistaConsola.msm("Postulate " + apellidos + " not created due to having another similar postulate",
						context);
				return false;
			}
		} catch (Exception e) {
			VistaConsola.err("Postulate " + apellidos + " not created because of the following error",
					e.getLocalizedMessage(), context);
			return false;
		}
	}

	/**
	 * @param apellidos
	 * @param fecha
	 * @return a boolean to know if the candidate has been successfully deleted
	 */
	public boolean eliminar(String apellidos, LocalDate fecha) {
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidos)
					&& postulados.get(i).getFecha().compareTo(fecha) == 0) {
				postulados.remove(i);
				guardar(context);
				FileHandler.generarCSV(postulados, "Datos.csv", context);
				VistaConsola.msm("Postulate " + apellidos + " successfully removed", context);
				return true;
			}
		}
		VistaConsola.msm("Postulate " + apellidos + " to delete not found", context);
		return false;
	}
	
	/**
	 * 
	 * @param nombres name or names of the candidate
	 * @param apellidosAnt the original last names of the candidate
	 * @param apellidos last names of the candidate
	 * @param colegio the school which candidate have graduated from
	 * @param carrera the career of of interest for the candidate
	 * @param estrato the stratum of the candidate
	 * @param foto a picture of the candidate
	 * @param fechaAnt the original date of the candidate
	 * @param fecha the new date of the candidate
	 * @param homologacion if there is any subject the candidate have seen in other college
	 * @return a boolean to know if the candidate was successfully updated
	 */
	public boolean modificar(String nombres, String apellidosAnt, String apellidos, String colegio, String carrera,
			String estrato, String foto, LocalDate fechaAnt, LocalDate fecha, boolean homologacion) {
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidosAnt)
					&& postulados.get(i).getFecha().compareTo(fechaAnt) == 0) {
				postulados.set(i, new PostuladoDTO(nombres, apellidos, colegio, carrera, estrato, foto, fecha,
						homologacion, calcularEdad(fecha)));
				guardar(context);
				FileHandler.generarCSV(postulados, "Datos.csv", context);
				VistaConsola.msm("Correctly modified postulate " + apellidos, context);
				return true;
			}
		}
		VistaConsola.msm("Postulate " + apellidos + " to modify not found", context);
		return false;
	}
	
	/**
	 * 
	 * @param apellidos the last names of the searched candidate
	 * @param fecha the birthday of the candidate to search
	 * @return the candidate which was found
	 */
	public PostuladoDTO buscar(String apellidos, LocalDate fecha) {
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidos)
					&& postulados.get(i).getFecha().compareTo(fecha) == 0) {
				VistaConsola.msm("Postulate " + apellidos + " successfully found", context);
				return postulados.get(i);
			}
		}
		VistaConsola.msm("Postulate " + apellidos + " not found", context);
		return null;
	}

	/**
	 * 
	 * @param apellidos the last names of the candidate
	 * @param fecha the birthday of the candidate
	 * @param foto the picture of the candidate
	 * @return a boolean to know if the candidate is saved
	 */
	public boolean isExistente(String apellidos, LocalDate fecha, String foto) {
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidos)
					|| postulados.get(i).getFecha().compareTo(fecha) == 0 || postulados.get(i).getFoto().equals(foto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param fecha a date given by the candidate
	 * @return the subtraction of the years between the date given and the present date
	 */
	public byte calcularEdad(LocalDate fecha) {
		LocalDate actual = LocalDate.now();
		return (byte) fecha.until(actual, ChronoUnit.YEARS);
	}
	
	/**
	 * @return the list of candidates
	 */
	public ArrayList<PostuladoDTO> getPostulados() {
		return postulados;
	}
}
