package com.example.courseapi.controller;

import com.example.courseapi.model.Course;
import com.example.courseapi.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        if (course.getTitle() == null || course.getTitle().isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid course data");
        }
        service.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body("Course added successfully");
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        Course course = service.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok(course);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        Course updated = service.updateCourse(id, course);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok("Course updated successfully");
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        boolean deleted = service.deleteCourse(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        return ResponseEntity.ok("Course deleted successfully");
    }

    // SEARCH
    @GetMapping("/search/{title}")
    public ResponseEntity<?> searchCourses(@PathVariable String title) {
        List<Course> result = service.searchByTitle(title);
        if (result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No courses found");
        }
        return ResponseEntity.ok(result);
    }
}