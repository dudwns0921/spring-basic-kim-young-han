package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
    // 기존의 만든 AppConfig와 충돌하지 않도록 예외 처리
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // Exclude classes annotated with @Configuration
)
public class AutoAppConfig {

}
