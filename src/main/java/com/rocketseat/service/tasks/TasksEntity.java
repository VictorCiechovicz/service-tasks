package com.rocketseat.service.tasks;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "Task")
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String title;
    private LocalDateTime dueDate;
    private boolean notified;

    public TasksEntity(TaskRequest request) {
        this.title = request.email();
        this.email = request.email();
        this.dueDate = request.dueDate();
        this.notified = request.notified();
    }
}
