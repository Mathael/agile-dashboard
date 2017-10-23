package com.dashboard.boot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author Leboc Philippe.
 */
@Configuration
@ComponentScan("com.dashboard.core")
public class SpringJdbcConfig {

    @Bean(name = "lineage")
    public DataSource lineageDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/l2jdb?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("dashboard");
        dataSource.setPassword("cg-DD8j+d;p%klX?-Zhpaw=5");
        return dataSource;
    }

    @Bean(name = "master")
    @Primary
    public DataSource websiteDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/website?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("website");
        dataSource.setPassword("vrnkUfjc4n}M#wk^f%5Xyycw~nz9fpaE6Jv#vv4m");
        return dataSource;
    }

    @Bean(name = "jdbcLineage")
    public JdbcTemplate lineageJdbcTemplate(@Qualifier("lineage") DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    @Bean(name = "jdbcMaster")
    public JdbcTemplate masterJdbcTemplate(@Qualifier("master") DataSource datasource) {
        return new JdbcTemplate(datasource);
    }
}