package ar.edu.unju.fi.ejercicio2.main;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VARIABLES
		List<Efemeride> listaEfemerides=new ArrayList<>();
		int opcion=0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(".....MENU.....");
			System.out.println("1 – Crear efeméride");
			System.out.println("2 – Mostrar efemérides");
			System.out.println("3 – Eliminar efeméride");
			System.out.println("4 – Modificar efeméride");
			System.out.println("5 – Salir.");
			System.out.println("Pulsar algun numero entre 1 a 5");
			try {
				opcion=sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Ingreso una opcion no valida....");
				sc=new Scanner(System.in); // Siempre inicializar para que no se aga infinito y permita continuar la ejecucion.
			}
			switch (opcion) {
			case 1:
				System.out.println("CREANDO EFEMERIDE");
				break;
			case 2:
				System.out.println("MOSTRANDO EFEMERIDE");
				break;
			case 3:
				System.out.println("ELIMINANDO EFEMERIDE");
				break;
			case 4:
				System.out.println("MODIFICANDO EFEMERIDE");
				break;
			default:
				System.out.println("Saliendo.....");
				break;
			}
			
			
		} while (opcion!=5);
		
	
	}

}
