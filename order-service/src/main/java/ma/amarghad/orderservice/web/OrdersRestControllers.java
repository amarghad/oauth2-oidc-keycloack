package ma.amarghad.orderservice.web;

import ma.amarghad.orderservice.entities.Order;
import ma.amarghad.orderservice.repository.OrderRepository;
import ma.amarghad.orderservice.service.InventoryRestClient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrdersRestControllers {
    private OrderRepository orderRepository;
    private InventoryRestClient inventoryRestClient;


    @GetMapping("/orders")
    public List<Order> findAllOrders(){
        List<Order> allOrders = orderRepository.findAll();
        allOrders.forEach(o-> {
            o.getProductItems().forEach(
                pi-> pi.setProduct(inventoryRestClient.findProductById(pi.getProductId()))
            );
        });
        return allOrders;
    }
    @GetMapping("/orders/{id}")
    public Order findOrderById(@PathVariable String id){
        Order order = orderRepository.findById(id).get();
        order.getProductItems().forEach(pi->{
            pi.setProduct(inventoryRestClient.findProductById(pi.getProductId()));
        });
        return order;
    }
}
