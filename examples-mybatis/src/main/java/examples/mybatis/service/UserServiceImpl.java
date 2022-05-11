package examples.mybatis.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import examples.mybatis.domain.User;
import examples.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
