package negocioImpl;

import datos.UsuariosDao;
import datosImpl.UsuariosDaoImpl;
import entidad.Usuarios;
import negocio.UsuariosNeg;

public class UsuariosNegImpl implements UsuariosNeg{
	private UsuariosDao uDao = new UsuariosDaoImpl();
	
	public UsuariosNegImpl (UsuariosDao uDao)
	{
		this.uDao = uDao;
	}
	
	public UsuariosNegImpl ()
	{
	}
	
	@Override
	public Usuarios obtenerUsuario(String usuario, String contrasena) {
		return uDao.obtenerUsuario(usuario, contrasena);
	}
}
