package com.example.game.service;

import com.example.game.entity.User;

import java.util.List;

public interface IUserService   {
     User addUser(User customer);

     List<User> findAllCustomer();

     User getUserById(Long customerId);

     void deleteCustomerById(Long customerId);

     User getUserByEmail(String email);

     boolean  setUsername(String email, String newUsername);
}
