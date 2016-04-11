package servletsRutas;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesJruteros.Ruta;

/**
 * Servlet implementation class MostrarRuta
 */
@WebServlet("/mostrarruta")
public class MostrarRuta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarRuta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuario") != null){
			if(request.getParameter("ruta") != null){
				@SuppressWarnings("unchecked")
				HashMap<String,Ruta> rutas = (HashMap<String,Ruta>)this.getServletContext().getAttribute("rutas"); 
				String ruta = request.getParameter("ruta");
				request.setAttribute("ruta", rutas.get(ruta));
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/rutas/mostrarruta.jsp");
				rd.forward(request,response);
			}
			else
				response.sendRedirect("inicio");
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
