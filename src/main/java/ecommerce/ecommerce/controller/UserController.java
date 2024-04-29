package ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ecommerce.ecommerce.model.MyUser;
import ecommerce.ecommerce.repository.MyUserRepo;

// this Controller is only for 
// add User, Update User, Delete User

@Controller
public class UserController {
 
    @Autowired
    private MyUserRepo myUserRepo;
    
    @RequestMapping("/addUser")
    public String addUser(@ModelAttribute MyUser newUser) {

        myUserRepo.save(newUser);
        return "redirect:/";
    }
}
