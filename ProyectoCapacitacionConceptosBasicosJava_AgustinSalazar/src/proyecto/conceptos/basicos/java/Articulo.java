package proyecto.conceptos.basicos.java;

public class Articulo extends Producto {
	
	public Articulo(int id, String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(id, fecha, "Articulo", nombre, autor, editorial, precio, cantidad);
    }

}
