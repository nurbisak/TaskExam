package org.example.impl;

import org.example.config.Config;
import org.example.dao.LessonDao;
import org.example.entity.Course;
import org.example.entity.Lesson;

import javax.persistence.EntityManager;
import java.util.List;

public class LessonDaoImpl implements LessonDao {
    private final EntityManager entityManager=Config.getEntityManager();
    @Override
    public void saveLesson(long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void updateLesson(long id) {
        entityManager.getTransaction().begin();
       Lesson lesson1= entityManager.find(Lesson.class,id);
       lesson1.setName(lesson1.getName());
       entityManager.getTransaction().commit();
       entityManager.close();
    }
    @Override
    public Lesson getLessonById(long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }
    @Override
    public void getLessonsByCourseId(long id) {
        entityManager.getTransaction().begin();
       Course course =entityManager.find(Course.class,id);
        List<Lesson>lessonList=course.getLesson();
        System.out.println(lessonList);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
