package app.service;

import app.model.NotificationPreference;
import app.repository.NotificationPreferenceRepository;
import app.repository.NotificationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailSender;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceUTest {

    @Mock
    private NotificationPreferenceRepository preferenceRepository;
    @Mock
    private NotificationRepository notificationRepository;
    @Mock
    private MailSender mailSender;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    void givenNotExistingNotificationPreference_whenChangeNotificationPreference_thenExpectException(){

        // Given
        UUID userId = UUID.randomUUID();
        boolean isNotificationEnabled = true;
        when(preferenceRepository.findByUserId(userId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(NullPointerException.class, () -> notificationService.changeNotificationPreference(userId, isNotificationEnabled));
    }

    @Test
    void givenExistingNotificationPreference_whenChangeNotificationPreference_thenExpectEnabledToBeChanged(){

        // Given
        UUID userId = UUID.randomUUID();
        NotificationPreference preference = NotificationPreference.builder()
                .enabled(false)
                .build();
        when(preferenceRepository.findByUserId(userId)).thenReturn(Optional.of(preference));

        // When
        notificationService.changeNotificationPreference(userId, true);

        // Then
        assertTrue(preference.isEnabled());
        verify(preferenceRepository, times(1)).save(preference);
    }

}
