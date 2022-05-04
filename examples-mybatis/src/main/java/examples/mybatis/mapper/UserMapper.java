package examples.mybatis.mapper;

import examples.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public User findById(Long id);

    public User findByNameAndEmail(@Param("name") String name, @Param("email") String email);

}
