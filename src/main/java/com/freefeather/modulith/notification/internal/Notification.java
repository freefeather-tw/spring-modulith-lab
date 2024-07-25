package com.freefeather.modulith.notification.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.management.ConstructorParameters;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Notification {

    private Date date;

    private NotificationType type;

    private String message;
}
