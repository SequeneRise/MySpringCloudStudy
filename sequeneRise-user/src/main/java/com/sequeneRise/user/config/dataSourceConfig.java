package com.sequeneRise.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 数据库配置
 */
@Configuration
public class dataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(environment.getProperty("mysql.driverClassName"));
        dataSource.setUrl(environment.getProperty("mysql.url"));
        dataSource.setUsername(environment.getProperty("mysql.username"));
        dataSource.setPassword(environment.getProperty("mysql.password"));
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:sequeneRise-mybatis-configuration.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}
