package examples.jpa;

import examples.jpa.dao.UserDao;
import examples.jpa.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    private final UserDao userDao;
    private final UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userDao.findAll();
        System.out.println("---");
        userMapper.selectList(null);
    }

}
