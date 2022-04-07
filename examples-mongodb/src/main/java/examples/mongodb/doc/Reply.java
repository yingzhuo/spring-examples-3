package examples.mongodb.doc;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.util.Date;

/**
 * 社交回复
 *
 * @author 应卓
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "reply")
public class Reply implements Serializable {

    /**
     * 文档ID
     */
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    /**
     * 回复日期
     */
    @Field(name = "replydate")
    private Date replyDate;

    /**
     * 文章ID
     */
    @Field(name = "articleid")
    private Long articleId;

    /**
     * 用户ID
     */
    @Field(name = "userid")
    private Long userId;

    /**
     * 用户名称
     */
    @Field(name = "username")
    private String userName;

    /**
     * 性别
     */
    @Field(name = "sex")
    private Gender gender;

    /**
     * 评论文本
     */
    @Field(name = "text")
    private String text;

    /**
     * 父文档ID
     */
    @Field(name = "parentid")
    private Long parentDocId;

    /**
     * 点赞数
     */
    @Field(name = "likenum")
    private Long likeNumber = 0L;

    /**
     * 评论状态
     */
    @Field(name = "status")
    private ReplyStatus status = ReplyStatus.NORMAL;

}
