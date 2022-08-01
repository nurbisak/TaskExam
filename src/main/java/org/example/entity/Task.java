package org.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "deadline")
    private LocalDate deadLine;
    private String task;


    public Task(String name, LocalDate deadLine, String task) {
        this.name = name;
        this.deadLine = deadLine;
        this.task = task;
    }
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}
            ,fetch = FetchType.LAZY)
    private Lesson lesson;

    @Override
    public String toString() {
        return "\nTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadLine='" + deadLine + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
