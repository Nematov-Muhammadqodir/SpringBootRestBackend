package com.kevin.spring_boot_rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kevin.spring_boot_rest.model.JobPost;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

        // ArrayList to store JobPost objects

        // method to return all JobPosts
        // public List<JobPost> getAllJobs() {
        // return jobs;
        // }

        // method to save a job post object into arrayList
        // public void addJob(JobPost job) {
        // jobs.add(job);
        // System.out.println(jobs);

        // }

        // public JobPost getJob(int value) {
        // for (JobPost job : jobs) {
        // if (job.getPostId() == value) {
        // return job;
        // }
        // }

        // return null;
        // }

        // public void updateJobPost(JobPost jobPost) {
        // for (JobPost job : jobs) {
        // if (job.getPostId() == jobPost.getPostId()) {
        // job.setPostDesc(jobPost.getPostDesc());
        // job.setPostId(jobPost.getPostId());
        // job.setPostProfile(jobPost.getPostProfile());
        // job.setPostTechStack(jobPost.getPostTechStack());
        // job.setReqExperience(jobPost.getReqExperience());

        // }
        // }

        // }

        // public void deleteJob(int postId) {
        // for (JobPost jobPost : jobs) {
        // if (jobPost.getPostId() == postId) {
        // jobs.remove(postId);
        // }
        // }
        // }
}
