package com.example.game.service;

import com.example.game.entity.Post;
import com.example.game.entity.User;

public interface IPostService {

    Post addPost(Post post);

    Post getPostById(long id);

}
