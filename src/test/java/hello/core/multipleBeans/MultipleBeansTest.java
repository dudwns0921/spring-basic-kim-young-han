package hello.core.multipleBeans;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MultipleBeansTest {

    @Test
    void findAllBeans() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,
            DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        int discountPrice = discountService.discount(member, 10000);
        System.out.println("discountPrice = " + discountPrice);

    }

    static class DiscountService {

        // This class is used to test multiple beans with the same type
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap,
            List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price) {
            DiscountPolicy discountPolicy;
            if (member.getGrade() == Grade.VIP) {
                discountPolicy = policyMap.get("rateDiscountPolicy");
            } else {
                discountPolicy = policyMap.get("fixDiscountPolicy");
            }

            return discountPolicy.discount(price, member.getGrade());
        }
    }
}
