package br.eti.tiagosousa.springjdbcjsp.repository.productrepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.eti.tiagosousa.springjdbcjsp.model.Product;
import br.eti.tiagosousa.springjdbcjsp.repository.ProductRepository;

public class ProductRepositoryImpl implements ProductRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ProductRepositoryImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Product> buscar() {
		List<Product> lista = jdbcTemplate.query("SELECT id, nome FROM product", new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Product(rs.getInt("id"), rs.getString("nome"));
			}
		});
		return lista;
	}
}