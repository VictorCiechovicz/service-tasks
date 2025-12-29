package com.rocketseat.service.tasks;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification", url = "${notification.service.url:http://localhost:8081}")
public interface NotificationClient {
    @PostMapping("/notification")
    void sendNotification(@RequestBody NotificationRequest request);
}
