package hello.core.lombok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");
        helloLombok.setAge(20);

        System.out.println("helloLombok = " + helloLombok);
        System.out.println("helloLombok.getName() = " + helloLombok.getName());
        System.out.println("helloLombok.getAge() = " + helloLombok.getAge());
    }

}
