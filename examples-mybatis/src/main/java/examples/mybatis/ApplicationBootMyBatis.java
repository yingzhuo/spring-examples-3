package examples.mybatis;

import examples.mybatis.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.val;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
@AllArgsConstructor
@MapperScan("examples.mybatis.mapper")
class ApplicationBootMyBatis implements ApplicationRunner {

    private final UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) {
        val user = userMapper.findByIdCollection(Collections.singletonList(1L));
        System.out.println(user);
    }

}
