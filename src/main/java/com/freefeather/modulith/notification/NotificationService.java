package com.freefeather.modulith.notification;

import com.freefeather.modulith.notification.internal.NotificationType;
import com.freefeather.modulith.notification.internal.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationService {

    @ApplicationModuleListener
    public void createNotification(NotificationDTO notificationDTO) {
        this.createNotification(new Notification(notificationDTO.getDate(), NotificationType.valueOf(notificationDTO.getFormat()), notificationDTO.getMessage()));
    }

    private void createNotification(Notification notification) {
        log.info("Creating notification for {} on {} via {}", notification.getMessage(), notification.getDate(), notification.getType());
    }
}
