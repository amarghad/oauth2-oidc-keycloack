package ma.amarghad.inventoryservice.repository;

import ma.amarghad.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
