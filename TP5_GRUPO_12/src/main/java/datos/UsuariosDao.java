package datos;

import entidad.Usuarios;

public interface UsuariosDao {

	public Usuarios obtenerUsuario(String usuario, String contrasena);

}
