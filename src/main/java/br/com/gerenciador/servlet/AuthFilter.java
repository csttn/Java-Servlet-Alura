package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

//@WebFilter(urlPatterns = "/entrada")
public class AuthFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		List<String> rotasProtegidas = Arrays.asList("ListaEmpresas", "EditarEmpresaForm", "EditarEmpresa",
				"NovaEmpresa", "NovaEMpresaForm", "RemoverEmpresa");
		
		System.out.println("AuthFilter");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		String paramAcao = request.getParameter("acao");
		boolean actionInRouteProtected = rotasProtegidas.contains(paramAcao);

		HttpSession session = httpRequest.getSession();

		boolean userIsNotLogged = session.getAttribute("usuarioLogado") == null;

		if (userIsNotLogged && actionInRouteProtected) {
			httpResponse.sendRedirect("entrada?acao=FormLogin");
			return;
		}

		chain.doFilter(request, response);

	}

}
