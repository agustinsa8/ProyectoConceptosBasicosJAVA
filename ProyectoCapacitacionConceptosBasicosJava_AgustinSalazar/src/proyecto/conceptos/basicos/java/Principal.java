package proyecto.conceptos.basicos.java;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.aplicacion.IServicios;
import interfaces.aplicacion.ServiciosImpl;


public class Principal {
	
	static List<Producto> lst = new ArrayList<Producto>();
	static Date fechaActual = new Date();
    static Libro lib1 = new Libro(fechaActual.toString(), "Cien anos de soledad","Gabriel Garcia Marquez", "Editorial", 87000, 7);
    static Libro lib2 = new Libro(fechaActual.toString(), "El coronel no tiene quien le escriba", "Gabriel Garcia Marquez", "Editorial", 36000, 3);
    static Libro lib3= new Libro(fechaActual.toString(), "La odisea", "Omero", "Editorial", 125000, 5);
    static Revista rev1= new Revista(fechaActual.toString(), "National Geographi", "Desconocido", "Editorial", 26000, 3);
    static Revista rev2 = new Revista(fechaActual.toString(), "Motor", "Desconocido", "Editorial", 15000, 5);
    static Articulo art1= new Articulo(fechaActual.toString(), "Paper sobre combustion interna", "Desconocido", "Editorial", 65000, 2);
    static Articulo art2 = new Articulo(fechaActual.toString(), "Paper sobre programacion orientada a objetos", "Desconocido", "Editorial", 48000, 3);
	static IServicios servicio = new ServiciosImpl();
    
	public static void menu(){
        System.out.println("\n***Bienvenido a su programa***\n" + "\nEscoja la accion que quiere realizar: \n");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto");
        System.out.println("3. Ingresar inventario");
        System.out.println("4. Venta de producto");
        System.out.println("5. Salir\n");
        System.out.println("Seleccione una opcion: ");
    }
	
	public static void listar() {
		for(int c=0; c<lst.size(); c++) {
            System.out.println("Codigo: "+c);
            lst.get(c).listarProductos();
        }
	}
	
	public static void principal() {
		lst.add(lib1); lst.add(lib2); lst.add(lib3); lst.add(rev1); lst.add(rev2); lst.add(art1); lst.add(art2);
		int opcion = 0;
        while(opcion!=5){
            menu();
            Scanner in = new Scanner(System.in);
            opcion= in.nextInt();
            switch(opcion){
                case 1: System.out.println("\n**Lista de Productos**\n");
                		listar();
                    break;
                    
                case 2: System.out.println("\n**Agregar un Producto**\n");
                		servicio.agregarProducto(lst);
                	break;
                
                case 3: System.out.println("\n**Agregar un producto al inventario**\n");
                		servicio.inventario(lst);
                	break;
                	
                case 4: System.out.println("\n**Venta de un Producto**\n");
                		servicio.venta(lst);
                	break;
                	
                case 5: System.out.println("\n**Su programa ha finalizado**\n");
                		System.exit(0);
                	break;
          }
        }
	}
	
	public static void main(String[] args) {
		principal();	
	}
		
}
