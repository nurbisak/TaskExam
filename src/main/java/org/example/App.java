package org.example;

import org.example.config.Config;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.service.CourseImpl;
import org.example.service.InstructorImpl;
import org.example.service.LessonImpl;
import org.example.service.TaskImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        //  Config.getEntityManager();
        CourseImpl course = new CourseImpl();
//         course.deleteCourseById(1L);

//         System.out.println(course.getCourseById(3L));
//         System.out.println(course.getAllCourse());
        //course.upDateCourse(3L,new Course("python","2012",LocalDate.now(),"https://peaksoft.talentlms.com/unit/view/id:5809","learning"));
       // course.saveCourse(new Course("soft_skills", "2017", (LocalDate.of(2017, 8, 23)), "www.community.kg", "relationship"));
        //course.saveCourse(new Course("java","2013",LocalDate.now(),"https://stackoverflow.com/questions/34409159/org-hibernate-exception-constraintviolationexception-could-not-execute-statemen","exception lesson"));
        //   course.saveCourse(new Course("softskills", "2012", LocalDate.of(2010, 07, 25), "www.facebook.kg", "community"));
//         course.deleteCourseById(4L);
//        System.out.println(course.getCourseByName("python"));
        TaskImpl task = new TaskImpl();
         task.saveTask(1L,new Task("For",LocalDate.ofYearDay(2021,1),"Do this exercise"));
        //  task.updateTask(1L, new Task("javacoding", LocalDate.now(), "tapshyrma bir kunduk"));
   // task.deleteTaskById(1L);
//        System.out.println(task.getAllTaskByLessonId(1L));

        LessonImpl lesson = new LessonImpl();
//         lesson.saveLesson(3L,new Lesson("https://www.youtube.com/watch?v=JR7-EdxDSf0","JDBC"));
//          System.out.println(lesson.getLessonById(1L));
//          lesson.getLessonsByCourseId(3L);
        InstructorImpl instructor = new InstructorImpl();
        //instructor.saveInstructor(new Instructor("Aijamal","Asangazieva","aija@gmail.com",777000555));
//         instructor.saveInstructor(new Instructor("Zamir","Sabyrjanov","zama@peaksoft.kg",123456789));
//          instructor.saveInstructor(new Instructor("Nurisa","Mamiraim kizi","nur_online@gmail.com",1234782));
//          instructor.updateInstructor(6L,new Instructor("Nurisa","Mamiraim kizi","nuronline@gmail.com",15678));
//        instructor.getInstructorById(6L);
//           instructor.assignInstructorToCourse(1L,6L);
        // instructor.assignInstructorToCourse(1L,2L);
//      instructor.deleteInstructorById(2L);
      //  System.out.println(instructor.getInstructorByCourseId(1L));


    }
}
