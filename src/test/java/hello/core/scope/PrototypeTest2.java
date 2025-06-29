package hello.core.scope;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest2 {

    @Test
    void singletonWithprototypeBeanFind() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class,
            PrototypeBean.class);

        PrototypeTest2.SingletonBean singletonBean1 = ac.getBean(
            PrototypeTest2.SingletonBean.class);

        singletonBean1.logic();
        singletonBean1.logic();

        Assertions.assertThat(singletonBean1.getPrototypeCount()).isEqualTo(0);
    }

    @RequiredArgsConstructor
    static class SingletonBean {

        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public void logic() {
            System.out.println("SingletonBean logic called");
            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            prototypeBean.setCount(prototypeBean.getCount() + 1);
            int count = prototypeBean.getCount();
            System.out.println("PrototypeBean logic count: " + count);
        }

        public int getPrototypeCount() {
            return prototypeBeanProvider.getObject().getCount();
        }
    }

    @Setter
    @Getter
    @Scope("prototype")
    static class PrototypeBean {

        private int count = 0;


    }
}
