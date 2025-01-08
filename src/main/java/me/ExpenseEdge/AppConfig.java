package me.ExpenseEdge;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration //설정 정보가 들어있는 class임을 알려줌
@PropertySource("classpath:config/application.properties")  // properties 파일 로드
public class AppConfig {
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("EXPENSEEDGE"); //edge
		dataSource.setPassword("EXPENSEEDGE"); //edge
		
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		
		return sessionFactoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
