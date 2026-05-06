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

/**
 * Servlet implementation class servletSeguro
 */
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas = 0;
			
		if (request.getParameter("btnAceptar") != null) {
			Seguro s = new Seguro();
			s.setDescripcion(request.getParameter("txtDescripcion"));
			s.setCostoContratacion(Double.parseDouble(request.getParameter("txtCostoContratacion")));
			s.setCostoAsegurado(Double.parseDouble(request.getParameter("txtCostoMaximo")));
			
			SeguroDao sd = new SeguroDao();
			filas = sd.agregarSeguro(s);
			
			request.setAttribute("cantFilas", filas);
		}

		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TipoSegurosDao td = new TipoSegurosDao(); 
		ArrayList<TipoSeguros> listaTipos = td.obtenerTiposDeSeguro();
		request.setAttribute("tipos", listaTipos);
		RequestDispatcher rd = request.getRequestDispatcher("/AgregarSeguro.jsp");
		rd.forward(request, response);
	
	}

}
