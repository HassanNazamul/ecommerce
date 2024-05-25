package ecommerce.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ecommerce.ecommerce.model.Cart;

public interface CartRepo extends CrudRepository<Cart, Integer> {

    List<Cart> findByUserid(int userid);

    Optional<Cart> findByProductid(int productid);

}
