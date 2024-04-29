package ecommerce.ecommerce.repository;

// import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ecommerce.ecommerce.model.MyUser;

public interface MyUserRepo extends CrudRepository<MyUser,Integer> {
    
    Optional <MyUser> findByName(String name);
}
