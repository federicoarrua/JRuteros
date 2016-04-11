package servletsRutas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesJruteros.Ruta;
import clasesJruteros.Usuario;

/**
 * Servlet implementation class MisRutas
 */
@WebServlet("/misrutas")
public class MisRutas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisRutas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") != null){
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			@SuppressWarnings("unchecked")
			HashMap<String,Ruta> rutas = (HashMap<String,Ruta>) this.getServletContext().getAttribute("rutas");
			ArrayList<Ruta> arreglo = new ArrayList<Ruta>();
			for(String r : rutas.keySet()){
				if(rutas.get(r).getDueño().getUsername() == usuario.getUsername()){
					arreglo.add(rutas.get(r));
				}
			}
			request.setAttribute("misrutas", arreglo);
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/rutas/misrutas.jsp");
			rd.forward(request, response);
		}
		else{
			response.sendRedirect("inicio");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
