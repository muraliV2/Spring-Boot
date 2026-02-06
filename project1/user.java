package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User 
{
	@Id
private int UserId;
private String UserName;
private String Email;
private String Password;
private long Contact;
public int getUserId() {
	return UserId;
}
public void setUserId(int userId) {
	UserId = userId;
}
public String getUserName() {
	return UserName;
} 
public void setUserName(String userName) {
	UserName = userName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public long getContact() {
	return Contact;
}
public void setContact(long contact) {
	Contact = contact;
}


}
