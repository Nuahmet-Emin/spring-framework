package com.cydeo.repository;

import com.cydeo.entity.Course;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // find all course by category

    List<Course> findByCategory(String category);

    // find all course by category and order the entities by name

    List<Course> findByCategoryOrderByName(String category);

    //checks if a course with the provided name exists, return true if course exists, false otherwise
    boolean existsByName(String name);

    //return the count of course for the provided category
    int countByCategory(String category);

    //find all course that start with the provided course name;
    List<Course> findByNameStartsWith(String name);

    // find all course by category and returns a stream
    Stream<Course> streamByCategory(String category);
}
