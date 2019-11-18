package com.producer.docker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProducerRepository extends JpaRepository <Users, Integer> {
}
