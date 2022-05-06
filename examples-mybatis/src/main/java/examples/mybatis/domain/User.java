package examples.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private Gender gender;
    private String emailAddr;

}
