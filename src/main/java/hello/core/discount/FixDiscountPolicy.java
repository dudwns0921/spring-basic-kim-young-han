package hello.core.discount;

import hello.core.member.Grade;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(int price, Grade memberGrade) {
        if (memberGrade == Grade.VIP) {
            return 1000;
        } else {
            return 0; // No discount for non-VIP members
        }
    }
}
