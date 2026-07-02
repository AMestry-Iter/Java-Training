package Day_4_Java8nLombok;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductService {
    private List<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        try {
            if(product == null || product.getName() == null){
                throw new IllegalArgumentException("Invalid Product");
            }
            productList.add(product);
            log.info("Product added successfully: {}" , product.getName());
        }catch (Exception e){
        log.error("Failed to add product: {}", e.getMessage());
        }
    }

}
