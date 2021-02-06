package com.myproject.spring.repository;

import com.myproject.spring.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
