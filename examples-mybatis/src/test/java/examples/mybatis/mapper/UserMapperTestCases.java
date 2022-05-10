package examples.mybatis.mapper;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTestCases {

    @Autowired
    private UserMapper userMapper;

    @Test
    @DisplayName("测试findById")
    public void test_findById() {
        val user = userMapper.findById(1L);
        Assertions.assertNotNull(user);
    }

}
