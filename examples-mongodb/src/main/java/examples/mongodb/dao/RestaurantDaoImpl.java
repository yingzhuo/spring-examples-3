package examples.mongodb.dao;

import examples.mongodb.doc.Restaurant;
import examples.mongodb.doc.geo.Point;
import lombok.AllArgsConstructor;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@AllArgsConstructor
class RestaurantDaoImpl implements RestaurantDaoExt {

    final MongoTemplate mongoTemplate;

    @Override
    public List<Restaurant> findNear(Point point, double maxDistanceInKilometers, String typeRegex) {

        final Distance distance = new Distance(maxDistanceInKilometers, Metrics.KILOMETERS);
        final Circle circle = new Circle(new org.springframework.data.geo.Point(point.getLongitude(), point.getLatitude()), distance);

        final Criteria geoCriteria = Criteria.where("point").withinSphere(circle);
        final Criteria otherCriteria = Criteria.where("type").regex(typeRegex);

        final Query query = new Query();
        query.addCriteria(geoCriteria);
        query.addCriteria(otherCriteria);

        return mongoTemplate.find(query, Restaurant.class);
    }

}
