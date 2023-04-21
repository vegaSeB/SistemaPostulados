package co.edu.unbosque.model;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class PostuladoDTO implements Serializable {
	private String nombres;
	private String apellidos;
	private String colegio;
	private String carrera;
	private String estrato;
	private String foto;
	private LocalDate fecha;
	private boolean homologacion;
	private byte edad;

	/**
	 * The constructor with the variables that can that the object/class has
	 * @param nombres the name of the Postulado
	 * @param apellidos the last names of the Postulado
	 * @param colegio the name of the school the Postulado graduated from
	 * @param carrera the career the Postulado is interested of
	 * @param estrato the stratum of the Postulado
	 * @param foto the string of the foto given by the Postulado
	 * @param fecha the birth day of the Postulado
	 * @param homologacion the homologacion state of the Postulado
	 * @param edad the age of the Postulado
	 */
	public PostuladoDTO(String nombres, String apellidos, String colegio, String carrera, String estrato, String foto,
			LocalDate fecha, boolean homologacion, byte edad) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.colegio = colegio;
		this.carrera = carrera;
		this.estrato = estrato;
		this.foto = foto;
		this.fecha = fecha;
		this.homologacion = homologacion;
		this.edad = edad;
	}

	/**
	 * accesses to the name of the Postulado
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * changes the name of the Postulado
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * accesses to the last names of the Postulado
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * changes the last names of the Postulado
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * accesses to the school of the Postulado
	 * @return the colegio
	 */
	public String getColegio() {
		return colegio;
	}

	/**
	 * changes the school of the Postulado
	 * @param colegio the colegio to set
	 */
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	/**
	 * accesses to the career of interest of the Postulado
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * changes the career of interest of the Postulado
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * accesses to the stratum of the Postulado
	 * @return the estrato
	 */
	public String getEstrato() {
		return estrato;
	}

	/**
	 * changes the stratum of the Postulado
	 * @param estrato the estrato to set
	 */
	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	/**
	 * accesses to the foto of the Postulado
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * changes the foto of the Postulado
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * accesses to the date given by the postulado
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * changes the date given by the Postulado
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * accesses to the status homologacion status of the Postulado
	 * @return the homologacion
	 */
	public boolean isHomologacion() {
		return homologacion;
	}

	/**
	 * changes the homologacion status of the Postulado
	 * @param homologacion the homologacion to set
	 */
	public void setHomologacion(boolean homologacion) {
		this.homologacion = homologacion;
	}

	/**
	 * accesses to the age of the Postulado
	 * @return the edad
	 */
	public byte getEdad() {
		return edad;
	}

	/**
	 * changes the ages of the Postulado
	 * @param edad the edad to set
	 */
	public void setEdad(byte edad) {
		this.edad = edad;
	}
}
