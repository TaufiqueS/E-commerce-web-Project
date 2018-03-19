package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.sql.ordering.antlr.OrderByFragmentRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.*;
import com.niit.model.*;

@Configuration 
@ComponentScan("com.niit")
@EnableTransactionManagement
public class DBConfig 
{
	@Bean(name="dataSource")
		public DataSource getH2DataSource()
		{
				DriverManagerDataSource dataSource=new DriverManagerDataSource();
				
				dataSource.setDriverClassName("org.h2.Driver");
				dataSource.setUrl("jdbc:h2:tcp://localhost/~/D_Y_C");
				dataSource.setUsername("Taufique");
				dataSource.setPassword("8425025021");
				
				System.out.println("---Data Source Created---");
				return dataSource;
		}
		
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory()
		{
			Properties hibernateProp=new Properties();
			
			// Dialect convert Lang From hybernet to db
			hibernateProp.setProperty("hibernate.hbm2ddl.auto","update");
			hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
			
			LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
			factoryBuilder.addAnnotatedClass(Category.class);
			factoryBuilder.addAnnotatedClass(Product.class);
			factoryBuilder.addAnnotatedClass(Supplier.class);
			factoryBuilder.addAnnotatedClass(UserDetails.class);
			factoryBuilder.addAnnotatedClass(CartItem.class);
			factoryBuilder.addAnnotatedClass(OrderDetails.class);
			factoryBuilder.addProperties(hibernateProp);
			
			
			
			System.out.println("Creating SessionFactory Bean");
			return factoryBuilder.buildSessionFactory();
		}
		
		@Bean(name="categoryDAO")
		public CategoryDAO getCategoryDAO()
		{
			System.out.println("----DAO Implementation----");
			return new CategoryDAOImpl();
		}
		
		
		@Bean(name="productDAO")
		public ProductDAO getProductDAO()
		{
			System.out.println("---Product DAO Implementation----");
			return new ProductDAOImpl();
		}
		
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO()
		{
			System.out.println("----Supplier DAO Implementation---");
			return new SupplierDAOImpl();
		}

		@Bean(name="userDetailsDAO")
		public UserDetailsDAO getUserDetailsDAO()
		{
			System.out.println("----UserDetails DAO Implementation----");
			return new UserDetailsDAOImpl();
		}
		
		@Bean(name="cartDAO")
		public CartDAO getCartDAO()
		{
			System.out.println("---Cart DAO Implementation----");
			return new CartDAOImpl();
		}
		
		@Bean(name="orderDetailsDAO")
		public OrderDetailsDAO getOrderDetailsDAO()
		{
			System.out.println("---Order Details DAO Implementation----");
			return new OrderDetailsDAOImpl();
		}
		
		@Bean(name="txManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
		{
			System.out.println("---Transaction Manager---");
			return new HibernateTransactionManager(sessionFactory);
			
		}
}
