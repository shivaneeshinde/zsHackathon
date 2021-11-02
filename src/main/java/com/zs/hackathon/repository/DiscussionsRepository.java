package com.zs.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zs.hackathon.entity.Discussions;

@Repository
public interface DiscussionsRepository extends JpaRepository<Discussions, Integer> {

}
