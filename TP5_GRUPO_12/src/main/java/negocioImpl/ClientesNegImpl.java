package negocioImpl;

import java.util.ArrayList;

import datos.ClientesDao;
import datosImpl.ClientesDaoImpl;
import entidad.Clientes;
import negocio.ClientesNeg;

public class ClientesNegImpl implements ClientesNeg {

	private ClientesDao cDao = new ClientesDaoImpl();

	public ClientesNegImpl(ClientesDao cDao) {
		this.cDao = cDao;
	}

	public ClientesNegImpl() {
	}

	@Override
	public boolean agregarCliente(Clientes clientes) {
		return cDao.agregarCliente(clientes);
	}

	@Override
	public ArrayList<Clientes> obtenerClientes() {
		return (ArrayList<Clientes>) cDao.obtenerClientes();
	}
}
