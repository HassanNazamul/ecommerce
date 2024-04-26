package ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecommerce.ecommerce.model.Product;

public interface ProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findByCategory(String category);
}
