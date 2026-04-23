package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidad.Categoria;
import entidad.Producto;

public class DaoProducto {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdInventario";
	
	public int agregarProducto (Producto producto)
	{
		String query = "Insert into productos(Codigo, Nombre, Precio, Stock, IdCategoria) values ('" + producto.getCodigo() + "','" + producto.getNombre() + "','" + producto.getPrecio() + "','" + producto.getStock() + "','" + producto.getCategoria().getId() + "')";
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
		try
		{
			cn = DriverManager.getConnection(host+dbName, user, pass);
			CallableStatement cst = cn.prepareCall("CALL sp_AgregarProducto(?,?,?,?,?)");
			cst.setString(1, producto.getCodigo());
			cst.setString(2, producto.getNombre());
			cst.setDouble(3, producto.getPrecio());
			cst.setInt(4, producto.getStock());
			cst.setInt(5, producto.getCategoria().getId());
			cst.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public int bajaProducto(Producto producto) 
	{
		
		String query = "UPDATE Productos SET estado =0 where codigo=?";
		int filas=0;

		Connection cn = null;
		
		try  
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement ps = cn.prepareStatement(query);
			ps.setString(1, producto.getCodigo());
			filas = ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}		
		return filas;
	}
	
	public ArrayList<Producto> obtenerTodosLosProductos()
	{
		ArrayList<Producto> LProductos = new ArrayList<Producto>();
		Connection cn = null;
		try  
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			String query = "Select * from productos where estado =1 ";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next())
			{
				Producto x = new Producto();
				x.setCodigo (rs.getString("Codigo"));
				x.setNombre (rs.getString("Nombre"));
				x.setPrecio (rs.getDouble("Precio"));
				x.setStock (rs.getInt("Stock"));
				
				Categoria c = new Categoria();
			    c.setId(rs.getInt("IdCategoria"));
			    
			    x.setCategoria(c);
				LProductos.add(x);
			}
		}		 
		catch (Exception e) 
		{
		 e.printStackTrace();
		}
		return LProductos;
	}
	
	public int modificarProducto(Producto producto)
	{
		String query = "UPDATE productos SET Nombre = ?, Precio = ?, Stock = ?, IdCategoria = ? WHERE Codigo = ?";
		Connection cn = null;
		int filas = 0;
		
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			PreparedStatement ps = cn.prepareStatement(query);
			
			ps.setString(1, producto.getNombre());
	        ps.setDouble(2, producto.getPrecio());
	        ps.setInt(3, producto.getStock());
	        ps.setInt(4, producto.getCategoria().getId());
	        ps.setString(5, producto.getCodigo());
	        filas = ps.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
}
