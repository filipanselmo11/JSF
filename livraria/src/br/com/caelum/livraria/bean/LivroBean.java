package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Livro> getLivros(){
		return new DAO<Livro>(Livro.class).listaTodos();
	}
	
	public List<Autor> getAutores(){
		return new DAO<Autor>(Autor.class).listaTodos();
	}
	public List<Autor> getAutoresDoLivro(){
		return this.livro.getAutores();
		
	}
	public void gravarAutor(){
		Autor autor = new DAO<Autor>(Autor.class).buscarPorId(this.autorId);
		this.livro.adicionarAutor(autor);
		
	}
	public void gravar() {
		System.out.println("Gravando livro" + this.livro.getTitulo());
		
		if(livro.getAutores().isEmpty()) {
			//throw new RuntimeException("Livro deve ter pelo menos um Autor");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor"));
			return ;
		}
		
		new DAO<Livro>(Livro.class).adiciona(this.livro);
	}
	
	public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException{
		String valor = value.toString();
		if(!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
	}
	
	

}
