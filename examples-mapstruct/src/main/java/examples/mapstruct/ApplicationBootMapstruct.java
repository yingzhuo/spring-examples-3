package examples.mapstruct;

import examples.mapstruct.domain.CarVOMapper;
import lombok.AllArgsConstructor;
import org.mapstruct.extensions.spring.SpringMapperConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringMapperConfig(conversionServiceAdapterPackage = "examples.mapstruct")
@AllArgsConstructor
class ApplicationBootMapstruct {

    private final CarVOMapper carVOMapper;

}
