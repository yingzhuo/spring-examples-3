package examples.mongodb.dao;

import examples.mongodb.doc.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends MongoRepository<Restaurant, String>, RestaurantDaoExt {
}
