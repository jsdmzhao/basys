package com.aisino2.sysadmin.authorization;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aisino2.sysadmin.Constants;
import com.aisino2.sysadmin.domain.User;

/**
 * Servlet Filter implementation class LoginAuthFilter
 */
public class LoginAuthFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginAuthFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		User user = null;
		String page = req.getRequestURI();
		String refer = req.getHeader("referer");
		refer = refer == null ? "" : refer;
		if (!page.contains("/Login.jsp") && !refer.contains("/Login.jsp")) {

			try {
				user = (User) req.getSession().getAttribute(Constants.userKey);
			} catch (Exception e) {

			}
			if (user == null)
				((HttpServletResponse) response).sendRedirect("Login.jsp");
		}

		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
