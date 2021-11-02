package com.happy.workplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.happy.workplace.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	@Query("from Users where email = ?1 and password = ?2")
	List<Users> findByEmailAndPassword(String email, String password);
	
}
