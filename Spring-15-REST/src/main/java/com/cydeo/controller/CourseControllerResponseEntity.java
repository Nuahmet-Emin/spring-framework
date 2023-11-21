package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseControllerResponseEntity {

    private final CourseService courseService;


    public CourseControllerResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>>getAllCourse(){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable ("id") Long courseId){
        return ResponseEntity
                .ok(courseService.getCourseById(courseId));
               /* .status(HttpStatus.ACCEPTED)
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourseById(courseId));*/
    }
}
