package examples.zookeeper.controller;

import examples.zookeeper.leadership.LeaderShip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leader")
public class LeaderController {

    @Autowired
    private LeaderShip leaderShip;

    @GetMapping
    public String leadership() {
//        return leaderShip.hasLeaderShip() ? "yes" : "no";
        return "";
    }

}
