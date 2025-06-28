package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    @Configuration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);

        // Thread A: A 사용자 10000원 주문
        statefulService.order("userA", 10000);

        // Thread B: B 사용자 20000원 주문
        statefulService.order("userB", 20000);

        // Thread A: 사용자 A의 주문 금액 조회
        int price = statefulService.getPrice();
        System.out.println("price = " + price); // 예상치 못한 결과가 나올 수 있음

    }
}
