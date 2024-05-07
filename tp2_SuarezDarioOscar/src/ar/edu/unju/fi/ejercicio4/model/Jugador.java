package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {

	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private int estatura;
	private double peso;
	// private String posición;
	private Posicion posicioncilla;
	
	//METODOS
	public int calcularEdad() {
		LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora); //Period UNA clase cuyos metodos resuelve operaciones con metodos entre objetos LocalDate
        return periodo.getYears();
	}
	
	
	
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posición="
				+ posicioncilla + "]";
	}

	
	
	//CONSTRUCTOR
	
	public Jugador(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, int estatura,
			double peso, Posicion posicioncilla) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicioncilla = posicioncilla;
	}


	//GETT Y SETTER

	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}




	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}




	public String getNacionalidad() {
		return nacionalidad;
	}




	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}




	public int getEstatura() {
		return estatura;
	}




	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}




	public double getPeso() {
		return peso;
	}




	public void setPeso(double peso) {
		this.peso = peso;
	}




	public Posicion getPosicioncilla() {
		return posicioncilla;
	}




	public void setPosicioncilla(Posicion posicioncilla) {
		this.posicioncilla = posicioncilla;
	}

	
	
	
	
	
	
	
	
	

	
	
	
	
	
}
