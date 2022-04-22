package conexion.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import proyecto.conceptos.basicos.java.Articulo;
import proyecto.conceptos.basicos.java.Libro;
import proyecto.conceptos.basicos.java.Producto;
import proyecto.conceptos.basicos.java.Revista;

public class ProductoDao {
	
	private Conexion conexion;
	
	public ProductoDao() {
		this.conexion = new Conexion();
	}
	
	public List<Producto> listarProductos() {
			String sql = "SELECT id, fecha, tipo, nombre, autor, editorial, precio, cantidad from libreria.producto";
			List<Producto> lst = new ArrayList<Producto>();
			Producto prod = null; 
			Statement st = this.conexion.getStatement();
			try {
				ResultSet rs = st.executeQuery(sql);				
				while(rs.next()) {
					prod = new Producto();
					prod.setId(rs.getInt("id"));
					prod.setFecha(rs.getString("fecha"));
					prod.setTipo(rs.getString("tipo"));
					prod.setNombre(rs.getString("nombre"));
					prod.setAutor(rs.getString("autor"));
					prod.setEditorial(rs.getString("editorial"));
					prod.setPrecio(rs.getFloat("precio"));
					prod.setCantidad(rs.getInt("cantidad"));
					lst.add(prod);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				this.conexion.cerrarStatement(st);
			}
			return lst;
		}
	
	
	public void insertarLibro(Libro lib) {
		String sql = "INSERT INTO libreria.producto (id, fecha, tipo, nombre, autor, editorial, precio, cantidad)" 
					+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.conexion.getPreparedStatement(sql);
		try {
			ps.setInt(1, lib.getId());
			ps.setString(2, lib.getFecha());
			ps.setString(3, lib.getTipo());
			ps.setString(4, lib.getNombre());
			ps.setString(5, lib.getAutor());
			ps.setString(6, lib.getEditorial());
			ps.setFloat(7, lib.getPrecio());
			ps.setFloat(8, lib.getCantidad());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.conexion.cerrarPrepared(ps);
		}
	}
	
	public void insertarArticulo(Articulo art) {
		String sql = "INSERT INTO libreria.producto (id, fecha, tipo, nombre, autor, editorial, precio, cantidad)" 
					+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.conexion.getPreparedStatement(sql);
		try {
			ps.setInt(1, art.getId());
			ps.setString(2, art.getFecha());
			ps.setString(3, art.getTipo());
			ps.setString(4, art.getNombre());
			ps.setString(5, art.getAutor());
			ps.setString(6, art.getEditorial());
			ps.setFloat(7, art.getPrecio());
			ps.setFloat(8, art.getCantidad());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.conexion.cerrarPrepared(ps);
		}
	}
	
	public void insertarRevista(Revista rev) {
		String sql = "INSERT INTO libreria.producto (id, fecha, tipo, nombre, autor, editorial, precio, cantidad)" 
					+ "VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement ps = this.conexion.getPreparedStatement(sql);
		try {
			ps.setInt(1, rev.getId());
			ps.setString(2, rev.getFecha());
			ps.setString(3, rev.getTipo());
			ps.setString(4, rev.getNombre());
			ps.setString(5, rev.getAutor());
			ps.setString(6, rev.getEditorial());
			ps.setFloat(7, rev.getPrecio());
			ps.setFloat(8, rev.getCantidad());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.conexion.cerrarPrepared(ps);
		}
	}
	
	public Producto buscarProducto(int codigo) {
			String sql = "SELECT id, fecha, tipo, nombre, autor, editorial, precio, cantidad FROM libreria.producto WHERE id = '" + codigo + "'";
			Producto prod = null;
			Statement st = this.conexion.getStatement();
			try {
				ResultSet rs = st.executeQuery(sql);				
				while(rs.next()) {
					prod = new Producto();
					prod.setId(rs.getInt("id"));
					prod.setFecha(rs.getString("fecha"));
					prod.setTipo(rs.getString("tipo"));
					prod.setNombre(rs.getString("nombre"));
					prod.setAutor(rs.getString("autor"));
					prod.setEditorial(rs.getString("editorial"));
					prod.setPrecio(rs.getFloat("precio"));
					prod.setCantidad(rs.getInt("cantidad"));		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				this.conexion.cerrarStatement(st);
			}	
			return prod;
		}
	
	public boolean actualizarCantidadProducto(Producto prod) {
			Conexion conexion = new Conexion();
			boolean exito = false;
			String sql = "UPDATE libreria.producto " + 
						 "SET fecha = ?, " + 
						 "  tipo = ?, " + 
						 "  nombre = ?, " + 
						 "  autor = ?, " + 
						 "  editorial = ?, " + 
						 "  precio = ?, " + 
						 "  cantidad = ? " + 
					     "WHERE id = ? ";
			PreparedStatement ps = conexion.getPreparedStatement(sql);
			try {						
				ps.setString(1, prod.getFecha());
				ps.setString(2, prod.getTipo());
				ps.setString(3, prod.getNombre());
				ps.setString(4, prod.getAutor());
				ps.setString(5, prod.getEditorial());
				ps.setFloat(6, prod.getPrecio());
				ps.setInt(7, prod.getCantidad());
				ps.setInt(8, prod.getId());
				ps.execute();			
				exito = true;
			} catch (SQLException e) {
				e.printStackTrace();
				exito = false;
			}finally {
				conexion.cerrarPrepared(ps);
				conexion.cerrarConexion();
			}		
			return exito;
		}
	
	

}
