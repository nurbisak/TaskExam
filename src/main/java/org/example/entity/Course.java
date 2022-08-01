package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")
public class  Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "course_name")
    private String CourseName;
    private String duration;
    @Column(name = "create_at")
    private LocalDate createAt;
    private String imagineLink;
    private String description;

    public Course(String courseName, String duration, LocalDate creatAt, String imagineLink, String description) {
        CourseName = courseName;
        this.duration = duration;
        this.createAt = creatAt;
        this.imagineLink = imagineLink;
        this.description = description;
    }

    @ManyToMany(mappedBy = "courseList",cascade = {DETACH, MERGE, REFRESH}, fetch = FetchType.EAGER)
    private List<Instructor> instructorList;

    public void addInstructor(Instructor instructor) {
        instructor.getCourseList().add(this);
    }

    @OneToMany(cascade = ALL,mappedBy = "course")
    private List<Lesson> lesson;

    @Override
    public String toString() {
        return "\nCourse{" +
                "id=" + id +
                ", CourseName='" + CourseName + '\'' +
                ", duration='" + duration + '\'' +
                ", createAt=" + createAt +
                ", imagineLink='" + imagineLink + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
