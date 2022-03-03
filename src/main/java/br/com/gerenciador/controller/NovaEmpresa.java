package br.com.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.interfaces.Action;
import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Empresa;

public class NovaEmpresa implements Action {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Banco banco = new Banco();

		String nomeEmpresa = request.getParameter("nome");
		String dataAbertura = request.getParameter("data");
		Date data;

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Empresa empresa = new Empresa(nomeEmpresa, data);

		banco.adicionar(empresa);

		return "redirect:entrada?acao=ListaEmpresas";
	}

}
