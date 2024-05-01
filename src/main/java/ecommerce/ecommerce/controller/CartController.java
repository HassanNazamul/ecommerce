package ecommerce.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.ecommerce.model.Cart;
import ecommerce.ecommerce.repository.CartRepo;
import jakarta.servlet.http.HttpServletResponse;

//this is just for tempory
//will changed to REstController.
//when javascript will be used in future.
@RestController
public class CartController {

    @Autowired
    private CartRepo cartRepo;

    @PostMapping("/addToCart")
    public void register(@ModelAttribute Cart cart, HttpServletResponse response) throws IOException {

        cartRepo.save(cart);
        response.sendRedirect("/");
    }

}
