package ar.edu.unju.fi.ejercicio5.database;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Carrito {

	private List<Producto> objetos;

    public Carrito() {
        this.objetos = new ArrayList<>();
    }

    public void agregarObjeto(Producto objeto) {
        this.objetos.add(objeto);
    }

    public void eliminarObjeto(Producto objeto) {
        this.objetos.remove(objeto);
    }

    public List<Producto> obtenerTodosLosObjetos() {
        return this.objetos;
    }
    
    public void reiniciarCarrito() {
    	 this.objetos = new ArrayList<>();
    }
}
