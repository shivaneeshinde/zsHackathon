package com.zs.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zs.hackathon.entity.Activities_Scheduled;

@Repository
public interface ActivityRepository extends JpaRepository<Activities_Scheduled, Integer> {

}
