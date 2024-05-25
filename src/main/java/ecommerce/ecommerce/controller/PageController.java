package ecommerce.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ecommerce.ecommerce.model.Cart;
import ecommerce.ecommerce.model.Product;
import ecommerce.ecommerce.repository.CartRepo;
import ecommerce.ecommerce.repository.ProductRepo;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageController {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    private HttpSession session;

    //this will take the user to cart Page
    @RequestMapping("/cartPage")
    public String cartPage(Model model) {
        // this user id will get from session
        // this cartlist contain all info userid and productid
        // this will used in other parts also
        int id = (int) session.getAttribute("userID");

        //this provide the Cartlist of Object (cartis, userid, productid)
        List<Cart> cartList = cartRepo.findByUserid(id);

        //this is the list of only product object
        //(productid, category, price, description) stored in cart
        List<Product> productList = new ArrayList<>();

        //using the cart list to get the productid and use the productid 
        //to make the list of product
        for (Cart cart : cartList) {
            Optional<Product> optionalProduct = productRepo.findById(cart.getProductid());
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                productList.add(product);
            }
        }

        double total = productList.stream().mapToDouble(Product::getPrice).sum();
        model.addAttribute("total", total);

        model.addAttribute("productlist", productList);
        return "cart";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

}
