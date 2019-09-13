package br.com.caelum.livraria.dao;

import br.com.caelum.livraria.modelo.Autor;

public interface EntityManager {

	Object getTransaction();

	void persist(Autor assis);

}
