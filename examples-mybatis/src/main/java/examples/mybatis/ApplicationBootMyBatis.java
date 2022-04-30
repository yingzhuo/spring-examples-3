package examples.mybatis;

import examples.mybatis.domain.User;
import examples.mybatis.mybatis_mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("examples.mybatis.mybatis_mapper")
class ApplicationBootMyBatis implements ApplicationRunner {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

}
