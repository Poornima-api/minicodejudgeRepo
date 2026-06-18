package com.minicodejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minicodejudge.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission,Long>{

}
