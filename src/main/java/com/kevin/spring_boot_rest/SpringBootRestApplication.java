package com.kevin.spring_boot_rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kevin.spring_boot_rest.model.JobPost;
import com.kevin.spring_boot_rest.repo.JobRepo;

@SpringBootApplication
public class SpringBootRestApplication {

	public static void main(String[] args) {
		List<JobPost> jobs = new ArrayList<>(Arrays.asList(

				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2,
						List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),

				new JobPost(2, "Frontend Developer",
						"Experience in building responsive web applications using React", 3,
						List.of("HTML", "CSS", "JavaScript", "React")),

				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4,
						List.of("Python", "Machine Learning", "Data Analysis")),

				new JobPost(4, "Network Engineer",
						"Design and implement computer networks for efficient data communication", 5,
						List.of("Networking", "Cisco", "Routing", "Switching")),

				new JobPost(5, "Mobile App Developer",
						"Experience in mobile app development for iOS and Android", 3,
						List.of("iOS Development", "Android Development", "Mobile App"))));
		ApplicationContext context = SpringApplication.run(SpringBootRestApplication.class, args);

		JobRepo repo = context.getBean(JobRepo.class);

		// JobPost jp = context.getBean(JobPost.class);
		// jp.setPostId(1);
		// jp.setPostProfile("Java Developer");
		// jp.setPostDesc("Must have good experience in core Java and advanced Java");
		// jp.setPostTechStack(List.of("Core Java", "J2EE", "Spring Boot",
		// "Hibernate"));

		// repo.save(jp);
		repo.saveAll(jobs);

	}

}
