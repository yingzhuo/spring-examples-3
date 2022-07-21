package examples.jpa;

import examples.jpa.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class ApplicationBoot implements ApplicationRunner {

    private final UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        userDao.findAll();
    }

}
