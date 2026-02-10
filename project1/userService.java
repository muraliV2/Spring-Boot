package com.example.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
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

	public Userdto getuserbyId(int userId) {
        Optional<User> opt = dao.getuserbyId(userId);

        if (opt.isPresent()) {
            return mapper.map(opt.get(), Userdto.class);
        } else {
            throw new RuntimeException("User not found with id " + userId);
        }
    }

	
	
	
	

}
