package examples.mongodb.doc;

import examples.mongodb.doc.geo.Point;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * 餐厅
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "restaurant")
public class Restaurant implements Serializable {

    /**
     * 文档ID
     */
    @MongoId(targetType = FieldType.OBJECT_ID)
    private String id;

    /**
     * 餐厅名称
     */
    @Field(name = "name")
    private String name;

    /**
     * 餐厅类型
     */
    @Field(name = "type")
    private String type;

    /**
     * 经纬度
     */
    @Field(name = "point")
    private Point point;

    /**
     * 点赞数
     */
    @Field(name = "likenum")
    private Long likeNumber;

}
