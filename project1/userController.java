package com.example.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;
import com.example.userdto.Userdto;

@RestController
@RequestMapping("/User")
public class UserController 
{
	
	UserService userservice = new UserService();
	@PostMapping("/Register")
public String RegisterUser(@RequestBody Userdto dto)
{
		
		UserService.RegisterUser(dto);
return null;	
}
{
	
}

{
	
}
}
