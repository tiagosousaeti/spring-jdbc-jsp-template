package br.eti.tiagosousa.springjdbcjsp.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.eti.tiagosousa.springjdbcjsp.repository.ProductRepository;
import br.eti.tiagosousa.springjdbcjsp.repository.productrepository.ProductRepositoryImpl;

@Configuration
public class JdbcConfig {
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
	
	@Bean
    public ProductRepository getProductRepository() {
        return new ProductRepositoryImpl(getDataSource());
    }
}