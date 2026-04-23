package dao;

import entidad.Categoria;

import java.sql.Statement;
import java.util.ArrayList;
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
	
	public int bajaCategoria(Categoria categoria) 
    {

        String query = "UPDATE categorias SET estado =0 where IdCategoria=?";
        int filas=0;

        Connection cn = null;


        try
        {
            cn=DriverManager.getConnection(host+dbName,user,pass);
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1, categoria.getId());
            filas = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return filas;
    }

	public ArrayList<Categoria> obtenerTodasLasCategorias()
    {
		ArrayList<Categoria> LCategorias = new ArrayList<Categoria>();
        Connection cn = null;
        try
        {
            cn=DriverManager.getConnection(host+dbName,user,pass);
            String query = "Select * from categorias where estado =1 ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                Categoria x = new Categoria();
                x.setNombre (rs.getString("Nombre"));
                x.setId(rs.getInt("IdCategoria"));
                LCategorias.add(x);
            }
         }
         catch (Exception e)  
         {
         e.printStackTrace();
         }
        return LCategorias;
    }

	public int modificarCategoria(Categoria categoria) 
    {
        String query = "UPDATE categorias SET Nombre =? where IdCategoria=?";
        int filas=0;

        Connection cn = null;

        try
        {
            cn=DriverManager.getConnection(host+dbName,user,pass);
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getId());
            filas = ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return filas;
    }
}
