package com.bancolombia.homologador.persistencia.Persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private Environment env;

    @Autowired
    private DataSource datasource;

    @Autowired
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;

    @Bean
    public DataSource datasource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");
        datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        datasource.setUsername("system");
        datasource.setPassword("Isabella2010$");
        return  datasource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(datasource);
        entityManagerFactory.setPackagesToScan("com.bancolombia.homologador.persistencia.Persistencia");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        Properties additionalProperties = new Properties();
        additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        additionalProperties.put("hibernate.show_sql", "true");
       // additionalProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.dialect"));
        entityManagerFactory.setJpaProperties(additionalProperties);
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager TransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return  new PersistenceExceptionTranslationPostProcessor();
    }
}
