package hello.core.discount;

import hello.core.member.Grade;

public interface DiscountPolicy {
  int discount(int price, Grade memberGrade);

}
