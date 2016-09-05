package net.atos.start.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by lukasz on 03.08.16.
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("net.atos.start.student")
@PropertySource("classpath:application.properties")
public class DatabaseConfig {

    private static final String DATABASE_DRIVER = "db.driver";
    private static final String DATABASE_PASSWORD = "db.password";
    private static final String DATABASE_URL = "db.url";
    private static final String DATABASE_USERNAME = "db.username";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBM = "hibernate.hbm2ddl.auto";
    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packagesToScan";

    @Resource
    private Environment envirnoment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(envirnoment.getRequiredProperty(DATABASE_DRIVER));
        dataSource.setUrl(envirnoment.getRequiredProperty(DATABASE_URL));
        dataSource.setUsername(envirnoment.getRequiredProperty(DATABASE_USERNAME));
        dataSource.setPassword(envirnoment.getRequiredProperty(DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(envirnoment.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibProperties());
        return sessionFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, envirnoment.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, envirnoment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_HBM, envirnoment.getRequiredProperty(HIBERNATE_HBM));
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}
