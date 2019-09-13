package br.com.caelum.livraria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JPanel;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;
import sun.util.calendar.LocalGregorianCalendar.Date;


public class PopulaBanco {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Autor assis = geraAutor("Machado de Assis");
		em.persist(assis);
		
		Autor amado = geraAutor("Jorge Amado");
		em.persist(amado);
		
		Autor coelho = geraAutor("Paulo Coelho");
		em.persist(coelho);
		
		Livro casmurro = geraLivro("978-8-52-504464-8", "Dom Casmurro", "10/01/1899", 24.90, assis);
		Livro memorias = geraLivro("978-8-50-815415-9", "Memórias Póstumas de Bras Cubas", "01/01/1881", 19.90, assis);
		Livro quimicas = geraLivro("978-8-50-804084-1", "Químicas Borba", "01/01/1891", 16.90, assis);
		
		
		
	}
	
	private static Autor geraAutor(String nome) {
		Autor autor = new Autor();
		autor.setNome(nome);
		return autor;
		
	}
	
	private static Livro geraLivro(String isbn, String titulo, String data, double preco, Autor autor) {
		Livro livro = new Livro();
		livro.setIsbn(isbn);
		livro.setTitulo(titulo);
		livro.setDataLancamento(parseData(data));
		livro.setPreco(preco);
		livro.adicionarAutor(autor);
		return livro;
	}
	
	private static Calendar parseData(String data) {
		try {
			java.util.Date date = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			Calendar calendar = Calendar.getInstance();
			Calendar.setTime(date);
			return calendar;
		} catch(ParseException e) {
			throw new IllegalArgumentException(e);
		}
		
	}


}
