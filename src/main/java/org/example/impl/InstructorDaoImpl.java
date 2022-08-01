package org.example.impl;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    private final EntityManager entityManager = Config.getEntityManager();


    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void getInstructorById(long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class,id);
        System.out.println(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("got id");
    }

    @Override
    public List<Instructor> getInstructorByCourseId(long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class,id);
        List<Instructor>instructors=course.getInstructorList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;

    }

    @Override
    public void deleteInstructorById(long id) {
        entityManager.getTransaction().begin();
        Instructor instructor= entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void assignInstructorToCourse(long course_id, long instructor_id) {
        entityManager.getTransaction().begin();
        Instructor instructor =entityManager.find(Instructor.class,instructor_id);
        Course course =entityManager.find(Course.class,course_id);
        course.addInstructor(instructor);
        instructor.addCourse(course);
//       entityManager.persist(course);
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
