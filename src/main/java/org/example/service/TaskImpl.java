package org.example.service;

import org.example.dao.TaskDao;
import org.example.entity.Task;
import org.example.impl.TaskDaoImpl;

import java.util.List;

public class TaskImpl implements TaskDao {
    TaskDao taskDao =new TaskDaoImpl();
    @Override
    public void saveTask(Long id, Task task) {
        taskDao.saveTask(id,task);
    }

    @Override
    public void updateTask(long id, Task task) {
        taskDao.updateTask(id,task);

    }

    @Override
    public List<Task> getAllTaskByLessonId(long id) {
        return taskDao.getAllTaskByLessonId(id);

    }

    @Override
    public void deleteTaskById(long id) {
        taskDao.deleteTaskById(id);

    }
}
