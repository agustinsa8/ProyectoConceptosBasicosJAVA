package proyecto.conceptos.basicos.java;

public class Libro extends Producto {
	
	public Libro(String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(fecha, "Libro", nombre, autor, editorial, precio, cantidad);
    }

}
