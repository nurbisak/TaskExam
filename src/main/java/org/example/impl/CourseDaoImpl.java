package org.example.impl;

import org.example.config.Config;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final EntityManager entityManager = Config.getEntityManager();

    @Override

    public String saveCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Saved");
        } catch (HibernateException r) {
            r.getMessage();
        }
        return null;
    }

    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public Course getCourseById(long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public void upDateCourse(long id,Course course) {
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCreateAt(course.getCreateAt());
        course1.setDescription(course.getDescription());
        course1.setImagineLink(course.getImagineLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("update");

    }

    @Override
    public void deleteCourseById(long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        for (Instructor i : course.getInstructorList()) {
            i.setCourseList(null);
        }
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("deleted");


    }

    @Override
    public Course getCourseByName(String name) {

                EntityManager entityManager = Config.getEntityManager();
                entityManager.getTransaction().begin();
                Course course = entityManager
                        .createQuery("select c from Course c where c.CourseName= :cName", Course.class)
                        .setParameter("cName", name).getSingleResult();
                entityManager.getTransaction().commit();
                entityManager.close();
                return course;
            }
        }
/**
    public Course getCourseByName(String courseName) {
        try {
            EntityManager entityManager = Config.getEntityManager();
            entityManager.getTransaction().begin();
            Course course = entityManager
                    .createQuery("select c from Course c where c.courseName= :cName",Course.class)
                    .setParameter("cName",courseName).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return course;
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
 */