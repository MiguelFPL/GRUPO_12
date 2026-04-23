package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entidad.Producto;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario";
	
	public int agregarProducto (Producto producto)
	{
		String query = "Insert into productos(Codigo, Nombre, Precio, Stock) values ('" + producto.getCodigo() + "','" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getStock() + "','" + producto.getCategoria().getId() + "')";
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
	
	public int procedimientoAlmacenadoAltaProducto(Producto producto)
	{
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
			cst.setString(1, producto.getCodigo());
			cst.setString(2, producto.getNombre());
			cst.setDouble(3, producto.getPrecio());
			cst.setInt(4, producto.getStock());
			cst.setInt(5, producto.getCategoria().getId());
			cst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
}
