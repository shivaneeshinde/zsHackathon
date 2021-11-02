package com.happy.workplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.happy.workplace.entity.Event_Type;

@Repository
public interface EventRepository extends JpaRepository<Event_Type, Integer> {

}
