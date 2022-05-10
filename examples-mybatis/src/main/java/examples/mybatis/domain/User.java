package examples.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

@Data
//@TableName("t_user")
public class User implements Serializable {

    //    @TableId
    private Long id;

    //    @TableField("name")
    private String name;

    //    @TableField("gender")
    private Gender gender;

    //    @TableField("email_addr")
    private String emailAddr;

}
