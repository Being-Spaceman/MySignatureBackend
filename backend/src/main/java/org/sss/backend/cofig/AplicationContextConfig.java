package org.sss.backend.cofig;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.sss.backend.dao.CatagoryDAO;
import org.sss.backend.dao.SuplierDAO;
import org.sss.backend.dao.SuplierDAOImpl;
import org.sss.backend.model.Catagory;
import org.sss.backend.model.Product;
import org.sss.backend.model.Suplier;







@Configuration

@ComponentScan("org.sss.backend")

@EnableTransactionManagement



public class AplicationContextConfig {

	@Bean(name = "dataSource")
    public DataSource getDataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setDriverClassName("org.h2.Driver");
    	dataSource.setUrl("jdbc:h2:~/test");
    	dataSource.setUsername("sourabh");
    	dataSource.setPassword("");
    	
    	return dataSource;
    }
	
	

	
	private Properties getHibernateProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.hbm2ddl.auto","update");
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    	return properties;
    }
    
	
	@Autowired
	
	 @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    	sessionBuilder.addProperties(getHibernateProperties());
    	sessionBuilder.addAnnotatedClasses(Catagory.class);
    	sessionBuilder.addAnnotatedClasses(Suplier.class);
    	sessionBuilder.addAnnotatedClasses(Product.class);
    	
    	return sessionBuilder.buildSessionFactory();
    }
    
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
			SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
				sessionFactory);

		return transactionManager;
	}
    
	@Autowired
    @Bean(name = "CatagoryDAO")
	public CatagoryDAO geCatagoryDao(SessionFactory sessionFactory) {
    	return new CatagoryDAOImpl(sessionFactory);
    }

	@Autowired
    @Bean(name = "ProductDAO")
	public ProductDAO getProductDAO(SessionFactory sessionFactory) {
    	return new ProductDAOImpl(sessionFactory);
    }
	@Autowired
    @Bean(name = "SuplierDAO")
	public SuplierDAO getSuplierDao(SessionFactory sessionFactory) {
    	return new SuplierDAOImpl(sessionFactory);
    }
}
