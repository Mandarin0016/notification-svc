package app.event;

import app.event.payload.UserRegisteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsedRegisteredEventConsumer {

    @KafkaListener(topics = "user-registered-event.v1", groupId = "notification-svc")
    public void consumeEvent(UserRegisteredEvent event) {

        log.info("Successfully consumed registered event for user [%s]".formatted(event.getUserId()));
    }
}
