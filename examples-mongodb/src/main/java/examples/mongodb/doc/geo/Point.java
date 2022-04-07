package examples.mongodb.doc.geo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Point implements Serializable {

    /**
     * 经度 (x)
     */
    private Double longitude;

    /**
     * 纬度 (y)
     */
    private Double latitude;

}
