package ar.edu.unju.fi.ejercicio5.main;

import java.util.Scanner;

import ar.edu.unju.fi.ejercicio5.database.Carrito;
import ar.edu.unju.fi.ejercicio5.database.DataBase;
import ar.edu.unju.fi.ejercicio5.enumerados.Categoria;
import ar.edu.unju.fi.ejercicio5.enumerados.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase database = new DataBase();
		cargarProductos(database);
		Carrito carrito = new Carrito();
		int opcion=0;
		int seguirComprando=0;
		int tipoPago=0;
		boolean encontrado = false;
		Scanner sc = new Scanner(System.in);
		String elegido="";
		int montoPago = 0;
		Pago pagoEfectivo = new PagoEfectivo();
		PagoTarjeta pagoTarjeta = new PagoTarjeta();
		
		do {
			System.out.println("*************** MENU *****************");
			System.out.println("Eliga una opción");
			System.out.println(
					"1 – Mostrar productos\r\n"
					+ "2 – Realizar compra\r\n"
					+ "3 – Salir");
			
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Ocurrión un error. Ingrese sólo números del 1 al 3");
				sc = new Scanner(System.in);
				opcion=0;
			}
			
			switch (opcion) {
			case 1: {
				for(Producto p:database.obtenerTodosLosObjetos()) {
					if(p.isDisponible()) {
						System.out.println(p.toString());
					}
				}
			}break;
			case 2: {
				do {
					System.out.println("Ingrese el codigo del producto a comprar");
					for(Producto p:database.obtenerTodosLosObjetos()) {
						if(p.isDisponible()) {
							System.out.println(p.toString());
						}
					}
					elegido = sc.next();
					for(Producto p:database.obtenerTodosLosObjetos()) {
						if(p.getCodigo().equals(elegido)) {
							System.out.println("Agregado al carrito: "+p.getDescripcion());
							carrito.agregarObjeto(p);
							encontrado = true;
						}
					}
					if(encontrado==false) {
						System.out.println("No se encontró el producto");
					}
					encontrado = false;
					System.out.println("******* Carrito ******");
					for(Producto c: carrito.obtenerTodosLosObjetos()) {
						System.out.println(c.toString());
					}
					System.out.println("**********************");
					
					System.out.println("Seguir comprando?");
					System.out.println("1 - Sí \n"+"2 - No");
					try {
						seguirComprando = sc.nextInt();
					} catch (Exception e) {
						//e.printStackTrace();
						System.out.println("Sólo ingrese números 1 o 2");
						seguirComprando=0;
					}
				}while(seguirComprando!=2);
				if(carrito.obtenerTodosLosObjetos().size()>0) {
					for(Producto p:carrito.obtenerTodosLosObjetos()) {
						montoPago+=p.getPrecioUnitario();
					}
					System.out.println("Monto a pagar: "+montoPago);
					System.out.println("***** PAGANDO ******");
					do {
						System.out.println("Ingrese la opción de pago");
						System.out.println(
								"1 – Pago efectivo\r\n"
								+ "2 - Pago con tarjeta");
						try {
							tipoPago = sc.nextInt();
						} catch (Exception e) {
							System.out.println("Ocurrio un error. Ingrese sólo un numero 1 o 2");
							//e.printStackTrace();
						}
						switch (tipoPago) {
						case 1: {
							System.out.println("Pago en efectivo");
							pagoEfectivo.realizarPago(montoPago);
							pagoEfectivo.imprimirRecibo();
						}break;
						case 2: {
							System.out.println("Pago con Tarjeta");
							System.out.println("Ingrese su tarjeta");
							pagoTarjeta.setNumeroTarjeta(sc.next());

							pagoTarjeta.realizarPago(montoPago);
							pagoTarjeta.imprimirRecibo();
						}break;
						default:
							System.out.println("Ingrese una de las opciones ofrecidas");
						}
					}while(tipoPago != 1 && tipoPago != 2);
				}
				carrito.reiniciarCarrito();
				montoPago = 0;
			}break;
			case 3: {
				System.out.println("FIN DEL PROGRAMA");
			}break;
			default:
				System.out.println("Eliga una opción correcta");
			}
		}while(opcion!=3);
		
	}
	
	private static void cargarProductos(DataBase database) {
		database.agregarObjeto(new Producto("01", "martillo", 400, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		database.agregarObjeto(new Producto("02", "pala", 800, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true));
		database.agregarObjeto(new Producto("03", "pico", 800, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
		database.agregarObjeto(new Producto("04", "sierra", 400, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		database.agregarObjeto(new Producto("05", "destornillador", 200, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true));
		database.agregarObjeto(new Producto("06", "lavaropas", 2000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		database.agregarObjeto(new Producto("07", "heladera", 5000, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		database.agregarObjeto(new Producto("08", "cocina", 5000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		database.agregarObjeto(new Producto("09", "microhondas", 2000, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		database.agregarObjeto(new Producto("10", "computadora", 2000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, true));
		database.agregarObjeto(new Producto("11", "monitor", 800, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false));
		database.agregarObjeto(new Producto("12", "notebook", 1000, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		database.agregarObjeto(new Producto("13", "teclado", 600, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		database.agregarObjeto(new Producto("14", "telefono", 2000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false));
		database.agregarObjeto(new Producto("15", "cargador", 500, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, true));
	}

}
