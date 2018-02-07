package br.eti.tiagosousa.springjdbcjsp.model;

public class Product {
	
	private Integer id;
	private String nome;
	
	public Product() {
	}
	
	public Product(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public boolean isNovo(){
		return id == null;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nome=" + nome + "]";
	}
}