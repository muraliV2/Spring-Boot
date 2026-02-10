package com.example.userdao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.userdto.Userdto;

@Repository
public class Userdao {

    @Autowired
    private UserRepository userrepository;

    public User registerUser(User user) 
    {  
        return userrepository.save(user);
    }

	public List<User> userdetails() 
	{
	return userrepository.findAll();
	
		
	}
	
	public Optional<User> getuserbyId(int userId)
	{
		
		 Optional<User> opt  = userrepository.findById(userId);
		 return opt;
	}
}
