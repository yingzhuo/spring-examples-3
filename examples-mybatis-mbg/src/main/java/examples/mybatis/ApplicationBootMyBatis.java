package examples.mybatis;

import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@MapperScan("examples.mybatis.mapper")
class ApplicationBootMyBatis {
}
