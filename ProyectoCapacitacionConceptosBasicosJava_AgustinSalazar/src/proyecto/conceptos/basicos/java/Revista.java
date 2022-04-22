package proyecto.conceptos.basicos.java;

public class Revista extends Producto{
	
	public Revista(int id, String fecha, String nombre, String autor, String editorial, float precio, int cantidad) {
        super(id, fecha, "Revista", nombre, autor, editorial, precio, cantidad);
    }
}
