package datosImpl;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import datos.ClientesDao;
import entidad.Clientes;

public class ClientesDaoImpl implements ClientesDao {

	private Conexion cn;

	@Override
	public boolean agregarCliente(Clientes clientes) {

		boolean estado = true;

		cn = new Conexion();
		cn.Open();
		String query = "Insert into clientes(dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, nacionalidad, localidad, provincia, correo_electronico, telefono) values ('"
				+ clientes.getDni() + "','" + clientes.getCuil() + "','" + clientes.getNombre() + "','"
				+ clientes.getApellido() + "','" + clientes.getSexo() + "','" + clientes.getFechaNacimiento() + "','"
				+ clientes.getDireccion() + "','" + clientes.getNacionalidad() + "','" + clientes.getLocalidad() + "','"
				+ clientes.getProvincia() + "','" + clientes.getCorreo() + "','" + clientes.getTelefono() + "')";

		try {
			estado = cn.execute(query);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return estado;
	}

	public List<Clientes> obtenerClientes() {
		cn = new Conexion();
		cn.Open();

		List<Clientes> LClientes = new ArrayList<Clientes>();
		try {
			ResultSet rs = cn.query("Select * from clientes");
			while (rs.next()) {
				Clientes c = new Clientes();

				c.setId(rs.getInt("id_cliente"));
				c.setDni(rs.getInt("dni"));
				c.setCuil(rs.getInt("cuil"));
				c.setNombre(rs.getString("nombre"));
				c.setApellido(rs.getString("apellido"));
				c.setSexo(rs.getString("sexo"));
				c.setFechaNacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
				c.setDireccion(rs.getString("direccion"));
				c.setNacionalidad(rs.getString("nacionalidad"));
				c.setLocalidad(rs.getString("localidad"));
				c.setProvincia(rs.getString("provincia"));
				c.setCorreo(rs.getString("correo_electronico"));
				c.setTelefono(rs.getInt("telefono"));

				LClientes.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cn.close();
		}
		return LClientes;
	}
}
