package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(unique = true)
    private String email;
    private int phoneNumber;

    @ManyToMany( cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    private List<Course> courseList;

    public Instructor(String firstName, String lastName, String email, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public void addCourse(Course course) {
        if (courseList==null) {
            courseList = new ArrayList<>();
        }
        course.getInstructorList().add(this);
    }

    @Override
    public String toString() {
        return "\nInstructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';

    }
}