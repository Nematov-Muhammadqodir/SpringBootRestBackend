package com.kevin.spring_boot_rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.spring_boot_rest.model.JobPost;
import com.kevin.spring_boot_rest.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public Optional<JobPost> getJob(@PathVariable("id") int jobPostId) {
        return service.getJob(jobPostId);
    }

    @PostMapping("jobPost")
    public Optional<JobPost> addJob(@RequestBody JobPost jobPost) {

        service.addJob(jobPost);

        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public Optional<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        service.updateJobPost(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJob(@PathVariable("id") int postId) {
        service.deleteJob(postId);
        return "Deleted";
    }

}
