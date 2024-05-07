package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.database.DataBase;
import ar.edu.unju.fi.ejercicio5.enumerados.Categoria;
import ar.edu.unju.fi.ejercicio5.enumerados.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataBase database = new DataBase();
		cargarProductos(database);
		List<Producto> productosIncrementados = new ArrayList<>();
		List<Producto> productosMayusculas = new ArrayList<>();
		
		
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" ");
			System.out.println(" ");
			System.out.println("************* MENU **************");
			System.out.println(" ");
			System.out.println(
					"1 – Mostrar productos (solo se muestran los productos con estado true).\r\n"
					+ "2 – Mostrar los productos faltantes (muestra productos con estado false)\r\n"
					+ "3 – Incrementar los precios de los productos en un 20%\r\n"
					+ "4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la\r\n"
					+ "venta.\r\n"
					+ "5 – Ordenar los productos por precio de forma descendente.\r\n"
					+ "6 - Mostrar los productos con los nombres en mayúsculas. ");
			System.out.println(" ");
			System.out.println("**********************************");
			try {
				opcion = sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Ocurrió un error. Sólo ingrese números del 1 al 6");
				sc = new Scanner(System.in);
			}
			
			switch (opcion) {
			case 1: {
				Consumer<Producto> mostrarProducto = producto -> {
		            if (producto.isDisponible()) {
		                System.out.println(producto);
		            }
		        };
		        // Filtrar y mostrar solo los productos disponibles
		        database.obtenerTodosLosObjetos().forEach(mostrarProducto);
			}break;
			case 2: {
				Predicate<Producto> filtrarNoDisponibles = p -> !p.isDisponible();
				Consumer<Producto> mostrarProducto = producto -> System.out.println(producto);

		        // Filtrar y mostrar solo los productos disponibles
		        database.obtenerTodosLosObjetos().stream().filter(filtrarNoDisponibles).forEach(mostrarProducto);
			}break;
			case 3: {
				Consumer<Producto> mostrarProducto = producto -> System.out.println(producto);
				Function<Producto, Producto> aumento  = p -> {
					Producto p2 = new Producto(p.getCodigo(), p.getDescripcion(), p.getPrecioUnitario()*1.20, p.getOrigenFabricacion(), p.getCategoria(), p.isDisponible());
					return p2;};
				productosIncrementados = database.obtenerTodosLosObjetos().stream().map(aumento).collect(Collectors.toList());
				productosIncrementados.forEach(mostrarProducto);
			}break;
			case 4: {
				Predicate<Producto> filtrarNoDisponibles = p -> p.isDisponible()&&p.getCategoria().equals(Categoria.ELECTROHOGAR);
				Consumer<Producto> mostrarProducto = producto -> System.out.println(producto);

		        // Filtrar y mostrar solo los productos disponibles
		        database.obtenerTodosLosObjetos().stream().filter(filtrarNoDisponibles).forEach(mostrarProducto);
			}break;
			case 5: {
					database.obtenerTodosLosObjetos().sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
					Consumer<Producto> mostrarProducto = producto -> System.out.println(producto);

			        // Filtrar y mostrar solo los productos disponibles
			        database.obtenerTodosLosObjetos().forEach(mostrarProducto);
			}break;
			case 6: {
				Consumer<Producto> mostrarProducto = producto -> System.out.println(producto);
				Function<Producto, Producto> aumento  = p -> {
					Producto p2 = new Producto(p.getCodigo(), p.getDescripcion().toUpperCase(), p.getPrecioUnitario(), p.getOrigenFabricacion(), p.getCategoria(), p.isDisponible());
					return p2;};
				productosMayusculas = database.obtenerTodosLosObjetos().stream().map(aumento).collect(Collectors.toList());
				productosMayusculas.forEach(mostrarProducto);
			}break;
			default:
				System.out.println("Ingresó un numero no válido. Ingrese un número del 1 al 6");
			}
			
		}while(true);
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
