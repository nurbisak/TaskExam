package org.example.dao;

import org.example.entity.Task;

import java.util.List;

public interface TaskDao {
   /**  6) Task:
            6.1) saveTask(), updateTask(), getAllTaskByLessonId(), deleteTaskById();
    */
   void saveTask(Long id,Task task);
   void updateTask(long id,Task task);
   List<Task> getAllTaskByLessonId(long id);
   void deleteTaskById(long id);
}
