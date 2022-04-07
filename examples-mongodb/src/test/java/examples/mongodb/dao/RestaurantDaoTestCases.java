package examples.mongodb.dao;

import examples.mongodb.ApplicationBoot;
import examples.mongodb.doc.geo.Point;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.NONE,
        classes = {
                ApplicationBoot.class
        }
)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RestaurantDaoTestCases {

    @Autowired
    private RestaurantDao restaurantDao;

    @Test
    public void test1() {
        val list = restaurantDao.findNear(new Point(-73.9667D, 40.78D), 1D, "^.*快餐.*$");
        list.forEach(System.out::println);
    }

}
