package examples.jpa;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
class ApplicationBootJackson {

    @Autowired
    void initObjectMapper(ObjectMapper om) {
        om.registerModule(new Hibernate5Module());
    }

}
