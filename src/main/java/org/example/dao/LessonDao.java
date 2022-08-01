package org.example.dao;

import org.example.entity.Lesson;

import java.util.List;

public interface LessonDao {
    /**  5) Lesson:
     5.1) Lesson да saveLesson()(Lesson сакталып жатканда кандайдыр бир курска сакталуусу керек),
     updateLesson(),
     getLessonById(),
     getLessonsByCourseId()(курска тиешелуу сабактарды чыгаруу);
     */
    void saveLesson(long id, Lesson lesson);
    void updateLesson(long id);
    Lesson getLessonById(long id);
    void getLessonsByCourseId(long id);
}
