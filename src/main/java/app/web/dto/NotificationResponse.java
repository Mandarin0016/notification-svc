package app.web.dto;

import app.model.NotificationStatus;
import app.model.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationResponse {

    private String subject;

    private LocalDateTime createdOn;

    private NotificationStatus status;

    private NotificationType type;
}