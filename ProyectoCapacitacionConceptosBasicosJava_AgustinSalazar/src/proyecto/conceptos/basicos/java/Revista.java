package proyecto.conceptos.basicos.java;

public class Revista extends Producto{
	
	public Revista(String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(fecha, "Revista", nombre, autor, editorial, precio, cantidad);
    }
}
