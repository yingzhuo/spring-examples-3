package examples.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import examples.mybatis.domain.Gender;
import examples.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {

    public User findById(Long id);

    public List<User> findByName(@Param("keyword") String keyword, @Param("fuzzy") boolean fuzzy);

    public List<User> findByIdCollection(@Param("ids") Collection<Long> ids);

    public List<User> query(@Param("name") String name, @Param("gender") Gender gender, @Param("emailAddr") String emailAddr);

}
