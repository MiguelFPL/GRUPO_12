package presentacion.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Clientes;
import negocio.ClientesNeg;
import negocioImpl.ClientesNegImpl;


@WebServlet("/ServletAltaCliente")
public class ServletAltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletAltaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
        RequestDispatcher rd;
 
        if (accion != null && accion.equals("agregar")) {
 
            if (request.getParameter("btnGuardar") == null) {
                rd = request.getRequestDispatcher("/AltaCliente.jsp");
                rd.forward(request, response);
                return;
            }
 
            String dniStr       = request.getParameter("dni");
            String cuilStr      = request.getParameter("cuil");
            String nombre       = request.getParameter("txtNombre");
            String apellido     = request.getParameter("txtApellido");
            String sexo         = request.getParameter("cmbSexo");
            String nacionalidad = request.getParameter("txtNacionalidad");
            String fechaStr     = request.getParameter("fecha");
            String direccion    = request.getParameter("txtDireccion");
            String localidad    = request.getParameter("txtLocalidad");
            String provincia    = request.getParameter("txtProvincia");
            String correo       = request.getParameter("email");
            String telStr       = request.getParameter("tel");
 
            boolean valido = true;
 
            int dni = 0, cuil = 0, telefono = 0;
 
             dni = Integer.parseInt(dniStr);                
             cuil = Integer.parseInt(cuilStr);
             telefono = Integer.parseInt(telStr);
                 
             String soloLetras = "^[A-Za-záéíóúÁÉÍÓÚñÑ\\s]+$";

             if (!nombre.matches(soloLetras)) {
                  request.setAttribute("error", "El nombre solo puede contener letras.");
                  valido = false;
             }
             if (valido && !apellido.matches(soloLetras)) {
                 request.setAttribute("error", "El apellido solo puede contener letras.");
                 valido = false;
             }
             if (valido && nacionalidad != null && !nacionalidad.isEmpty() && !nacionalidad.matches(soloLetras)) {
                 request.setAttribute("error", "La nacionalidad solo puede contener letras.");
                 valido = false;
             }
             
             if (valido && localidad != null && !localidad.isEmpty() && !nacionalidad.matches(soloLetras)) {
                 request.setAttribute("error", "La localidad solo puede contener letras.");
                 valido = false;
             }
             
             if (valido && provincia != null && !provincia.isEmpty() && !nacionalidad.matches(soloLetras)) {
                 request.setAttribute("error", "La provincia solo puede contener letras.");
                 valido = false;
             }
             
            LocalDate fechaNacimiento = null;
            if (valido) {
                try {
                    fechaNacimiento = LocalDate.parse(fechaStr);
                    if (fechaNacimiento.isAfter(LocalDate.now())) {
                        request.setAttribute("error", "La fecha de nacimiento no puede ser futura.");
                        valido = false;
                    }
                } catch (Exception e) {
                    request.setAttribute("error", "La fecha de nacimiento no es válida.");
                    valido = false;
                }
            } 
            
            if (valido) {
                Clientes cliente = new Clientes();
                cliente.setDni(dni);
                cliente.setCuil(cuil);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setSexo(sexo);
                cliente.setFechaNacimiento(fechaNacimiento);
                cliente.setDireccion(direccion);
                cliente.setNacionalidad(nacionalidad);
                cliente.setLocalidad(localidad);
                cliente.setProvincia(provincia);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
 
                
                ClientesNeg clientesNeg = new ClientesNegImpl();
                boolean resultado = clientesNeg.agregarCliente(cliente);
 
                if (resultado) {
                    request.setAttribute("mensaje", "Cliente agregado con éxito.");
                } else {
                    request.setAttribute("error", "No se pudo agregar el cliente. Intente nuevamente.");
                }
            }
 
            rd = request.getRequestDispatcher("/AltaCliente.jsp");
            rd.forward(request, response);
 
        	} else {
            
            rd = request.getRequestDispatcher("/AltaCliente.jsp");
            rd.forward(request, response);
        }
        }
        

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
