package br.eti.tiagosousa.springjdbcjsp.repository.productrepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
	
	@Override
	public Product buscarPorId(Integer id) {
	    String sql = "SELECT id, nome FROM product WHERE id=" + id;
	    return jdbcTemplate.query(sql, new ResultSetExtractor<Product>() {	 
	        @Override
	        public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
	            if (rs.next()) {
	            	return new Product(rs.getInt("id"), rs.getString("nome"));
	            }
	            return null;
	        }
	    });
	}
	
	@Override
	public void excluir(Integer id) {
	    String sql = "DELETE FROM product WHERE id=?";
	    jdbcTemplate.update(sql, id);
	}
	
	@Override
	public void salvar(Product produto) {
	    if (produto.isNovo()) {
	    	String sql = "INSERT INTO product (nome) VALUES (?)";
	        jdbcTemplate.update(sql, produto.getNome());	        
	    } else {
	    	String sql = "UPDATE product SET nome=? WHERE id=?";
	        jdbcTemplate.update(sql, produto.getNome(), produto.getId());
	    }
	}
}