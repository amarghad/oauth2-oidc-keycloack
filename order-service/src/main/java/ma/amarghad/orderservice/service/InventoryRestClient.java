package ma.amarghad.orderservice.service;

import ma.amarghad.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(url = "http://localhost:8001", name = "inventory-service")
public interface InventoryRestClient {
    @GetMapping("/products")
    List<Product> getAllProducts();
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable String id);
}
