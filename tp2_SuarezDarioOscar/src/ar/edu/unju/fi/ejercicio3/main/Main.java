package ar.edu.unju.fi.ejercicio3.main;


import java.util.Iterator;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Provincia provincias[]=new Provincia[6];
		
		
		provincias[0]=Provincia.JUJUY;
		provincias[1]=Provincia.SALTA;
		provincias[2]=Provincia.TUCUMAN;
		provincias[3]=Provincia.CATAMARCA;
		provincias[4]=Provincia.LA_RIOJA;
		provincias[5]=Provincia.SANTIAGO_DEL_ESTERO;
		
		for (int i = 0; i < provincias.length; i++) {
			System.out.println("*****************");
			System.out.println("Provincia: "+provincias[i].toString());
			System.out.println("Cantidad Poblacion: "+provincias[i].getCANTIDAD_POBLACION());
			System.out.println("Superficie: "+provincias[i].getSUPERFICIE());
			System.out.println("Densidad Poblacional: "+provincias[i].CalcularDensidadPoblacionDeLaProv());
			System.out.println("*****************");
		}
		
		
		
	}

	/**
	 * Uso enum.
Dentro del paquete creado para este ejercicio cree los siguientes paquetes: main, constantes
En el paquete constantes cree un enumerado con el nombre Provincia, los valores constantes para
el mismo son:
JUJUY, SALTA, TUCUMAN, CATAMARCA, LA RIOJA, SANTIAGO DEL ESTERO
Dentro del enum Provincia, agregue:
Los atributos: cantidad población y superficie.
El constructor privado que permita inicializar los atributos cantidad población y superficie de cada
provincia.
Agregue los métodos accesores (getters y setters).
Agregue un método que permita calcular la densidad poblacional de la provincia, el método retorna
el resultado de dividir: cantidad habitantes / superficie.
Dentro del paquete main, cree la clase Main con el correspondiente método main().
Guarde los valores de enum Provincia en un array.
Muestre cada enum con su respectiva información, incluyendo la densidad poblacional.
	 */
	
	
}
