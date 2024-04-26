package ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ecommerce.ecommerce.model.MyUser;

public interface MyUserRepo extends CrudRepository<MyUser,Integer> {
    
    List <MyUser> findByName(String name);
}
