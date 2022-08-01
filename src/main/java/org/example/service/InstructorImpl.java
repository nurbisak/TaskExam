package org.example.service;

import org.example.config.Config;
import org.example.dao.InstructorDao;
import org.example.entity.Instructor;
import org.example.impl.InstructorDaoImpl;

import javax.persistence.EntityManager;
import java.util.List;

public class InstructorImpl implements InstructorDao {
    InstructorDaoImpl instructorDao = new InstructorDaoImpl();

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorDao.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorDao.updateInstructor(id,instructor);

    }

    @Override
    public void getInstructorById(long id) {
        instructorDao.getInstructorById(id);

    }

    @Override
    public List<Instructor> getInstructorByCourseId(long id) {

        return instructorDao.getInstructorByCourseId(id);
    }

    @Override
    public void deleteInstructorById(long id) {
        instructorDao.deleteInstructorById(id);

    }

    @Override
    public void assignInstructorToCourse(long course_id, long instructor_id) {
        instructorDao.assignInstructorToCourse(course_id,instructor_id);
    }
}
