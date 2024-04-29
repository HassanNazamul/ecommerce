package ecommerce.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//this is just for tempory
//will changed to REstController.
//when javascript will be used in future.
@Controller
public class CartController {
    
    @RequestMapping("/addToCart")
    public String requestMethodName() {
        return "redirect:/";
    }
    
}
