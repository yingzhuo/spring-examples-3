package examples.mybatis;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import spring.turbo.module.datasource.DynamicDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationBootDataSource {

    @Bean
    @Primary
    public DynamicDataSource primaryDataSource() {
        final DataSource defaultDataSource = createDataSource();
        return DynamicDataSource.builder()
                .defaultTargetDataSource(defaultDataSource)
                .addTargetDataSources("primary", defaultDataSource)
                .build();
    }

    private DataSource createDataSource() {
        final HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://10.211.55.3:3306/mybatis?useSSL=true&verifyServerCertificate=false");
        config.setUsername("root");
        config.setPassword("root");
        config.setConnectionTestQuery("SELECT 1");
        return new HikariDataSource(config);
    }

}
