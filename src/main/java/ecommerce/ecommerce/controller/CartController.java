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

    //this method is to add the product to the cart
    //the model is comming from add button in product tile as form.
    // we are not using cart empty object to get filled by user.
    @PostMapping("/addToCart")
    public String register(@ModelAttribute Cart cart) {
        int productid = cart.getProductid();// this won't provide cart id.

        // getting cart single object from db by product id;
        Optional<Cart> repeatProduct = cartRepo.findByProductid(productid);

        //if the productid already exist, then the quantity will increase,
        //it will prevent the dublicate entry and reduncy.
        //for same product the existing cartId/ cart onject will update,
        //preventing the new entry for the same product
        if (repeatProduct.isPresent()) {
            Cart samePro = repeatProduct.get(); //typecasting optional to Cart
            int initQnt = samePro.getQuantity();//getting the initial quantity
            samePro.setQuantity(initQnt + 1);//incrementing by 1.
            cartRepo.save(samePro); //updating the cart for particualer product
            System.out.println("yes");
        } else {
            cartRepo.save(cart);// if there is no product then new entry will occur.
            System.out.println("no");
        }

        System.out.println("Product id = " + productid);
        return "redirect:/";
    }

    @PostMapping("/removeProduct")
    public String removeProduct(@RequestParam int productid) {

        // getting cart object from db by product id;
        Optional<Cart> product = cartRepo.findByProductid(productid);

        //gettting the cartid from cart object which is found in
        //above statement
        int cartId = product.get().getCartid();

        //deleting the whole single cart object
        cartRepo.deleteById(cartId);
        return "redirect:/";

    }

    @PostMapping("/decrease")
    public String decrease(@RequestBody String entity) {

        return entity;
    }

}
