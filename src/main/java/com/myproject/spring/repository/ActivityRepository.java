package com.myproject.spring.repository;

import com.myproject.spring.model.Activity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
