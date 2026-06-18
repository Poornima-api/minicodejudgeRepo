package com.minicodejudge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minicodejudge.entity.Submission;
import com.minicodejudge.repository.SubmissionRepository;

@Service
public class SubmissionService {
	@Autowired
	private SubmissionRepository submissionRepository;
	public Submission saveSubmission(Submission submission) {
		return submissionRepository.save(submission);
		
	}

}
