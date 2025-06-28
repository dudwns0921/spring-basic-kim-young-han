package hello.core.singleton;

public class StatefulService {
    private  int price; // 상태를 유지하는 필드
    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; // 가격을 필드에 저장
    }

    public int getPrice() {
        return price; // 저장된 가격을 반환
    }
}
