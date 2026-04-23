package dao;


import entidad.Categoria;

import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoCategoria {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdinventario";
	
	public int agregarCategoria (Categoria categoria) {
		
		String query = "Insert into categorias(Nombre) values ('" + categoria.getNombre() + "')";
		Connection cn = null;
		int filas = 0;
		
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
		 	Statement st = cn.createStatement();
		 	filas = st.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
}
