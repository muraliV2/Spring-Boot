package com.example.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.userdao.Userdao;
import com.example.userdto.Userdto;

public class UserService 
{
	Userdao Userdao = new Userdao();

	public  void RegisterUser(  Userdto dto) {
		
		Userdao.RegsiterUser(null);
	}

}
