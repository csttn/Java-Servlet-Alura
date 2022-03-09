package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoServlet implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long timeInitial = System.currentTimeMillis();

		String acao = request.getParameter("acao");

		System.out.println("Monitoramneto Filter");

//		Executa ação das requisições subsequentes para depois mostrar o valor do tempo
		chain.doFilter(request, response);

		long timeFinal = System.currentTimeMillis();

		System.out.println("Tempo de execução ListaEmpresa: " + (timeFinal - timeInitial) + " ms - " + acao);

	}

}
