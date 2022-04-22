package proyecto.conceptos.basicos.java;

public class Articulo extends Producto {
	
	public Articulo(String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(fecha, "Articulo", nombre, autor, editorial, precio, cantidad);
    }

}
