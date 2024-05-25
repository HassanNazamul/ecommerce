package ecommerce.ecommerce.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ecommerce.ecommerce.model.Cart;
import ecommerce.ecommerce.repository.CartRepo;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;

//this is just for tempory
//will changed to REstController.
//when javascript will be used in future.
@Controller
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @PostMapping("/addToCart")
    public String register(@ModelAttribute Cart cart) {
        int productid = cart.getProductid();// this won't provide cart id.

        // getting cart object from db by product id;
        Optional<Cart> repeatProduct = cartRepo.findByProductid(productid);

        if (repeatProduct.isPresent()) {

            Cart samePro = repeatProduct.get();
            int initQnt = samePro.getQuantity();
            samePro.setQuantity(initQnt + 1);
            cartRepo.save(samePro);
            System.out.println("yes");
        } else {
            cartRepo.save(cart);
            System.out.println("no");
        }

        System.out.println("Product id = " + productid);
        return "redirect:/";
    }

    @PostMapping("/removeProduct")
    public String removeProduct(@RequestParam int productid) {

        // getting cart object from db by product id;
        Optional<Cart> product = cartRepo.findByProductid(productid);

        //
        int cartId = product.get().getCartid();

        cartRepo.deleteById(cartId);
        return "redirect:/";

    }

    @PostMapping("/decrease")
    public String decrease(@RequestBody String entity) {

        return entity;
    }

}
