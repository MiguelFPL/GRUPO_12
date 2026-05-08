package datos;

import java.util.List;

import entidad.Clientes;

public interface ClientesDao {

	public boolean agregarCliente(Clientes clientes);

	public List<Clientes> obtenerClientes();

}