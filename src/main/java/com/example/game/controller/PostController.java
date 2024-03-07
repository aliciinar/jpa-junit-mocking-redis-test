package com.example.game.controller;

import com.example.game.dto.NewPostDTO;
import com.example.game.dto.UserLoginDTO;
import com.example.game.entity.Post;
import com.example.game.entity.User;
import com.example.game.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/add-post")
    public ResponseEntity<Post> addUser(@RequestBody NewPostDTO newPostDTO){

        Post post = new Post();
        post.setText(newPostDTO.text);
        User user = new User();
        user.setId(newPostDTO.userID);
        post.setUser(user);
        postService.addPost(post);
        return  ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping("get-post/{id}")
    public ResponseEntity<Post> getUserByEmailPathVariable(@PathVariable("id") String id)
    {
        Post post = postService.getPostById(Long.parseLong(id));
        System.out.println("Post geldi");
        return new ResponseEntity<Post>(post,HttpStatus.OK);
    }
}
