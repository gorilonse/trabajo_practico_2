package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		// Conversion de felino domestico a felino salvaje
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),x.getEdad(), x.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);
		
		//Conversion de felino salvaje a felino domestico

		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner", (byte)20, 186f);
		System.out.println(Converter.isNotNull(gato2));
		Converter<FelinoSalvaje,FelinoDomestico> converter2 = x -> new FelinoDomestico(x.getNombre(),x.getEdad(), x.getPeso());
		
		FelinoDomestico felino2 = converter2.convert(gato2);
		converter2.mostrarObjeto(felino2);
		
	}


}
