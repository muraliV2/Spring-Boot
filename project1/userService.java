package com.example.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.userdao.Userdao;
import com.example.userdto.Userdto;

@Service
public class UserService {

    @Autowired
    private Userdao dao;

    @Autowired
    private ModelMapper mapper;

    public Userdto registerUser(Userdto dto) {

        User user = mapper.map(dto, User.class);
        User savedUser = dao.registerUser(user);
        return mapper.map(savedUser, Userdto.class);
    }

	public List<User> userdetails() {
	return 	dao.userdetails();
		
	}

}
