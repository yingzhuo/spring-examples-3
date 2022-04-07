package examples.mongodb;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "examples.mongodb")
@AllArgsConstructor
class ApplicationBootMongo implements InitializingBean {

    private final MongoTemplate mongoTemplate;

    @Override
    public void afterPropertiesSet() {
        // 添加索引等

        // 创建单索引
//        mongoTemplate.indexOps(Reply.class)
//                .ensureIndex(new Index().on("userId", Sort.Direction.ASC));
//        mongoTemplate.indexOps(Reply.class)
//                .ensureIndex(new Index().on("replyDate", Sort.Direction.ASC));

        // 创建符合索引
//        mongoTemplate.indexOps(Reply.class)
//                .ensureIndex(
//                        new CompoundIndexDefinition(
//                                new Document()
//                                        .append("userId", 1)
//                                        .append("status", 1)
//                                        .append("replyDate", 1)
//                        )
//                );
    }

}
