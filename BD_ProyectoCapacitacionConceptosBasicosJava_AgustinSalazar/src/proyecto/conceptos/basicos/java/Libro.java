package proyecto.conceptos.basicos.java;

public class Libro extends Producto {
	
	public Libro(int id, String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(id, fecha, "Libro", nombre, autor, editorial, precio, cantidad);
    }

}
