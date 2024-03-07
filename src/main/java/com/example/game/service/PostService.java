package com.example.game.service;

import com.example.game.entity.Post;
import com.example.game.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService
{

    @Autowired
    private PostRepository postRepository;

    @Override
    @CachePut(value = "post", key = "#result.postID")
    public Post addPost(Post post) {return postRepository.save(post);
    }

    @Override
    @Cacheable(value="post", key="#id")
    public Post getPostById(long id) {

        try {
            System.out.println("Db den geldi");
            System.out.println(id);
            return postRepository.findById(id).get();
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException("post not found with id: " + e.getMessage());
        }

    }
}
