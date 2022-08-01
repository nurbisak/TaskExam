package org.example.service;

import org.example.dao.LessonDao;
import org.example.entity.Lesson;
import org.example.impl.LessonDaoImpl;

import java.util.List;

public class LessonImpl implements LessonDao {
    LessonDaoImpl lessonDao =new LessonDaoImpl();
    @Override
    public void saveLesson(long id, Lesson lesson) {
        lessonDao.saveLesson(id, lesson);

    }
    @Override
    public void updateLesson(long id) {
        lessonDao.updateLesson(id);

    }
    @Override
    public Lesson getLessonById(long id) {
        return  lessonDao.getLessonById(id);

    }
    @Override
    public void getLessonsByCourseId(long id) {
       lessonDao.getLessonsByCourseId(id);

    }
}
