package com.example.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

//    public Userdto registerUser(Userdto dto) {
//
//        User user = mapper.map(dto, User.class);
//        User savedUser = dao.registerUser(user);
//        return mapper.map(savedUser, Userdto.class);
//    }

	public List<User> userdetails() {
	return 	dao.userdetails();
		
	}

	public ResponseStructure<Userdto> getuserbyId(int userId) {
        User user = dao.getuserbyId(userId);
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

	public ResponseStructure<Userdto> updateuser(Userdto user) 
	{
		
		User user1 = mapper.map(user, User.class);
		User saveduser = dao.updateuser(user1);
		Userdto fuser = mapper.map(saveduser,Userdto.class);
		ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
		structure.setData(fuser);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setStatusCode(200);
		structure.setMessage("Data Updated Successfully");
		return structure;
		
		
				
		
	}

	public ResponseStructure<String> deleteuser(int userId) 
	{
		String message = dao.deleteuser(userId);
	ResponseStructure<String> structure = new ResponseStructure<>();	
	structure.setData(message);
	structure.setStatusCode(200);
	structure.setTimeStamp(LocalDateTime.now());
	structure.setMessage("Data Deleted Successfully");
		return structure;
	}

	public ResponseStructure<Userdto> registerUser(Userdto dto) {
		User user = mapper.map(dto,User.class);
		User saveduser = dao.registerUser(user);
		Userdto fuser = mapper.map(saveduser, Userdto.class);
		ResponseStructure<Userdto> structure = new ResponseStructure<>();
		structure.setData(fuser);
		structure.setStatusCode(200);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Registered Successfully");
		return structure;
		
		
		
	}

	public ResponseStructure<Userdto> loginUser(String email, String password) 
	{
		User user = dao.loginUSer(email);
		if(user.getPassword().equals(password))
		{
			Userdto dto = mapper.map(user,Userdto.class);
			ResponseStructure<Userdto> structure = new ResponseStructure<Userdto>();
			structure.setData(dto);
			structure.setMessage("login Successfull");
			structure.setStatusCode(200);
			structure.setTimeStamp(LocalDateTime.now());
			return structure;
		}
		else
		{
			throw new IllegalArgumentException("Password Incorrect");
		}
	}

	

	
	
	
	
	

}
