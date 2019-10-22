package com.wego.web.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.wego.web.config.RootConfig;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@ContextConfiguration(classes = {RootConfig.class})

@MapperScan(basePackages = {"com.wego.web.mapper"})
@Log4j
public class DataSourceTexts {
	@Setter(onMethod_ = {@Autowired})
    private DataSource dataSource;
    @Test
    public void testConnection() {
       try(Connection con =  dataSource.getConnection()){
           System.out.println("성공");
           log.info(con);
       }catch(Exception e) {
           System.out.println("실패");
           fail(e.getMessage());
       }
    }
	

}
