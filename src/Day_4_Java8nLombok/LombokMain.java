package Day_4_Java8nLombok;

import java.time.LocalDate;
import java.util.List;

public class LombokMain {
    public static void main(String[] args) {
        Product p1 = new Product();
        p1.setId("P101");
        p1.setName("Laptop");
        p1.setPrice(150000);
        p1.setCategory("Electronics");

        Product p2 = new Product();
        p2.setId("P102");
        p2.setName("Mobile");
        p2.setPrice(45000);
        p2.setCategory("Electronics");

        //Test the builder pattern by creating complex Order objects
        Order order = Order.builder()
                .orderId("ORD101")
                .products(List.of(p1,p2))
                .totalAmount(195000)
                .orderDate(LocalDate.now())
                .build();

        System.out.println(order); //toString works using @Data

        ProductService service = new ProductService();
        service.addProduct(p1);
        service.addProduct(null);

        Configuration configuration = new Configuration("MyApp","TEST",101);
        System.out.println(configuration); //No setters because of @Value


        //Verify that getters, setters, toString, equals, and hashCode work correctly
        Product a = new Product();
        a.setId("P103");
        a.setName("Tablet");
        a.setPrice(40000);
        a.setCategory("Electronics");

        Product b = new Product();
        b.setId("P103");
        b.setName("Tablet");
        b.setPrice(40000);
        b.setCategory("Electronics");

        System.out.println(a.equals(b));
        System.out.println(a.hashCode()==b.hashCode());
        System.out.println(a);
        System.out.println(a.getName());
    }
}
