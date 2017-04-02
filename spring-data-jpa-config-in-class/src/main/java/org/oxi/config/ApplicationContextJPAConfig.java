package org.oxi.config;



import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @EnableJpaRepositories Foi necessário especificar o package de repository do JPARepository 
 * o spring data funcionar
 * @author ocortez
 *
 */
@Configuration
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = {"org.oxi"})
@EnableTransactionManagement
public class ApplicationContextJPAConfig {
	

//	private String driver = "com.mysql.jdbc.Driver";

//	private String url = "jdbc:mysql://localhost:3306/oxi_project_spring_jpa_rest_all";//	
	
//	private String passwd = "root";

//	private String username = "root";

//	private String hibernateDialect = "org.hibernate.dialect.MySQLDialect";

//	private String hibernateHbm2ddl = "update";
	
	
	@Value("${db.driver}")
	private String driver;
	
	@Value("${db.url}")
	private String url;
	
	@Value("${db.password}")
	private String passwd;
	
	@Value("${db.username}")
	private String username;
	
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddl;
	
	/**
	 * Necessário para o Spring reconhecer os place holder
	 * @PropertySource("application.properties")
	 * 
	 * Criar o método abaixo para o reconhecimento da anotação @PropertySource
	 * PropertySourcesPlaceholderConfigurer 
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigIn(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	 @Bean
     public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "org.oxi" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
     }

     @Bean     
     public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(passwd);
        return dataSource;
     }

     @Bean
     public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
     }

     @Bean
     public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
     }

     Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddl);
        properties.setProperty("hibernate.dialect", hibernateDialect);
        return properties;
     }

}
