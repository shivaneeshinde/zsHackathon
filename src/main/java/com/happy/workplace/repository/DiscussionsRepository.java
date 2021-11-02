package com.happy.workplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happy.workplace.entity.Discussions;

@Repository
public interface DiscussionsRepository extends JpaRepository<Discussions, Integer> {

}
