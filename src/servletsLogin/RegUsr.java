package servletsLogin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clasesJruteros.Usuario;
import enumJruteros.TiposUsuario;

/**
 * Servlet implementation class RegUsr
 */
@WebServlet("/regusr")
public class RegUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegUsr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("inicio");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		@SuppressWarnings("unchecked")
		HashMap<String,Usuario> usuarios= (HashMap<String,Usuario>) this.getServletContext().getAttribute("usuarios");
		String newUser = request.getParameter("username");
		if(!usuarios.containsKey(newUser)){
			Usuario u = new Usuario();
			u.setUsername(newUser);
			u.setApellido(request.getParameter("apellido"));
			u.setDni(Integer.parseInt(request.getParameter("dni")));
			u.setNombres(request.getParameter("nombre"));
			u.setDomicilio(request.getParameter("domicilio"));
			u.setTipo(TiposUsuario.REGULAR);
			u.setPassword("123456");
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("usuario", u);
			usuarios.put(u.getUsername(), u);
			response.sendRedirect("index.jsp");
		}
		else{
			RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/index.jsp");
			request.setAttribute("errorReg", true);
			rd.forward(request,response);
		}
	}

}
