package presentacion.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Usuarios;
import negocio.UsuariosNeg;
import negocioImpl.UsuariosNegImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd;

		String usuario = request.getParameter("txtUsuario");
		String contrasena = request.getParameter("passContrasena");

		if (usuario == null || contrasena == null) {
			request.setAttribute("error", "Usuario o contraseña incorrectos.");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			return;
		}

		UsuariosNeg negocio = new UsuariosNegImpl();
		Usuarios u = negocio.obtenerUsuario(usuario.trim(), contrasena.trim());

		if (u != null) {
			request.getSession().setAttribute("usuarioLogueado", u.getUsuario());
			response.sendRedirect("AltaCliente.jsp");
		} else {
			request.setAttribute("error", "Usuario o contraseña incorrectos.");
			rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
