package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.TipoSeguros;

public class TipoSegurosDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";

	public ArrayList<TipoSeguros> obtenerTiposDeSeguro() {
		ArrayList<TipoSeguros> LTipoSeguros = new ArrayList<TipoSeguros>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "Select * from tiposeguros";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				TipoSeguros x = new TipoSeguros();
				x.setDescripcion(rs.getString("descripcion"));
				x.setIdTipo(rs.getInt("idTipo"));
				LTipoSeguros.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LTipoSeguros;
	}

}
