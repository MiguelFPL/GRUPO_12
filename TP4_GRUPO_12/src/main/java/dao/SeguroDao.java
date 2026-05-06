package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Seguro;
import dominio.TipoSeguros;

public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";

	public int agregarSeguro(Seguro seguro) {
		String query = "Insert into seguros(descripcion, idTipo, costoContratacion, costoAsegurado) VALUES ('"
				+ seguro.getDescripcion() + "','" + seguro.getTipoSeguros().getIdTipo()
				+ "','" + seguro.getCostoContratacion() + "','" + seguro.getCostoAsegurado();
		Connection cn = null;
		int filas = 0;

		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public ArrayList<Seguro> obtenerTodosLosSeguros() {
		ArrayList<Seguro> LSeguros = new ArrayList<Seguro>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "Select * from seguros";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Seguro x = new Seguro();
				x.setIdSeguro(rs.getInt("idSeguro"));
				x.setDescripcion(rs.getString("descripcion"));
				x.setCostoContratacion(rs.getDouble("costoContratacion"));
				x.setCostoAsegurado(rs.getDouble("costoAsegurado"));

				TipoSeguros t = new TipoSeguros();
				t.setIdTipo(rs.getInt("idTipo"));

				x.setTipoSeguros(t);
				LSeguros.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LSeguros;
	}
	
	public ArrayList<Seguro> obtenerSegurosPorTipo(int idTipo) {
		ArrayList<Seguro> LSeguros = new ArrayList<Seguro>();
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			String query = "SELECT s.*, t.descripcion as tipoDescripcion FROM seguros s JOIN tiposeguros t ON s.idTipo = t.idTipo WHERE s.idTipo = " + idTipo;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Seguro x = new Seguro();
				x.setIdSeguro(rs.getInt("idSeguro"));
				x.setDescripcion(rs.getString("descripcion"));
				x.setCostoContratacion(rs.getDouble("costoContratacion"));
				x.setCostoAsegurado(rs.getDouble("costoAsegurado"));

				TipoSeguros t = new TipoSeguros();
				t.setIdTipo(rs.getInt("idTipo"));
				t.setDescripcion(rs.getString("tipoDescripcion"));

				x.setTipoSeguros(t);
				LSeguros.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LSeguros;
	}
	
	
}
