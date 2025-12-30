package com.rocketseat.service.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskNotificationSchedule {
    private final TaskService taskService;

    public TaskNotificationSchedule(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(fixedRate = 5000)
    public void checkAndNotifyTasks(){
        System.out.println("🔔 Verificando tarefas para notificação...");
        this.taskService.sendNotificationForDueTasks();
    }

}