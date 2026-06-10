package com.minicodejudge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minicodejudge.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
