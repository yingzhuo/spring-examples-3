package examples.jpa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import examples.jpa.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    public User haha(@Param("aaa") String aaa);

}
