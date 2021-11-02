package com.happy.workplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happy.workplace.entity.Activities_Scheduled;

@Repository
public interface ActivityRepository extends JpaRepository<Activities_Scheduled, Integer> {

}
