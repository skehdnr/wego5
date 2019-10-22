package com.wego.web.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configurable
@ComponentScan(basePackages= {"com.wego.web"})
public class RootConfig {
 @Bean
 public DataSource dataSource() {
  HikariConfig hikariConfig = new HikariConfig();
  hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
  hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/wego?serverTimezone=UTC");
  hikariConfig.setUsername("wego");
  hikariConfig.setPassword("wego");
  
  HikariDataSource dataSource = new HikariDataSource(hikariConfig);
  return dataSource;
 }
 @Bean
 public SqlSessionFactory sqlSessionFactory() throws Exception {
   SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
   factoryBean.setDataSource(dataSource());
   return factoryBean.getObject();
 }
 
 @Bean
 public SqlSessionTemplate sqlSession() throws Exception {
   return new SqlSessionTemplate(sqlSessionFactory());
 }
}