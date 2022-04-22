package examples.zookeeper.leadership;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LeaderShip implements InitializingBean, DisposableBean {

    private CuratorFramework zkClient;
    private LeaderLatch leaderLatch;

    public LeaderShip() throws Throwable {
        super();

        this.leaderLatch = new LeaderLatch(
                CuratorFrameworkFactory.newClient("10.211.55.3:2181", new ExponentialBackoffRetry(1000, 3)),
                "/my-leadership");

        leaderLatch.addListener(new LeaderLatchListener() {
            @Override
            public void isLeader() {
                System.out.println("我当选了");
            }

            @Override
            public void notLeader() {
                System.out.println("我落选了");
            }
        });

        leaderLatch.start();

        System.out.println("-----");
        System.out.println(leaderLatch.hasLeadership());
        System.out.println("-----");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.zkClient = CuratorFrameworkFactory.newClient("10.211.55.3:2181", new ExponentialBackoffRetry(1000, 3));
    }

    @Override
    public void destroy() throws Exception {

    }

}
