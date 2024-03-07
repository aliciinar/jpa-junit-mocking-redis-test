package com.example.game.service;

import com.example.game.dto.ReportDTO;
import com.example.game.entity.Post;
import com.example.game.entity.Report;
import com.example.game.entity.User;
import com.example.game.repository.ReportRepository;
import com.example.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private IPostService postService;

    @Autowired
    private ReportRepository reportRepository;

   public Report addReport(ReportDTO report)
   {
       Post post = postService.getPostById(report.postID);
       if(post == null )
       {
           throw new IllegalArgumentException("Post not found");

       }
       User user = userService.getUserById(report.userID);
       Report report1 = new Report();
       report1.setPostID(report.postID);
       user.getReports().add(report1);
       userRepository.save(user);
       return report1;
   }


}
