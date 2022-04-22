package interfaces.aplicacion;

import java.util.List;

import proyecto.conceptos.basicos.java.Producto;

public interface IServicios {
	
	public void agregarProducto(List<Producto>lst);
	public void inventario(List<Producto>lst);
	public void venta(List<Producto>lst);

}
