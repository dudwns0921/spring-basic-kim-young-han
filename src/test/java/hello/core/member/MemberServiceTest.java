package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberService memberService = ac.getBean("memberService", MemberService.class);

    @Test
    void join() {
        //given
        Member member = new Member(1l, "memberA", Grade.VIP);
        // when
        memberService.register(member);
        Member findMember = memberService.findMember(1l);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
