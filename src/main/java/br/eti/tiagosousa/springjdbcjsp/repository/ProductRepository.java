package br.eti.tiagosousa.springjdbcjsp.repository;

import java.util.List;

import br.eti.tiagosousa.springjdbcjsp.model.Product;

public interface ProductRepository {
	public List<Product> buscar();
}