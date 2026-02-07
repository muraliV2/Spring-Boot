package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.userdto.Userdto;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Userdto registerUser(@RequestBody Userdto dto) {
        return userService.registerUser(dto);
    }
    
    @GetMapping("/getuser")
    public List<User>  userdetails()
    {
    	return userService.userdetails();
		
    }
    
//    @GetMapping("/test")
//    public String test() {
//        return "Working";
//    }

}
