package br.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;
import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;

public class EditarEmpresaForm implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Banco banco = new Banco();

		String idEmpresa = request.getParameter("id");

		Integer id = Integer.valueOf(idEmpresa);

		Empresa empresa = banco.getEmpresa(id);

		request.setAttribute("empresa", empresa);

		return "forward:formAlterarEmpresa.jsp";

	}

}
