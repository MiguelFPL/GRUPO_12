package negocio;

import java.util.ArrayList;

import entidad.Clientes;

public interface ClientesNeg {
	public boolean agregarCliente(Clientes clientes);
	public ArrayList<Clientes> obtenerClientes();
}
