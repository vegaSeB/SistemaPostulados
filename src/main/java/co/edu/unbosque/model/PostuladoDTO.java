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
	 * @param nombres
	 * @param apellidos
	 * @param colegio
	 * @param carrera
	 * @param estrato
	 * @param foto
	 * @param fecha
	 * @param homologacion
	 * @param edad
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
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the colegio
	 */
	public String getColegio() {
		return colegio;
	}

	/**
	 * @param colegio the colegio to set
	 */
	public void setColegio(String colegio) {
		this.colegio = colegio;
	}

	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the estrato
	 */
	public String getEstrato() {
		return estrato;
	}

	/**
	 * @param estrato the estrato to set
	 */
	public void setEstrato(String estrato) {
		this.estrato = estrato;
	}

	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}

	/**
	 * @return the fecha
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the homologacion
	 */
	public boolean isHomologacion() {
		return homologacion;
	}

	/**
	 * @param homologacion the homologacion to set
	 */
	public void setHomologacion(boolean homologacion) {
		this.homologacion = homologacion;
	}

	/**
	 * @return the edad
	 */
	public byte getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(byte edad) {
		this.edad = edad;
	}
}
