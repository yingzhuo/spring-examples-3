package examples.mybatis.mapper;

import examples.mybatis.domain.Gender;
import examples.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public User findById(Long id);

    public List<User> findByName(@Param("keyword") String keyword, @Param("fuzzy") boolean fuzzy);

    public List<User> query(@Param("name") String name, @Param("gender") Gender gender, @Param("emailAddr") String emailAddr);

}
