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

/**
 * Servlet implementation class LoginUsr
 */
@WebServlet("/loginusr")
public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsr() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getParameter("user");
		String password = (String) request.getParameter("password");
		
		@SuppressWarnings("unchecked")
		HashMap<String,Usuario> mapaUsuarios = (HashMap<String,Usuario>) this.getServletContext().getAttribute("usuarios");
		RequestDispatcher rd;
		Usuario u = mapaUsuarios.get(user);
		if(u != null){
			if(u.getPassword().equals(password)){
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("usuario", u);
				rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loggedIndex.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("errorLogin", true);
				rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
				rd.forward(request, response);
			}	
		}
		else{
			request.setAttribute("errorLogin", true);
			rd = this.getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}	
	}

}
