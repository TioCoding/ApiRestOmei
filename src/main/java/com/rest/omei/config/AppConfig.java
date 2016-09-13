package com.rest.omei.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages = "com.rest.omei")
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		try {
			JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
			jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/OmeiDS");
			jndiObjectFactoryBean.setResourceRef(true);
			jndiObjectFactoryBean.setProxyInterface(DataSource.class);
			jndiObjectFactoryBean.afterPropertiesSet();
			return (DataSource) jndiObjectFactoryBean.getObject();
		} catch (IllegalArgumentException | NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
}
