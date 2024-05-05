package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {

	//VALORES CONSTANTES
	JUJUY(4,2), SALTA(6,2), TUCUMAN(8,2), CATAMARCA(10,2), LA_RIOJA(12,2), SANTIAGO_DEL_ESTERO(14,2);
	
	
	//Atributos que trabajan sobre la Constantes del Enumerado.
	private final int CANTIDAD_POBLACION;
	private final int SUPERFICIE;
	
	
	
	
	//METODOS
	public double CalcularDensidadPoblacionDeLaProv() {
		double aux=0;
		aux=CANTIDAD_POBLACION/SUPERFICIE;
		return aux;
	}
	
	
	
	
	//CONSTRUCOTES // de forma implicita hace referencia a las Constantes del Enumerado.
	
	private Provincia(int cANTIDAD_POBLACION, int sUPERFICIE) {
		CANTIDAD_POBLACION = cANTIDAD_POBLACION;
		SUPERFICIE = sUPERFICIE;
	}
	//SETTER Y GETTER
	public int getCANTIDAD_POBLACION() {
		return CANTIDAD_POBLACION;
	}
	public int getSUPERFICIE() {
		return SUPERFICIE;
	}
	
	
	
	
	
}
