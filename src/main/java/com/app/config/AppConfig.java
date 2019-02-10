package com.app.config;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.app.model.Employee;

@Configuration
@ComponentScan(basePackages="com.app")
@PropertySource("app.properties")
@EnableTransactionManagement
public class AppConfig {
	@Autowired
	private Environment env;
	//data
	@Bean
	public BasicDataSource dsObj() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dc"));
		ds.setUrl(env.getProperty("url"));
		ds.setUsername(env.getProperty("un"));
		ds.setPassword(env.getProperty("pwd"));
		ds.setInitialSize(5);
		ds.setMaxTotal(5); //active
		ds.setMaxIdle(5);
		ds.setMinIdle(5);
		return ds;
	}
	@Bean
	public LocalSessionFactoryBean sfObj() {
		LocalSessionFactoryBean sf=new LocalSessionFactoryBean();
		sf.setDataSource(dsObj()); //ref tag
		sf.setHibernateProperties(props());
		sf.setAnnotatedClasses(Employee.class);
		return sf;
	}
	private Properties props() {
		Properties p=new Properties();
		p.put("hibernate.dialect", 
				env.getProperty("dialect"));
		p.put("hibernate.show_sql", 
				env.getProperty("showsql"));
		p.put("hibernate.format_sql", 
				env.getProperty("fmtsql"));
		p.put("hibernate.hbm2ddl.auto", 
				env.getProperty("ddlauto"));
		return p;
	}
	//3. HibernateTemplate
	@Bean
	public HibernateTemplate htObj() {
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(sfObj().getObject());
		return ht;
	}
	//4. Hibernate Tx Manager
	@Bean
	public HibernateTransactionManager htmObj() {
		HibernateTransactionManager htm=new
				HibernateTransactionManager();
		htm.setSessionFactory(sfObj().getObject());
		return htm;
	}
}

