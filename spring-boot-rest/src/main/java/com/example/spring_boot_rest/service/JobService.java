package com.example.spring_boot_rest.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.repo.JobRepo;



@Service
public class JobService {
	@Autowired
	private JobRepo repo;
	public void addJob(JobPost jobs) {
		repo.save(jobs);
	}
	public List<JobPost> getAllJobs(){
		return repo.findAll();
	}
	public JobPost getJob(int postId) {
		return repo.findById(postId).orElse(new JobPost());
	}
	public void updateJob(JobPost jobPost) {
		repo.save(jobPost);
	}
	public String deleteJob(int postId) {
		repo.deleteById(postId);
		return "Job Deleted Successfully";
	}
	public void load() {
		List<JobPost> jobs=new ArrayList<>(Arrays.asList(
				new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java",2,List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
				new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React",3, List.of("HTML", "CSS", "JavaScript", "React")),
				new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis",4,List.of("Python", "Machine Learning", "Data Analysis")),
				new JobPost(4, "Network Engineer","Design and implement computer networks for efficient data communication", 5,List.of("Networking", "Cisco", "Routing", "Switching"))
				));
		repo.saveAll(jobs);
	}
	public List<JobPost> findByKeyword(String keyword) {
		
		return repo.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
	}
}
