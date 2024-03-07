package com.example.game.controller;


import com.example.game.dto.NewPostDTO;
import com.example.game.dto.ReportDTO;
import com.example.game.entity.Post;
import com.example.game.entity.Report;
import com.example.game.entity.User;
import com.example.game.repository.ReportRepository;
import com.example.game.service.IPostService;
import com.example.game.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/add-report")
    public ResponseEntity<Report> addReport(@RequestBody ReportDTO reportDTO)
    {
        Report report = reportService.addReport(reportDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(report);
    }


}
