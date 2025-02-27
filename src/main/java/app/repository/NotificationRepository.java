package app.repository;

import app.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, UUID> {


    @Query("""
            SELECT n FROM Notification n WHERE n.userId = :userId AND n.isDeleted = false
            """)
    List<Notification> findAllByUserIdAndDeletedIsFalse(@Param("userId") UUID userId);
}
