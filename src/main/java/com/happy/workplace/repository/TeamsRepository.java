package com.happy.workplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happy.workplace.entity.Teams;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
