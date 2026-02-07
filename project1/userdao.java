package com.example.userdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Repository
public class Userdao {

    @Autowired
    private UserRepository userrepository;

    public User registerUser(User user) {   // ✅ fixed name
        return userrepository.save(user);
    }

	public List<User> userdetails() 
	{
	return userrepository.findAll();
		
	}
}
