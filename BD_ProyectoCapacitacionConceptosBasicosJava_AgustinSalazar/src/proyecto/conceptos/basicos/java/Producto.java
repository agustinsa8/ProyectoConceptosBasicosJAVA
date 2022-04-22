package proyecto.conceptos.basicos.java;

public class Producto {
	private int id;
	private String fecha;
    private String tipo;
    private String nombre;
    private String autor;
    private String editorial;
    private float precio;
    private int cantidad;
    
    public Producto() {
    	
    }
    
    public Producto(int id, String fecha, String tipo, String nombre, String autor, String editorial, float precio, int cantidad) {
    	super();
    	this.id = id;
    	this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public void listarProductos(){
    	System.out.println("\n-----------------------------------------------------------");
    	System.out.println("Codigo del producto: " + this.id);
        System.out.println("Tipo de producto: " + this.tipo);
        System.out.println("Nombre del producto: " + this.nombre);
        System.out.println("Autor del producto: " + this.autor);
        System.out.println("Editorial del producto: " + this.editorial);
        System.out.println("Precio del producto: " + this.precio);
        System.out.println("Cantidad disponible del producto: " + this.cantidad);
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha.toString();
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
    
}
