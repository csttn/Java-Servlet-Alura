package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.interfaces.Action;
import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Usuario;

public class Login implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		String userLogin = request.getParameter("login");
		String userSenha = request.getParameter("senha");

		Usuario userIsValid = banco.getUser(userLogin, userSenha);

		if (userIsValid != null) {
			
			HttpSession session = request.getSession();			

			session.setAttribute("usuarioLogado", userIsValid);
			return "redirect:entrada?acao=ListaEmpresas";
		} else {
			return "redirect:entrada?acao=FormLogin";
		}

	}

}
