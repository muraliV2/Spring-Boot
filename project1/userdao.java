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
//    	Optional<User> opt = userrepository.findById(user.getUserId());
//    	if(opt.isPresent())
//    	{
//    		throw new IllegalArgumentException("already value present in thsi Id");
//    	}
//    	else
//    	{
//    		return userrepository.save(user);
//    		
//    	}
    	return userrepository.save(user);
       
    }
	public List<User> userdetails() 
	{
	return userrepository.findAll();
	}
	
	public User getuserbyId(int userId) 
	{
		
		return userrepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("No UserId Found"));
	}

	public User getuserbyemail(String email) {
		return userrepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Email doesnt Exist"));
	}

	public  User updateuser(User user1) 
	{
	Optional<User> opt = userrepository.findById(user1.getUserId());
	if(opt.isPresent())
	{
		return userrepository.save(user1);
		
		
	}
	else
	{
		throw new IllegalArgumentException("There is a problem in this code");
	}
	
	}

	public String deleteuser(int userId) {
		
		Optional<User> opt = userrepository.findById(userId);
		if(opt.isPresent())
		{
			 userrepository.deleteById(userId);
			 return "User Deleted Successfully";
			
		}
		else
		{
			
			throw new IllegalArgumentException("there is  a error in thsi program");
		}
		
		
	}

	public User loginUSer(String email) {
	
		
		return userrepository.findByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException("Email Not Found"));
		
	}
}
