package com.zs.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zs.hackathon.entity.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
