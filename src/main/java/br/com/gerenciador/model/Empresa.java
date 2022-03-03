package br.com.gerenciador.model;

import java.util.Date;

public class Empresa {

	private int id;
	private String nome;
	private Date date;
	
	

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", date=" + date + "]";
	}

	public Empresa(String nome, Date date) {
		super();
		this.nome = nome;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
