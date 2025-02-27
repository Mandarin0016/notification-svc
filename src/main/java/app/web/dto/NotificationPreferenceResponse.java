package app.web.dto;

import app.model.NotificationType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class NotificationPreferenceResponse {

    private UUID id;

    private UUID userId;

    private NotificationType type;

    private boolean enabled;

    private String contactInfo;
}
