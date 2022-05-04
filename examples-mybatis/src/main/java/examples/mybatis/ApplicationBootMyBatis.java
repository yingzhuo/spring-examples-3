package examples.mybatis;

import examples.mybatis.domain.User;
import examples.mybatis.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
@MapperScan("examples.mybatis.mapper")
class ApplicationBootMyBatis implements ApplicationRunner {

    private final UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) {
        User user = userMapper.findByNameAndEmail("Tom", "test3@baomidou.com");
        System.out.println(user);
    }

}
