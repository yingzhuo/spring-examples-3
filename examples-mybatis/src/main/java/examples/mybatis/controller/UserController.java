package examples.mybatis.controller;

import examples.mybatis.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.datasource.DataSourceSwitch;
import spring.turbo.webmvc.api.Json;

@Slf4j
@AllArgsConstructor
@RestController
public class UserController {

    private final UserMapper userMapper;

    @GetMapping("/t")
    @DataSourceSwitch("default")
    public Json test() {
        userMapper.findById(1L);
        return Json.newInstance();
    }

}
