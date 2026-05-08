package negocio;

import entidad.Usuarios;

public interface UsuariosNeg {
	public Usuarios obtenerUsuario(String usuario, String contrasena);
}
