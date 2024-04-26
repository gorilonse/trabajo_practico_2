package ar.edu.unju.fi.main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.model.Producto.Categoria;
import ar.edu.unju.fi.model.Producto.OrigenFabricacion;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// VARIABLES
		List <Producto> listaProductos = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int opcion=0;
		Producto producto1 = new Producto();
		Producto producto1Aux = new Producto();
		String opcionEnum=" ";
		String opcionModificar = " ";
		
		
		
		//
		do {
			System.out.println("MENU OPCIONES");
			System.out.println("1 Crear Producto");
			System.out.println("2 Mostrar Productos");
			System.out.println("3 Modificar Productos");
			System.out.println("4 Salir");
			try {
				opcion=sc.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sc = new Scanner(System.in);
				System.out.println("Ingreso un valor no aceptado");
			}
			
			switch (opcion) {
			case 1:
				System.out.println("CREAR PRODUCTO");
				System.out.println("Creando Producto");
				System.out.println("Ingrese Codigo");
				producto1.setCodigo(sc.next());
				System.out.println("Ingrese Descripcion");
				producto1.setDescripcion(sc.next());
				System.out.println("Ingrese Precio Unitario");
				producto1.setPrecioUnitario(sc.nextDouble());
				System.out.println("Ingrese Origen de fabricacion");
				System.out.println("a Argentina");
				System.out.println("b China");
				System.out.println("c Brazil");
				System.out.println("d Uruguay");
				try {
					opcionEnum=sc.next();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				switch (opcionEnum) {
				case "a":
					producto1.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
					break;
                 case "b":
					producto1.setOrigenFabricacion(OrigenFabricacion.CHINA);
					break;
                 case "c":
 					producto1.setOrigenFabricacion(OrigenFabricacion.BRASIL);
 					break;
                 case "d":
 					producto1.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
 					break;
				default:
					System.out.println("Origen de fabricacion erroneo");
					break;
				}
				
				System.out.println("Ingrese Categoria");
				System.out.println("a Telefonia");
				System.out.println("b Informatica");
				System.out.println("c ElectroHogar");
				System.out.println("d Herramientas");
				try {
					opcionEnum=sc.next();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				switch (opcionEnum) {
				case "a":
					producto1.setCategoria(Categoria.TELEFONIA);
					break;
                 case "b":
                	 producto1.setCategoria(Categoria.INFORMATICA);
					break;
                 case "c":
                	 producto1.setCategoria(Categoria.ELECTROHOGAR);
 					break;
                 case "d":
                	 producto1.setCategoria(Categoria.HERRAMIENTAS);
 					break;
				default:
					System.out.println("Categoria erroneo");
					break;
				}
				listaProductos.add(producto1);
				producto1=new Producto(); //aqui creo vuelvo a cero el objeto, asignando una nueva direccion de memoria.
				
				
				
				break; // final del punto 1
				//INICIA EL PUNTO 2
			case 2:
				System.out.println("MOSTRANDO PRODUCTOS");
				for (int i = 0; i < listaProductos.size(); i++) {
					System.out.println("Producto: "+listaProductos.get(i).toString());
				}
			
				break;
			case 3:
				System.out.println("MODIFICAR PRODUCTOS");
				System.out.println("Ingrese el codigo del producto a Modificar");
				String aux=sc.next();
				
				for (int i = 0; i < listaProductos.size(); i++) {
					if(aux.equals(listaProductos.get(i).getCodigo())) {
						
						System.out.println("MODIFICANDO PRODUCTOS");
						System.out.println("a Descripcion");
						System.out.println("b Precio Unitario");
						System.out.println("C Origen Fabricacion");
						System.out.println("d Categoria");
						try {
							opcionModificar=sc.next();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println("Ingrese las variables a, b, c, d");
						}
						switch (opcionModificar) {
						case "a":
							System.out.println("Ingrese Nueva Descripcion");
							listaProductos.get(i).setDescripcion(sc.next()); // 1ª accedo al objeto y luego le seteo el nuevo valor.
							break;
						case "b":
							System.out.println("Ingrese Nuevo Precio Unitario");
							listaProductos.get(i).setPrecioUnitario(sc.nextDouble());
							break;
						case "c":
							System.out.println("Ingrese nuevo Origen de Fabricacion");
							listaProductos.get(i).setOrigenFabricacion(cambiarOrigenFabricacion());
							break;
						case "d":
							System.out.println("Ingrese nueva Categoria");
							listaProductos.get(i).setCategoria(cambiarCategoria());
							break;
						default:
							System.out.println("Opcion no valida para modificar datos...");
							break;
						}
					}
				}
				break;
			case 4:
				System.out.println("SALIR");
				System.out.println("Saliendo....");
				break;

			default:
				System.out.println("opcion no valida");
				break;
			}
			
		} while (opcion!=4);
		
	}
	
	
	// METODOS AFUERA DEL MAIN
		
  private static  OrigenFabricacion cambiarOrigenFabricacion () {
      Producto producto2=new Producto();
	  String opcionEnum = " ";
      Scanner sc=new Scanner(System.in);
  
	System.out.println("Ingrese Origen de fabricacion");
	System.out.println("a Argentina");
	System.out.println("b China");
	System.out.println("c Brazil");
	System.out.println("d Uruguay");
	try {
		opcionEnum=sc.next();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	switch (opcionEnum) {
	case "a":
		producto2.setOrigenFabricacion(OrigenFabricacion.ARGENTINA);
		break;
   case "b":
		producto2.setOrigenFabricacion(OrigenFabricacion.CHINA);
		break;
   case "c":
		producto2.setOrigenFabricacion(OrigenFabricacion.BRASIL);
		break;
   case "d":
		producto2.setOrigenFabricacion(OrigenFabricacion.URUGUAY);
		break;
	default:
		System.out.println("Origen de fabricacion erroneo");
		break;
	}
	return producto2.getOrigenFabricacion();
  }
  
  private static Categoria cambiarCategoria() {
	  Scanner sc=new Scanner(System.in);
	  Producto producto3=new Producto();
	  String opcionEnum=" ";
	  System.out.println("Ingrese Categoria");
		System.out.println("a Telefonia");
		System.out.println("b Informatica");
		System.out.println("c ElectroHogar");
		System.out.println("d Herramientas");
		try {
			opcionEnum=sc.next();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (opcionEnum) {
		case "a":
			producto3.setCategoria(Categoria.TELEFONIA);
			break;
       case "b":
      	 producto3.setCategoria(Categoria.INFORMATICA);
			break;
       case "c":
      	 producto3.setCategoria(Categoria.ELECTROHOGAR);
			break;
       case "d":
      	 producto3.setCategoria(Categoria.HERRAMIENTAS);
			break;
		default:
			System.out.println("Categoria erroneo");
			break;
		}
	  return producto3.getCategoria();
  }
  
}
