package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMeberRepository;

public class OrderServiceImpl implements OrderService{

  private final MemberRepository memberRepository = new MemoryMeberRepository();
  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
  @Override
  public Order createOrder(long memberId, String itemName, int itemPrice) {
    Member member = memberRepository.findById(memberId);
    int discountPrice = discountPolicy.discount(itemPrice, member.getGrade());

    return new Order(memberId, itemName, itemPrice, discountPrice);
  }
}
