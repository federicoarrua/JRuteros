package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Filtro de logueo para evitar acceso irrestricto de clientes sin loguearse.
 * @author Federico Arrua
 *
 */


public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);
			
			if (reqt.getRequestURI().equals("/jruteros/index.xhtml")) {
				if (ses != null && ses.getAttribute("loggedIn")!= null){
					if(ses.getAttribute("admin") != null)
						resp.sendRedirect("/jruteros/admin/indexadmin.xhtml");
					else
						resp.sendRedirect("/jruteros/indexlogged.xhtml");
				}
				else{
					chain.doFilter(request, response);
				}
			}
			else{
				if (ses != null && ses.getAttribute("loggedIn")!= null){
					if(ses.getAttribute("admin") != null && !reqt.getRequestURI().startsWith("/jruteros/admin"))
						resp.sendRedirect("/jruteros/admin/indexadmin.xhtml");
					else
						chain.doFilter(request, response);
				}
				else{
					resp.sendRedirect(reqt.getContextPath() + "/index.xhtml");
				}
			}
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
