package br.com.caelum.livraria.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Entity
public class Livro implements Serializable {
	
	/*private static final long serialVersionUID - 1L;*/
	
	private static final String TemporalType = null;

	@Id @GeneratedValue
	private Integer id;
	
	private String titulo;
	private String isbn;
	private double preco;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataLancamento = Calendar.getInstance();
	
	@ManyToMany
	private List<Autor> autores = new ArrayList<Autor>();
	
	public List<Autor>getAutores(){
		return autores;
	}
	
	public void adicionarAutor(Autor autor) {
		this.autores.add(autor);
	}

	public Livro() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	} 
	
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
	
	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public void geraLivro(String isbn, String titulo, Calendar dataLancamento, double preco, Autor autor) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.dataLancamento = dataLancamento;
		this.preco = preco;
		this.autores = (List<Autor>) autor;
		}
	
	

}