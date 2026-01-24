package com.kevin.spring_boot_rest.service;

import com.kevin.spring_boot_rest.model.JobPost;
import com.kevin.spring_boot_rest.repo.JobRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;

    public List<JobPost> getAllJobs() {
        return repo.findAll();
    }

    public Optional<JobPost> getJob(int jobPostId) {
        return repo.findById(jobPostId);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

    public JobPost addJob(@RequestBody JobPost jobPost) {

        return repo.save(jobPost);
    }

    public JobPost updateJobPost(@RequestBody JobPost jobPost) {

        return repo.save(jobPost);
    }

    public String deleteJob(@PathVariable("id") int postId) {
        repo.deleteById(postId);
        return "Deleted";
    }

}
