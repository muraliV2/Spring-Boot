package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<Userdto> registerUser(@RequestBody Userdto dto) {
        Userdto userdto2 = userService.registerUser(dto);
        return new ResponseEntity<>(userdto2,HttpStatus.CREATED);
    	//return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(dto));  
   

    }
    
    @GetMapping("/getuser")
    public List<User>  userdetails()
    {
    	return userService.userdetails();
		
    }
    
    @GetMapping("/getdetails/{userId}")
    public ResponseEntity<Userdto> getuserbyId(@PathVariable int userId) {
        Userdto user = userService.getuserbyId(userId);
        return new  ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/by-email")

    public ResponseEntity<Userdto> getuserbyemail(@RequestParam String email)
    {
    	Userdto user1 =  userService.getuserbyemail(email);
    	return new ResponseEntity<>(user1,HttpStatus.OK);
    }

    
    
    
    

}
