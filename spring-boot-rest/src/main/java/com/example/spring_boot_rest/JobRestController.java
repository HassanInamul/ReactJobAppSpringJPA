package com.example.spring_boot_rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_rest.service.JobService;
import com.example.spring_boot_rest.model.JobPost;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
	@Autowired
	private JobService service;
	
	@GetMapping("jobPosts")
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
	}
	
	@GetMapping("jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId) {
		return service.deleteJob(postId);
	}
	@GetMapping("jobPosts/keyword/{keyword}")
	public List<JobPost> findByKeyword(@PathVariable("keyword") String keyword){
		return service.findByKeyword(keyword);
	}
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "Data Loaded";
	}
}
