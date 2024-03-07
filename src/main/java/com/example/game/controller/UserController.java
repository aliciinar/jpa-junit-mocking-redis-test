package com.example.game.controller;

import com.example.game.dto.UserLoginDTO;
import com.example.game.dto.UserLoginResponseDTO;
import com.example.game.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.game.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("sign-up")
    public ResponseEntity<User> addUser(@RequestBody UserLoginDTO userLoginDTO){
        System.out.println("Çalıştım");
        User user = new User();
        user.setEmail(userLoginDTO.Email);
        user.setPassword(userLoginDTO.Password);
        User addUser = userService.addUser(user);
      return   ResponseEntity.status(HttpStatus.CREATED).header("bir","ss").header("iki","aa").body(addUser);
       // return  new ResponseEntity<User>(addUser, HttpStatus.CREATED);
    }


    // usage of mapping framework
    private UserLoginResponseDTO Map(User user)
    {
        return modelMapper.map(user,UserLoginResponseDTO.class);
    }



    @GetMapping("getUser")
    public ResponseEntity<User> getUserByEmail(String email){
        System.out.println("Value");
        System.out.println(email);
        System.out.println("email");
        User user = userService.getUserByEmail(email);
        System.out.println(user.getEmail());
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @GetMapping("getUserBody")
    public ResponseEntity<String> getUserByEmailBody(@RequestBody String email){
        System.out.println("Value");
        System.out.println(email);
        System.out.println("email");
        User user = userService.getUserByEmail(email);
        System.out.println(user.getEmail());
        return new ResponseEntity<String>(user.getEmail(),HttpStatus.OK);
    }

    @GetMapping("getUserPathVariable/{email}")
    public ResponseEntity<User> getUserByEmailPathVariable(@PathVariable("email") String email){
        System.out.println("Value");
        System.out.println(email);
        System.out.println("email");
        User user = userService.getUserByEmail(email);
        System.out.println(user.getEmail());
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @PutMapping("updateUsername")
    public  ResponseEntity setUsername(@RequestParam String email, @RequestParam String newUsername)
    {
        userService.setUsername(email,newUsername);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllCustomer(){
        List<User> allUser = userService.findAllCustomer();
        return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getCustomerId(@PathVariable("id") Long id){
        User customerById = userService.getUserById(id);
        return new ResponseEntity<User>(customerById,HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        userService.deleteCustomerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
