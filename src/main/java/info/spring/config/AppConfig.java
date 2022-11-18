package info.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${jdbc.db.url}")
    private String url;

    @Value("${jdbc.db.username}")
    private String username;

    @Value("${jdbc.db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) {   // @Autowired на всякий
//        return new JdbcTemplate(dataSource);
//    }
//    либо
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
