package com.example.game.service;

import com.example.game.entity.Role;
import com.example.game.entity.User;
import com.example.game.exception.CustomerNotNullException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.game.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User customer){

        if(customer.getEmail().isBlank()){
            throw new CustomerNotNullException("Email can not be null");
        }
        return userRepository.save(customer);
    }

    public List<User> findAllCustomer(){
        return userRepository.findAll();
    }

    public User getUserById(Long customerId){
        return userRepository.findById(customerId).get();
    }

    public User getUserByEmail(String email){return  userRepository.findByEmail(email).get(); }

    public void deleteCustomerById(Long customerId){
        userRepository.deleteById(customerId);
    }

    public boolean  setUsername(String email, String newUsername)
    {
        User user = userRepository.findByEmail(email).get();
        if (user != null) {
            user.setUsername(newUsername);
             userRepository.save(user);
             return true;
        } else {
            //throw new RuntimeException("User not found with email: " + email);
            return false;
        }
    }



}