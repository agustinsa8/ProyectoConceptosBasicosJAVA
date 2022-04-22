package interfaces.aplicacion;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import conexion.persistencia.ProductoDao;
import proyecto.conceptos.basicos.java.Articulo;
import proyecto.conceptos.basicos.java.Libro;
import proyecto.conceptos.basicos.java.Producto;
import proyecto.conceptos.basicos.java.Revista;

public class ServiciosImpl implements IServicios {
	
	public void agregarProducto(){
		ProductoDao producto = new ProductoDao();
        System.out.println("\nEscoja el tipo de producto que desea agregar: \n" + "\n1.Libro -- " + "2.Revista -- " + "3.Articulo\n" + "\nDigite una opcion: ");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = dtf.format(LocalDateTime.now());
        Scanner opcion = new Scanner(System.in);
        int tipoProducto = opcion.nextInt();
        if((tipoProducto>=1) && (tipoProducto<=3)){
            System.out.println("\nDigite el nombre del producto:");
            Scanner in1 = new Scanner(System.in);
            String nombre = in1.nextLine();
            System.out.println("Digite el  autor del producto:");
            Scanner in2 = new Scanner(System.in);
            String autor = in2.nextLine();
            System.out.println("Digite la editorial del producto:");
            Scanner in3 = new Scanner(System.in);
            String editorial = in3.nextLine();
            System.out.println("Digite el precio del producto:");
            Scanner in4= new Scanner(System.in);
            float precio = in4.nextFloat();
            if(tipoProducto==1){
            	Libro lib = new Libro(0, fecha, nombre, autor, editorial, precio, 0);
                producto.insertarLibro(lib);
            }
            else if (tipoProducto==2){                
                Revista rev = new Revista(0, fecha, nombre, autor, editorial, precio, 0);
                producto.insertarRevista(rev);
                }
            else if(tipoProducto==3){
                Articulo art= new Articulo(0, fecha, nombre, autor, editorial, precio, 0);
                producto.insertarArticulo(art);
                    }
            System.out.println("\n-------------------------------------------------------");
            System.out.println("*Producto agregado correctamente*");
            System.out.println("--------------------------------------------------------\n");
                }
        else{
            System.out.println("¡¡El dato ingresado no es una opcion valida, vuelva a intentarlo!!");
        }
	}
	
	public void inventario() {
		ProductoDao producto = new ProductoDao();
		Producto prod = new Producto();
		System.out.println("Ingrese el codigo del producto al que quiere agregar inventario: ");
        Scanner in1 = new Scanner(System.in);
        try {
        	int codigo= in1.nextInt();
        	prod = producto.buscarProducto(codigo);
        	if(prod!=null){
                System.out.println("Digite la cantidad:");
                Scanner in2 = new Scanner(System.in);
                int cantidad= in2.nextInt();
                prod.setCantidad(prod.getCantidad()+cantidad);
                producto.actualizarCantidadProducto(prod);
                System.out.println("\n-------------------------------------------------------");
                System.out.println("*Cantidad modificada correctamente*");
                System.out.println("--------------------------------------------------------\n");
            }
            else{
                System.out.println("¡¡El codigo ingresado es incorrecto!!");
            }
        }
        catch (Exception e) {
        	System.out.println("**ERROR**" + e.getMessage());
		}	
	}
	
	public void venta() {
		ProductoDao producto = new ProductoDao();
		Producto prod = new Producto();
		System.out.println("Ingrese el codigo del producto a vender: ");
        Scanner in1 = new Scanner(System.in);
        try {
        int codigo= in1.nextInt();
        prod = producto.buscarProducto(codigo);
        if(prod!=null){
        	prod.listarProductos();
            if(prod.getCantidad()!=0){
                System.out.println("\nDigite la cantidad a vender: ");
                Scanner in2= new Scanner(System.in);
                int cantComprar= in2.nextInt();
                if(cantComprar <= prod.getCantidad()){
                	prod.setCantidad(prod.getCantidad()-cantComprar);
                	producto.actualizarCantidadProducto(prod);
                    System.out.println("\nValor total a pagar: $"+((prod.getPrecio())*cantComprar));
                    System.out.println("\n-------------------------------------------------------");
                    System.out.println("*Compra realizada con exito*");
                    System.out.println("-------------------------------------------------------\n");
                }
                else{
                    System.out.println("La cantidad excede la disponibilidad del producto");
                }
            }
            else{
                System.out.println("Este producto no esta disponible");
            }
        }
        else{
            System.out.println("¡¡El codigo ingresado es incorrecto!!");
        	}
        }
        catch (Exception e) {
        	System.out.println("**ERROR**" + e.getMessage());
        }
	}
        
}
