package org.example.dao;

import org.example.entity.Instructor;

import java.util.List;

public interface  InstructorDao {
    /**
    4) Instructor:
            4.1) Инструктордо saveInstructor(), updateInstructor(), getInstructorById(),
     getInstructorByCourseId()(тиешелуу курстун инструкторлорун чыгарып беруу),
     deleteInstructorById()(инструктор очкондо, инструкторго тиешелуу курс очпошу керек),
     assignInstructorToCourse()(инструкторду курска кошуп коюу(назначить)).

     */
    void saveInstructor(Instructor instructor);
    void updateInstructor(Long id, Instructor instructor);
    void getInstructorById(long id);
    List<Instructor> getInstructorByCourseId(long id);
    void deleteInstructorById(long id);
    void assignInstructorToCourse(long course_id,long instructor_id);




}
