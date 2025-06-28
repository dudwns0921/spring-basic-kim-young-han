package hello.core.discount;

import hello.core.member.Grade;

public class RateDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(int price, Grade memberGrade) {
        if(memberGrade == Grade.VIP) {
            return (price * 10) / 100; // 10% discount for VIP members
        } else {
            return 0; // No discount for non-VIP members
        }
    }
}
