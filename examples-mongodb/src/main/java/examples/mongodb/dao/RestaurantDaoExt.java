package examples.mongodb.dao;

import examples.mongodb.doc.Restaurant;
import examples.mongodb.doc.geo.Point;

import java.util.List;

public interface RestaurantDaoExt {

    public List<Restaurant> findNear(Point point, double maxDistanceInKilo, String typeRegex);

}
