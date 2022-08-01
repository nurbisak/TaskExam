package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "video_link")
    private String videoLink;
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "lesson",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Task> taskList;


    public Lesson(String videoLink, String name) {
        this.videoLink = videoLink;
        this.name = name;

    }
    public void addTask(Task task) {
        this.taskList.add(task);
    }
    @Override
    public String toString() {
        return "\nLesson{" +
                "id=" + id +
                ", videoLink='" + videoLink + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
