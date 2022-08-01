package org.example.impl;

import org.example.config.Config;
import org.example.dao.TaskDao;
import org.example.entity.Lesson;
import org.example.entity.Task;

import javax.persistence.EntityManager;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
    private final EntityManager entityManager = Config.getEntityManager();
    @Override
    public void saveTask(Long id, Task task) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        lesson.addTask(task);
        task.setLesson(lesson);
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        System.out.println("Successfully saved");
        entityManager.close();
    }

    @Override
    public void updateTask(long id, Task task) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setName(task.getName());
        task1.setDeadLine(task.getDeadLine());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public List<Task> getAllTaskByLessonId(long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        List<Task> tasks = lesson.getTaskList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return tasks;

    }

    @Override
    public void deleteTaskById(long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        task.setLesson(null);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
