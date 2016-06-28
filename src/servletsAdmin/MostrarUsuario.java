package servletsAdmin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clasesJruteros.Usuario;

/**
 * Servlet implementation class MostrarUsuario
 */
@WebServlet("/mostrarusuario")
public class MostrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin") != null){
			if(request.getParameter("usuario") != null){
				@SuppressWarnings("unchecked")
				HashMap<String,Usuario> usuarios = (HashMap<String,Usuario>)this.getServletContext().getAttribute("usuarios"); 
				String usuario = request.getParameter("usuario");
				request.setAttribute("usuario", usuarios.get(usuario));
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/admin/mostrarUsuario.jsp");
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
