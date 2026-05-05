package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeguroDao;
import dao.TipoSegurosDao;
import dominio.Seguro;
import dominio.TipoSeguros;

@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
	public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		RequestDispatcher rd;

		TipoSegurosDao tipoDao = new TipoSegurosDao();
		ArrayList<TipoSeguros> tipos = tipoDao.obtenerTiposDeSeguro();
		request.setAttribute("tipos", tipos);

		if (accion != null && accion.equals("listar")) {
			SeguroDao sd = new SeguroDao();
			ArrayList<Seguro> seguros;

			if (request.getParameter("btnFiltrar") != null) {
				String idTipoStr = request.getParameter("cmbTipo");
				if (idTipoStr == null || idTipoStr.equals("0")) {
					seguros = sd.obtenerTodosLosSeguros();
				} else {
					int idTipo = Integer.parseInt(idTipoStr);
					seguros = sd.obtenerSegurosPorTipo(idTipo);
				}
			} else {
				seguros = sd.obtenerTodosLosSeguros();
			}

			request.setAttribute("seguros", seguros);
			rd = request.getRequestDispatcher("/ListarSeguros.jsp");

		} else {
			SeguroDao sd = new SeguroDao();
			int proximoId = sd.obtenerProximoId();

			if (request.getParameter("btnAceptar") != null) {
				String descripcion = request.getParameter("txtDescripcion");
				String costoContStr = request.getParameter("txtCostoContratacion");
				String costoMaxStr = request.getParameter("txtCostoMaximo");
				String idTipoStr = request.getParameter("cmbTipo");

				double costoContratacion = 0;
				double costoAsegurado = 0;
				boolean valido = true;

				try {
					costoContratacion = Double.parseDouble(costoContStr);
					costoAsegurado = Double.parseDouble(costoMaxStr);
				} catch (NumberFormatException e) {
					request.setAttribute("error", "Los costos deben ser valores numéricos.");
					valido = false;
				}

				if (valido && (costoContratacion <= 0 || costoAsegurado <= 0)) {
					request.setAttribute("error", "Los costos deben ser mayores a cero.");
					valido = false;
				}

				if (valido) {
					Seguro s = new Seguro();
					s.setIdSeguro(proximoId);
					s.setDescripcion(descripcion);
					s.setCostoContratacion(costoContratacion);
					s.setCostoAsegurado(costoAsegurado);

					TipoSeguros t = new TipoSeguros();
					t.setIdTipo(Integer.parseInt(idTipoStr));
					s.setTipoSeguros(t);

					int filas = sd.agregarSeguro(s);
					if (filas == 1) {
						request.setAttribute("mensaje", "Seguro agregado con éxito");
						proximoId = sd.obtenerProximoId();
					} else {
						request.setAttribute("error", "No se pudo agregar el seguro.");
					}
				}
			}

			request.setAttribute("proximoId", proximoId);
			rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		}

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
