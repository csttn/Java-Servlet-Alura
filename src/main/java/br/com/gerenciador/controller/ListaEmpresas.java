package br.com.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;
import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;

public class ListaEmpresas implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		List<Empresa> listaDeEmpresas = banco.getEmpresas();

		// adicionando propriedades ao request para o jsp consumir
		request.setAttribute("listaDeEmpresas", listaDeEmpresas);

		return "forward:listaEmpresas.jsp";

	}

}
