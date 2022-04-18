package interfaces.aplicacion;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import proyecto.conceptos.basicos.java.Articulo;
import proyecto.conceptos.basicos.java.Libro;
import proyecto.conceptos.basicos.java.Producto;
import proyecto.conceptos.basicos.java.Revista;

public class ServiciosImpl implements IServicios {
	
	public void agregarProducto(List<Producto>lst) {
        System.out.println("\nEscoja el tipo de producto que desea agregar: \n" + "\n1.Libro -- " + "2.Revista -- " + "3.Articulo\n" + "\nDigite una opcion: ");
        Date fecha = new Date();
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
                Libro lib = new Libro(fecha.toString(), nombre, autor, editorial, precio, 0);
                lst.add(lib);
            }
            else if (tipoProducto==2){                
                Revista rev = new Revista(fecha.toString(), nombre, autor, editorial, precio, 0);
                lst.add(rev);
                }
            else if(tipoProducto==3){
                Articulo art= new Articulo(fecha.toString(), nombre, autor, editorial, precio, 0);
                lst.add(art);
                    }
            System.out.println("***Producto agregado correctamente***");
                }
        else{
            System.out.println("¡¡El dato ingresado no es una opcion valida, vuelva a intentarlo!!");
        }
	}
	
	public void inventario(List<Producto>lst) {
		System.out.println("Ingrese el codigo del producto al que quiere agregar inventario: ");
        Scanner in1 = new Scanner(System.in);
        try {
        	int codigo= in1.nextInt();
        	if(lst.get(codigo)!=null){
                System.out.println("Digite la cantidad:");
                Scanner in2 = new Scanner(System.in);
                int cantidad= in2.nextInt();
                lst.get(codigo).setCantidad(cantidad+lst.get(codigo).getCantidad());
                System.out.println("Cantidad modificada correctamente");
            }
            else{
                System.out.println("¡¡El codigo ingresado es incorrecto!!");
            }
        }
        catch (Exception e) {
        	System.out.println("**ERROR**" + e.getMessage());
		}
        
		
	}
	
	public void venta(List<Producto>lst) {
		System.out.println("Ingrese el codigo del producto a vender: ");
        Scanner in1 = new Scanner(System.in);
        try {
        int codigo= in1.nextInt();
        if(lst.get(codigo)!=null){
            System.out.println("\nNombre del producto: " + lst.get(codigo).getNombre());
            System.out.println("Precio del producto: $" + lst.get(codigo).getPrecio());
            System.out.println("Cantidad disponible del producto: " + lst.get(codigo).getCantidad());
            if(lst.get(codigo).getCantidad()!=0){
                System.out.println("\nDigite la cantidad a vender: ");
                Scanner in2= new Scanner(System.in);
                int cantComprar= in2.nextInt();
                if(cantComprar <= lst.get(codigo).getCantidad()){
                	lst.get(codigo).setCantidad(lst.get(codigo).getCantidad()-cantComprar);
                    System.out.println("\nValor total a pagar: $"+((lst.get(codigo).getPrecio())*cantComprar));
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
