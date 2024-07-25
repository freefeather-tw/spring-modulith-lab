package com.freefeather.modulith.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class NotificationDTO {

    private Date date;

    private String format;

    private String message;
}
