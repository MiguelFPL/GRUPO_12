package datosImpl;

import java.sql.ResultSet;

import datos.UsuariosDao;
import entidad.Usuarios;

public class UsuariosDaoImpl implements UsuariosDao {

	private Conexion cn;

	public UsuariosDaoImpl() {

	}

	@Override
	public Usuarios obtenerUsuario(String usuario, String contrasena) {
		cn = new Conexion();
		cn.Open();
		Usuarios u = null;

		try {
			ResultSet rs = cn.query("SELECT * FROM usuarios WHERE usuario = '" 
                    + usuario + "' AND contrasena = '" + contrasena + "'");
			if (rs.next()) {

				u = new Usuarios();

				u.setId(rs.getInt("id_usuario"));
				u.setUsuario(rs.getString("usuario"));
				u.setPassword(rs.getString("contrasena"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return u;
	}
}
