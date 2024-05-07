package ar.edu.unju.fi.ejercicio4.main;

import java.io.ObjectInputStream.GetField;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;
import ar.edu.unju.fi.ejercicio4.persistencia.PersisntenciaJugadores;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//VARIABLES
		int opcion=0, opcion2=0;
		Scanner sc =new Scanner(System.in);
		String nombre,apellido,nacionalidad;
		int dia,mes,anio,estatura;
		double peso;
		Posicion posicion=Posicion.ARQUERO;
		PersisntenciaJugadores jugadores = new PersisntenciaJugadores();
		
		
		
		do {
			System.out.println("*********** MENU *************");
			System.out.println("Seleccione una opcíon");
			System.out.println("1 - Alta Jugador");
			System.out.println("2 – Mostrar todos los jugadores ordenados por apellido.");
			System.out.println("3 – Modificar la posicion de un Jugador (Ingrese nombre y apellido)");
			System.out.println("4 – Eliminar un jugador");
			System.out.println("5 – Salir.");
			try {
				opcion=sc.nextInt();
			} catch (Exception e) {
				System.out.println(" ------------ Debe ingresar un numero de 1 al 5 --------------");
				sc = new Scanner(System.in);
			}
			
			switch (opcion) {
			case 1: {
				try {
					System.out.println("Ingrese los siguientes datos");
					System.out.println("Nombre");
					nombre=sc.next();
					System.out.println("Apellido");
					apellido=sc.next();
					System.out.println("Fecha de nacimiento");
					System.out.println("dia");
					dia=sc.nextInt();
					System.out.println("mes");
					mes=sc.nextInt();
					System.out.println("año");
					anio=sc.nextInt();
					System.out.println("Nacionalidad");
					nacionalidad=sc.next();
					System.out.println("Estatura en cm");
					estatura=sc.nextInt();
					System.out.println("Peso en kg");
					peso = sc.nextDouble();
					System.out.println("Posicion  (1-delantero, 2-medio, 3-defensa, 4-arquero)");
					opcion2=sc.nextInt();
					do {
						switch (opcion2) {
						case 1: {
							System.out.println("opcion 1 \n");
							posicion=Posicion.DELANTERO;
						}break;
						case 2: {
							System.out.println("opcion 2 \n");
							posicion=Posicion.MEDIO;
						}break;
						case 3: {
							System.out.println("opcion 3 \n");
							posicion=Posicion.DEFENSA;
						}break;
						case 4: {
							System.out.println("opcion 4 \n");
							posicion=Posicion.ARQUERO;
						}break;
						default:
							System.out.println("opcion no valida");
						}
					} while (opcion2!=1 && opcion2!=2 && opcion2!=3 && opcion2!=4);
					jugadores.getListaJugadores().add(new Jugador(nombre, apellido,LocalDate.of(anio, mes, dia), nacionalidad, estatura, peso, posicion));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("ingresos no validos, ingresar valores correctos");
				}
			}break;
			case 2: {
				System.out.println("Mostrando todos los jugadores...");
				jugadores.getListaJugadores().sort(Comparator.comparing(Jugador::getApellido));
			//	jugadores.sort(Comparator.comparing(Jugador::getApellido)); estructura del TP-1 punto 17
				System.out.println("tamaño: "+jugadores.getListaJugadores().size());
				for (int i = 0; i < jugadores.getListaJugadores().size(); i++) {
					jugadores.getListaJugadores().get(i).toString();
					System.out.println(jugadores.getListaJugadores().get(i).toString());
				}
			}break;
			case 3: {
				System.out.println("Modificando posicion del Jugador");
				System.out.println("Identificar Jugador a modificar por el Apellido: ");
				String auxApellido=sc.next();
				System.out.println("Ahora Ingrese el Nombre");
				String auxNombreString=sc.next();
				int auxPosicion=0;
				for (int i = 0; i < jugadores.getListaJugadores().size(); i++) {
					if (jugadores.getListaJugadores().get(i).getApellido().equals(auxApellido) && jugadores.getListaJugadores().get(i).getNombre().equals(auxNombreString)) {
						System.out.println("Elegir la nueva posicion: ");
						System.out.println("1-Delantero");
						System.out.println("2-Medio");
						System.out.println("3-Defensa");
						System.out.println("4-Arquero");
						try {
							auxPosicion=sc.nextInt();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("solo se puede elegir entre 1 y 4");
						}
						switch (auxPosicion) {
						case 1: jugadores.getListaJugadores().get(i).setPosicioncilla(posicion.DELANTERO);//reasigno el valor DELANTERO esto para cuando es CLASE ENUM. 
							break;
						case 2: jugadores.getListaJugadores().get(i).setPosicioncilla(posicion.MEDIO);
							break;
						case 3: jugadores.getListaJugadores().get(i).setPosicioncilla(posicion.DEFENSA);
							break;
						case 4: jugadores.getListaJugadores().get(i).setPosicioncilla(posicion.ARQUERO);
							break;
						default: System.out.println("No se reasigno ninguna Posicion nueva");
							break;
						}
						
					} else {
						System.out.println("No se encontro al Jugador con ese Apellido y Nombre...");
					}
				}
				
			}break;
			
			case 4: {
				Iterator<Jugador> iterator = jugadores.getListaJugadores().iterator();  //ITERATOR
				try {
					System.out.println("Ingrese el nombre del jugador a eliminar");
					nombre=sc.next();
					System.out.println("Ingrese el apellido del jugador a eliminar");
					apellido=sc.next();
					while(iterator.hasNext()) {
						Jugador j = iterator.next();
						if(j.getNombre().equals(nombre)&&j.getApellido().equals(apellido)) {
							iterator.remove();
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}break;
			case 5:{
			System.out.println("Saliendo......");	
			}break;
			default:
				System.out.println("Opcion no valida, solo es valido entre 1 y 5");
			}}while(opcion!=5);
}}