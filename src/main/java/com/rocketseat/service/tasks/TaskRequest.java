package com.rocketseat.service.tasks;

import java.time.LocalDateTime;

public record TaskRequest(String email,String title,LocalDateTime dueDate,Boolean notified) {
}
