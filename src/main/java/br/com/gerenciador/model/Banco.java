package br.com.gerenciador.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<Empresa>();
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public static Integer chaveSequence = 1;

	static {

		Empresa empresa1 = new Empresa("empresa1", new Date());
		empresa1.setId(Banco.chaveSequence++);
		Empresa empresa2 = new Empresa("empresa2", new Date());
		empresa2.setId(Banco.chaveSequence++);

		empresas.add(empresa1);
		empresas.add(empresa2);

		Usuario user1 = new Usuario();
		user1.setLogin("cleyton");
		user1.setSenha("123");

		Usuario user2 = new Usuario();
		user2.setLogin("cleyton2");
		user2.setSenha("123");

		usuarios.add(user1);
		usuarios.add(user2);

	}

	public void adicionarUsuario(Usuario usuario) {

		Banco.usuarios.add(usuario);

	}

	public void removerUsuario(Usuario usuario) {

		Iterator<Usuario> it = Banco.usuarios.iterator();

//		percoreendo elementos no iterador
		while (it.hasNext()) {
			Usuario usuarioItarator = it.next();

//			validando se o elemnto é o que estou procurando
			if (usuarioItarator.ehIgual(usuario.getLogin(), usuario.getSenha())) {

//			removendo posição do iterador	
				it.remove();
			}
		}

	}

	public Usuario getUser(String userLogin, String userSenha) {

		Iterator<Usuario> it = Banco.usuarios.iterator();

		while (it.hasNext()) {
			Usuario usuario = it.next();

			if (usuario.ehIgual(userLogin, userSenha)) {

				return usuario;

			}
		}
		return null;

	}

	public void adicionar(Empresa empresa) {

		empresa.setId(Banco.chaveSequence++);

		Banco.empresas.add(empresa);

	}

	public void editar(Empresa empresa) {

		Iterator<Empresa> it = Banco.empresas.iterator();

//		percoreendo elementos no iterador
		while (it.hasNext()) {
			Empresa empresaIterator = it.next();

//			buscando elemento na lista
			if (empresaIterator.getId() == empresa.getId()) {
				empresaIterator.setNome(empresa.getNome());
				empresaIterator.setDate(empresa.getDate());

			}
		}

	}

	public void remover(Integer id) {

		Iterator<Empresa> it = Banco.empresas.iterator();

//		percoreendo elementos no iterador
		while (it.hasNext()) {
			Empresa empresa = it.next();

//			validando se o elemnto é o que estou procurando
			if (empresa.getId() == id) {

//			removendo posição do iterador	
				it.remove();
			}
		}

	}

	public Empresa getEmpresa(Integer id) {

		Iterator<Empresa> it = Banco.empresas.iterator();

//		percoreendo elementos no iterador
		while (it.hasNext()) {
			Empresa empresa = it.next();

//			validando se o elemnto é o que estou procurando
			if (empresa.getId() == id) {

				return empresa;

			}
		}
		return null;
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

}
