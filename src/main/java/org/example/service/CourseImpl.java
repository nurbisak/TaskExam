package org.example.service;

import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.example.impl.CourseDaoImpl;

import java.util.List;

public class CourseImpl implements CourseDao {
CourseDaoImpl courseDao = new CourseDaoImpl();

    @Override
    public String saveCourse(Course course) {
        return courseDao.saveCourse(course);

    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();


    }

    @Override
    public Course getCourseById(long id) {
        return courseDao.getCourseById(id);
    }

    @Override
    public void upDateCourse(long id,Course course) {
        courseDao.upDateCourse(id,course);

    }

    @Override
    public void deleteCourseById(long id) {
        courseDao.deleteCourseById(id);

    }

    @Override
    public Course getCourseByName(String name) {
        return courseDao.getCourseByName(name);
    }
}
