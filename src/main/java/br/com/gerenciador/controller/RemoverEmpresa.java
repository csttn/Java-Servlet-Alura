package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;
import br.com.gerenciador.model.Banco;

public class RemoverEmpresa implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String idEmpresa = request.getParameter("id");

		Integer id = Integer.valueOf(idEmpresa);

		Banco banco = new Banco();

		banco.remover(id);
		
		return "redirect:entrada?acao=ListaEmpresas";

	}

}
