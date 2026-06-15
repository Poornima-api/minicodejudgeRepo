package com.minicodejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minicodejudge.entity.Problem;

public interface ProblemRepository
        extends JpaRepository<Problem, Long> {

}