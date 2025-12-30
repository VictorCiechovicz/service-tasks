package com.rocketseat.service.tasks;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private NotificationClient notificationClient;
    private TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository, NotificationClient notificationClient) {
        this.tasksRepository = tasksRepository;
        this.notificationClient = notificationClient;
    }

    public void sendNotificationForDueTasks(){
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TasksEntity> tasks = tasksRepository.findTasksDueWithinDeadline(deadline);
        System.out.println("📋 Tarefas encontradas para notificar: " + tasks.size());
        
        for (TasksEntity task : tasks){
            try {
                NotificationRequest request = new NotificationRequest(
                    "Sua tarefa: " + task.getTitle() + " está prestes a vencer", 
                    task.getEmail()
                );
                System.out.println("📤 Enviando notificação para: " + task.getEmail() + " - Tarefa: " + task.getTitle());
                notificationClient.sendNotification(request);
                task.setNotified(true);
                tasksRepository.save(task);
                System.out.println("✅ Notificação enviada com sucesso!");
            } catch (Exception e) {
                System.out.println("❌ Erro ao enviar notificação: " + e.getMessage());
            }
        }
    }
}
