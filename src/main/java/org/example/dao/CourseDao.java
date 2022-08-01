package org.example.dao;

import org.example.config.Config;
import org.example.entity.Course;

import javax.persistence.EntityManager;
import java.util.List;

public interface CourseDao {
    String  saveCourse(Course course);



    List<Course> getAllCourse();

    Course getCourseById(long id);

    void upDateCourse(long id,Course course);

    void deleteCourseById(long id);

    Course getCourseByName(String name);

}
