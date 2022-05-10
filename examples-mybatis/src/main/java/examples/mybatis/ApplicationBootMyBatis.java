package examples.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("examples.mybatis.mapper")
class ApplicationBootMyBatis {
}
