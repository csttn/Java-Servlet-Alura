package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.interfaces.Action;

@WebServlet(name = "UnicaEntradaServlet", urlPatterns = { "/entrada" })
public class UnicaEntrada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> rotasProtegidas = Arrays.asList("ListaEmpresas", "EditarEmpresaForm", "EditarEmpresa",
				"NovaEmpresa", "NovaEMpresaForm", "RemoverEmpresa");

		String paramAcao = request.getParameter("acao");
		boolean actionInRouteProtected = rotasProtegidas.contains(paramAcao);

		HttpSession session = request.getSession();

		boolean userIsNotLogged = session.getAttribute("usuarioLogado") == null;


		if (userIsNotLogged && actionInRouteProtected) {

			response.sendRedirect("entrada?acao=FormLogin");
			return;

		}

		Class classe = null;

		Object obj = null;

		String className = "br.com.gerenciador.controller." + paramAcao;

		String action = "";

		try {

			classe = Class.forName(className);

			obj = classe.newInstance();
			Action ActionClass = (Action) obj;

			action = ActionClass.execute(request, response);

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

			response.sendRedirect(actionToExecute[1]);
		}

	}

}
