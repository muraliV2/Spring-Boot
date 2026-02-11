package com.example.service;

import java.time.LocalDateTime;
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
import com.example.util.ResponseStructure;

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

	public ResponseStructure<Userdto> getuserbyId(int userId) {
        User user = Userdao.getuserbyId(userId);
		ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
		Userdto userdto = mapper.map(user,Userdto.class);
		structure.setData(userdto);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setStatusCode(200);
		structure.setMessage("user found Successfully");
		return structure;
    }

	public ResponseStructure<Userdto> getuserbyemail(String email) 
	{
		User user = dao.getuserbyemail(email);
		ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
		Userdto userdto = mapper.map(user, Userdto.class);
		structure.setData(userdto);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setStatusCode(200);
		structure.setMessage("user found Successfully");
		return structure;
	}

	
	
	
	

}
