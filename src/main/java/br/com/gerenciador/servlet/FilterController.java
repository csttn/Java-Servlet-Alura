package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;

public class FilterController implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Filter Controller");

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletpResponse = (HttpServletResponse) response;

		String paramAcao = request.getParameter("acao");

		Class classe = null;

		Object obj = null;

		String className = "br.com.gerenciador.controller." + paramAcao;

		String action = "";

		try {

			classe = Class.forName(className);

			obj = classe.newInstance();
			Action ActionClass = (Action) obj;

			action = ActionClass.execute(httpServletRequest, httpServletpResponse);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			System.out.println("Classe não encontrada");
			throw new ServletException(e);
		}

		String[] actionToExecute = action.split(":");

		if (actionToExecute[0].equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + actionToExecute[1]);
			rd.forward(request, response);
		}

		if (actionToExecute[0].equals("redirect")) {

			httpServletpResponse.sendRedirect(actionToExecute[1]);
		}

	}

}
