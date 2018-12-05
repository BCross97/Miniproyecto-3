package co.sample.filters;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
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
 * Servlet Filter implementation class AuthFilter
 */
// @WebFilter(urlPatterns = { "/AuthFilter" }, servletNames = { "Faces Servlet"
// })
public class AuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AuthFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// place your code here
		System.out.println();
		System.out.println();
		System.out.println("Attempting filter");
		// System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSession(false)
		// != null);
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		HttpServletResponse response = (HttpServletResponse) res;
		String loginURL = request.getContextPath() + "/login.xhtml";
		System.out.println(req != null);
		System.out.println(res != null); 
		System.out.println(session != null);

		boolean loggedIn = (session != null) && (session.getAttribute("user") != null);

		if (loggedIn) {
			System.out.println();
			System.out.println();
			System.out.println("Do filter");
			System.out.println();
			System.out.println();
			chain.doFilter(request, response); // So, just continue request.
			response.sendRedirect(loginURL); // So, just perform standard synchronous redirect.
		} else {
			System.out.println();
			System.out.println();
			System.out.println("Nope");
			System.out.println();
			System.out.println();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
