package br.com.gerenciador.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;

public class NovaEmpresaForm implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "forward:formNovaEmpresa.jsp";

	}

}
