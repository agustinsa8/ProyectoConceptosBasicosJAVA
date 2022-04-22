package conexion.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	
	private Connection con;
	
	public Conexion() {
		this.getConexion();	
	}

	public Connection getConexion() {
		if(this.con == null) {
			//jdbc:mariadb://localhost:3306/DBName?user=root&password=myPassword
			String url = "jdbc:mariadb://localhost:3306/libreria";
			String usuario = "asalazara";
			String contra = "12345";
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				con = DriverManager.getConnection(url, usuario, contra);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				this.con = null;
			}			
		}
		return this.con;
	}
	
	
	public void cerrarConexion() {	
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public Statement getStatement() {
		Statement st = null;
		try {
			st = this.con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
	
	public void cerrarStatement(Statement statement) {	
		try {
			if(statement != null)
				statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement getPreparedStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = this.con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;		
		
	}
	
	public void cerrarPrepared(PreparedStatement ps) {
		try {
			if(ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void cerrarConexion(Statement st) {
		try {
			if(st != null)
				st.close();
			if(con != null) 
				con.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}