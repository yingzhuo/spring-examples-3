package examples.mongodb;

import examples.mongodb.dao.RestaurantDao;
import examples.mongodb.doc.Restaurant;
import examples.mongodb.doc.geo.Point;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
class DataInit implements ApplicationRunner {

    private final MongoTemplate mongoTemplate;
    private final RestaurantDao restaurantDao;

    @Override
    public void run(ApplicationArguments args) {

        mongoTemplate.indexOps(Restaurant.class)
                .ensureIndex(
                        new GeospatialIndex("point")
                                .typed(GeoSpatialIndexType.GEO_2DSPHERE)
                );


        final long count = restaurantDao.count();
        if (count == 0) {
            log.debug("初始化数据");
            final List<Restaurant> list = new ArrayList<>();

            list.add(
                    Restaurant.builder()
                            .id(null)
                            .name("仔仔烧烤")
                            .type("中餐,烧烤")
                            .point(new Point(-73.96671D, 40.78D))
                            .build()
            );

            list.add(
                    Restaurant.builder()
                            .id(null)
                            .name("新疆饺子馆")
                            .type("中餐")
                            .point(new Point(-73.96672D, 40.78D))
                            .build()
            );

            list.add(
                    Restaurant.builder()
                            .id(null)
                            .name("麦当劳(梅家浜路店)")
                            .type("快餐")
                            .point(new Point(-73.96673D, 40.78D))
                            .build()
            );

            list.add(
                    Restaurant.builder()
                            .id(null)
                            .name("永和大王(梅家浜路店)")
                            .type("快餐")
                            .point(new Point(-73.96673D, 40.78D))
                            .build()
            );

            restaurantDao.saveAll(list);
        }
    }

}
