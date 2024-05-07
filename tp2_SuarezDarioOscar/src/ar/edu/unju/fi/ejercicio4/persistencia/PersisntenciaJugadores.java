package ar.edu.unju.fi.ejercicio4.persistencia;


import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class PersisntenciaJugadores {

	
    List<Jugador> listaJugadores = new ArrayList<Jugador>();

	
	
	
	
	public PersisntenciaJugadores() {
		super();
		listaJugadores = new ArrayList<Jugador>();
	}





	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}
	
	

	
	
	
	
}
