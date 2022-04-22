package proyecto.conceptos.basicos.java;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import conexion.persistencia.ProductoDao;
import interfaces.aplicacion.IServicios;
import interfaces.aplicacion.ServiciosImpl;


public class Principal {
	
	static List<Producto> lst = new ArrayList<Producto>();
	static IServicios servicio = new ServiciosImpl();
	static ProductoDao produc = new ProductoDao();
    
	public static void menu(){
        System.out.println("\n***Bienvenido a su programa***\n" + "\nEscoja la accion que quiere realizar: \n");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto");
        System.out.println("3. Ingresar inventario");
        System.out.println("4. Venta de producto");
        System.out.println("5. Salir\n");
        System.out.println("Seleccione una opcion: ");
    }
	
	public static void listar(List<Producto>lst) {
		for(int c=0; c<lst.size(); c++) {
            lst.get(c).listarProductos();
        }
	}
	
	public static void principal() {
		int opcion = 0;
        while(opcion!=5){
            menu();
            Scanner in = new Scanner(System.in);
            opcion= in.nextInt();
            switch(opcion){
                case 1: System.out.println("\n**Lista de Productos**\n");
                		listar(produc.listarProductos());
                    break;
                    
                case 2: System.out.println("\n**Agregar un Producto**\n");
                		servicio.agregarProducto();
                	break;
                
                case 3: System.out.println("\n**Agregar un producto al inventario**\n");
                		servicio.inventario();
                	break;
                	
                case 4: System.out.println("\n**Venta de un Producto**\n");
                		servicio.venta();
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
