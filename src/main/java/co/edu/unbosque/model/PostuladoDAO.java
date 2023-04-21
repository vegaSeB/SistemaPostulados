package co.edu.unbosque.model;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.google.common.io.BaseEncoding;

import co.edu.unbosque.model.persistance.FileHandler;
import co.edu.unbosque.view.VistaConsola;
import jakarta.servlet.ServletContext;

public class PostuladoDAO {
	private ArrayList<PostuladoDTO> postulados;
	private ServletContext context;

	/**
	 * @param context the path to the required information of the app
	 */
	public PostuladoDAO() {
	}

	public void cotext(ServletContext context) {
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
	 * @param nombres      name or names of the candidate
	 * @param apellidos    last names of the candidate
	 * @param colegio      the school which candidate have graduated from
	 * @param carrera      the career of of interest for the candidate
	 * @param estrato      the stratum of the candidate
	 * @param foto         a picture of the candidate
	 * @param fecha        the birthday of the candidate
	 * @param homologacion if there is any subject the candidate have seen in other
	 *                     college
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
	 * @param nombres      name or names of the candidate
	 * @param apellidosAnt the original last names of the candidate
	 * @param apellidos    last names of the candidate
	 * @param colegio      the school which candidate have graduated from
	 * @param carrera      the career of of interest for the candidate
	 * @param estrato      the stratum of the candidate
	 * @param foto         a picture of the candidate
	 * @param fechaAnt     the original date of the candidate
	 * @param fecha        the new date of the candidate
	 * @param homologacion if there is any subject the candidate have seen in other
	 *                     college
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
	 * @param fecha     the birthday of the candidate to search
	 * @return the candidate which was found
	 */
	public String buscar(String apellidos, LocalDate fecha) {
		String resultado = "";
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidos)
					&& postulados.get(i).getFecha().compareTo(fecha) == 0) {
				String homo = "";
				if (postulados.get(i).isHomologacion()) {
					homo = "Si";
				} else {
					homo = "No";
				}
				double precio = 0;
				if (postulados.get(i).getCarrera().equals("Administracion de Empresas")) {
					precio = 5.0;
				} else if (postulados.get(i).getCarrera().equals("Antropologia")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Arquitectura")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Artes Escenicas")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Biologia")) {
					precio = 6.0;
				} else if (postulados.get(i).getCarrera().equals("Ciencia Politica")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Comunicacion Social y Periodismo")) {
					precio = 6.0;
				} else if (postulados.get(i).getCarrera().equals("Contaduria Publica")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Derecho")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Diseno Grafico")) {
					precio = 6.0;
				} else if (postulados.get(i).getCarrera().equals("Economia")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Enfermeria")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Filosofia")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Fisioterapia")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Fonoaudiologia")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Ingenieria Ambiental")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Ingenieria Biomedica")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Ingenieria Civil")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Ingenieria de Sistemas")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Ingenieria Industrial")) {
					precio = 7.0;
				} else if (postulados.get(i).getCarrera().equals("Licenciatura en Educacion Infantil")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Licenciatura en Lengua Inglesa")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Matematicas")) {
					precio = 5.5;
				} else if (postulados.get(i).getCarrera().equals("Medicina")) {
					precio = 8;
				} else if (postulados.get(i).getCarrera().equals("Musica")) {
					precio = 6;
				} else if (postulados.get(i).getCarrera().equals("Nutricion y Dietetica")) {
					precio = 6.5;
				} else if (postulados.get(i).getCarrera().equals("Odontologia")) {
					precio = 7.5;
				} else if (postulados.get(i).getCarrera().equals("Psicologia")) {
					precio = 6;
				}
				File file = new File(context.getRealPath(
						"WEB-INF/classes/co/edu/unbosque/model/persistance" + "/" + postulados.get(i).getFoto()));
				byte[] fileContent = null;
				try {
					fileContent = FileUtils.readFileToByteArray(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				int length = fileContent.length;
				// Calcular la cantidad de bytes adicionales necesarios para completar el último
				// grupo de 3 bytes
				int padding = length % 3 == 0 ? 0 : 3 - length % 3;
				// Crear una nueva matriz de bytes con el tamaño adecuado
				byte[] paddedBytes = new byte[length + padding];
				System.arraycopy(fileContent, 0, paddedBytes, 0, length);
				String mimeType = "image/png";
				String base64Encoded = BaseEncoding.base64().encode(paddedBytes);
				resultado = " <div class=\"row mt-4\">\r\n"
						+ "                        <div class=\"col-2 text-center\">\r\n"
						+ "                            <img\r\n" + "                                src=\"" + "data:"
						+ mimeType + ";base64," + base64Encoded + "\">\r\n" + "                        </div>\r\n"
						+ "\r\n" + "                        <div class=\"col-10\">\r\n"
						+ "                            <table class=\"table\">\r\n"
						+ "                                <thead>\r\n" + "                                    <tr>\r\n"
						+ "                                        <th>Apellidos</th>\r\n"
						+ "                                        <th>Nombres</th>\r\n"
						+ "                                        <th>Colegio</th>\r\n"
						+ "                                        <th>Edad</th>\r\n"
						+ "                                        <th>Carrera</th>\r\n"
						+ "                                        <th>Valor</th>\r\n"
						+ "                                        <th>Estrato</th>\r\n"
						+ "                                        <th>Homologacion</th>\r\n"
						+ "                                    </tr>\r\n"
						+ "                                </thead>\r\n" + "                                <tbody>\r\n"
						+ "                                    <tr>\r\n"
						+ "                                        <td>" + postulados.get(i).getApellidos()
						+ "</td>\r\n" + "                                        <td>" + postulados.get(i).getNombres()
						+ "</td>\r\n" + "                                        <td>" + postulados.get(i).getColegio()
						+ "</td>\r\n" + "                                        <td>" + postulados.get(i).getEdad()
						+ "</td>\r\n" + "                                        <td>" + postulados.get(i).getCarrera()
						+ "</td>\r\n" + "                                        <td>" + precio + " M</td>\r\n"
						+ "                                        <td>" + postulados.get(i).getEstrato() + "</td>\r\n"
						+ "                                        <td>" + homo + "</td>\r\n"
						+ "                                    </tr>\r\n"
						+ "                                </tbody>\r\n" + "                            </table>\r\n"
						+ "                        </div>\r\n" + "                    </div>\r\n";

				VistaConsola.msm("Postulate " + apellidos + " successfully found", context);
				return resultado;
			}
		}
		VistaConsola.msm("Postulate " + apellidos + " not found", context);
		return null;
	}

	/**
	 * 
	 * @param apellidos the last names of the candidate
	 * @param fecha     the birthday of the candidate
	 * @param foto      the picture of the candidate
	 * @return a boolean to know if the candidate is saved
	 */
	public boolean isExistente(String apellidos, LocalDate fecha, String foto) {
		for (int i = 0; i < postulados.size(); i++) {
			if (postulados.get(i).getApellidos().equalsIgnoreCase(apellidos)
					&& postulados.get(i).getFecha().compareTo(fecha) == 0 && postulados.get(i).getFoto().equals(foto)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param fecha a date given by the candidate
	 * @return the subtraction of the years between the date given and the present
	 *         date
	 */
	public byte calcularEdad(LocalDate fecha) {
		LocalDate actual = LocalDate.now();
		return (byte) fecha.until(actual, ChronoUnit.YEARS);
	}

	public String getPostulados() {
		StringBuilder sb = new StringBuilder("");
		for (PostuladoDTO pos : postulados) {
			String homo = "";
			if (pos.isHomologacion()) {
				homo = "Si";
			} else {
				homo = "No";
			}
			double precio = 0;
			if (pos.getCarrera().equals("Administracion de Empresas")) {
				precio = 5.0;
			} else if (pos.getCarrera().equals("Antropologia")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Arquitectura")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Artes Escenicas")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Biologia")) {
				precio = 6.0;
			} else if (pos.getCarrera().equals("Ciencia Politica")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Comunicacion Social y Periodismo")) {
				precio = 6.0;
			} else if (pos.getCarrera().equals("Contaduria Publica")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Derecho")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Diseno Grafico")) {
				precio = 6.0;
			} else if (pos.getCarrera().equals("Economia")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Enfermeria")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Filosofia")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Fisioterapia")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Fonoaudiologia")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Ingenieria Ambiental")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Ingenieria Biomedica")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Ingenieria Civil")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Ingenieria de Sistemas")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Ingenieria Industrial")) {
				precio = 7.0;
			} else if (pos.getCarrera().equals("Licenciatura en Educacion Infantil")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Licenciatura en Lengua Inglesa")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Matematicas")) {
				precio = 5.5;
			} else if (pos.getCarrera().equals("Medicina")) {
				precio = 8;
			} else if (pos.getCarrera().equals("Musica")) {
				precio = 6;
			} else if (pos.getCarrera().equals("Nutricion y Dietetica")) {
				precio = 6.5;
			} else if (pos.getCarrera().equals("Odontologia")) {
				precio = 7.5;
			} else if (pos.getCarrera().equals("Psicologia")) {
				precio = 6;
			}
			File file = new File(
					context.getRealPath("WEB-INF/classes/co/edu/unbosque/model/persistance" + "/" + pos.getFoto()));
			byte[] fileContent = null;
			try {
				fileContent = FileUtils.readFileToByteArray(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			int length = fileContent.length;
			// Calcular la cantidad de bytes adicionales necesarios para completar el último
			// grupo de 3 bytes
			int padding = length % 3 == 0 ? 0 : 3 - length % 3;
			// Crear una nueva matriz de bytes con el tamaño adecuado
			byte[] paddedBytes = new byte[length + padding];
			System.arraycopy(fileContent, 0, paddedBytes, 0, length);
			String mimeType = "image/png";
			String base64Encoded = BaseEncoding.base64().encode(paddedBytes);
			sb.append(" <div class=\"row mt-4\">\r\n" + "                        <div class=\"col-2 text-center\">\r\n"
					+ "                            <img\r\n" + "                                src=\"" + "data:"
					+ mimeType + ";base64," + base64Encoded + "\">\r\n" + "                        </div>\r\n" + "\r\n"
					+ "                        <div class=\"col-10\">\r\n"
					+ "                            <table class=\"table\">\r\n"
					+ "                                <thead>\r\n" + "                                    <tr>\r\n"
					+ "                                        <th>Apellidos</th>\r\n"
					+ "                                        <th>Nombres</th>\r\n"
					+ "                                        <th>Colegio</th>\r\n"
					+ "                                        <th>Edad</th>\r\n"
					+ "                                        <th>Carrera</th>\r\n"
					+ "                                        <th>Valor</th>\r\n"
					+ "                                        <th>Estrato</th>\r\n"
					+ "                                        <th>Homologacion</th>\r\n"
					+ "                                    </tr>\r\n" + "                                </thead>\r\n"
					+ "                                <tbody>\r\n" + "                                    <tr>\r\n"
					+ "                                        <td>" + pos.getApellidos() + "</td>\r\n"
					+ "                                        <td>" + pos.getNombres() + "</td>\r\n"
					+ "                                        <td>" + pos.getColegio() + "</td>\r\n"
					+ "                                        <td>" + pos.getEdad() + "</td>\r\n"
					+ "                                        <td>" + pos.getCarrera() + "</td>\r\n"
					+ "                                        <td>" + precio + " M</td>\r\n"
					+ "                                        <td>" + pos.getEstrato() + "</td>\r\n"
					+ "                                        <td>" + homo + "</td>\r\n"
					+ "                                    </tr>\r\n" + "                                </tbody>\r\n"
					+ "                            </table>\r\n" + "                        </div>\r\n"
					+ "                    </div>\r\n");
		}
		return sb.toString();
	}
}
