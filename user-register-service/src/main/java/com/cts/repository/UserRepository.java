package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.UserDao;

@Repository
public interface UserRepository extends JpaRepository<UserDao, Integer> {

	 UserDao findByPan(String pan);
}







