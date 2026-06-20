package com.anupam.studentManagementJpa.repository;

import com.anupam.studentManagementJpa.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}
