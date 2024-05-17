package com.kafka.learn.repo;

import com.kafka.learn.entity.WikimediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<WikimediaEntity, Long> {
}
