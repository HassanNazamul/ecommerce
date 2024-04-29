package ecommerce.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

import ecommerce.ecommerce.model.MyUser;
import ecommerce.ecommerce.model.Product;
import ecommerce.ecommerce.repository.MyUserRepo;
import ecommerce.ecommerce.repository.ProductRepo;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private MyUserRepo myUserrRepo;

    @Autowired
    private ProductRepo productRepo;

    // This will take user to landing page
    @RequestMapping("/")
    public String index(Model model) {
        List<Product> popular = productRepo.findByCategory("cat1");
        model.addAttribute("popular", popular);
        return "index";
    }

    // redirecting to Login Page
    // with empty user object
    @RequestMapping("/loginPage")
    public String loginPage(Model model) {
        model.addAttribute("existUser", new MyUser());
        return "login";
    }

    // getting user info
    // searching for user
    // need to handle error at both client and server side
    // need to add case where user is not found and need
    // to be redireted to the signup page
    // login and security is pending
    @RequestMapping("/login")
    // @ResponseBody
    public String login(@ModelAttribute MyUser user, HttpSession session) {
        Optional<MyUser> obj = myUserrRepo.findByName(user.getName());
        session.setAttribute("userName", obj.get().getName());
        session.setAttribute("userID", obj.get().getId());
        return "redirect:/";
    }

    //directing user or signup page.
    @RequestMapping("/signUpPage")
    public String signUpPage(Model model) {
        model.addAttribute("newUser", new MyUser());
        return "signup";
    }


    // testing
    // @RequestMapping("/test")
    // public String test(Model model) {
    //     List<Product> products = productRepo.findByCategory("cat2");
    //     model.addAttribute("products", products);
    //     return "test";
    // }

}
