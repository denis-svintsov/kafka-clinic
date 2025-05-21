package org.example.repository;

import org.example.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {

    List<AppointmentEntity> findByClientPhone(String phone);

    long countByAppointmentDateAfter(LocalDateTime dateTime);

    long countByVisitedIsTrueAndAppointmentDateBetween(LocalDateTime start, LocalDateTime end);

    @Query("SELECT COALESCE(SUM(a.amount), 0) FROM AppointmentEntity a " +
            "WHERE a.visited = true AND a.appointmentDate >= :start AND a.appointmentDate < :end")
    Double sumVisitedAmountForDateRange(@Param("start") LocalDateTime start,
                                        @Param("end") LocalDateTime end);

    @Query("SELECT COALESCE(SUM(a.amount), 0) FROM AppointmentEntity a " +
            "WHERE a.client.phone = :phone AND a.visited = true")
    Double sumAmountForClientWithVisitedTrue(@Param("phone") String phone);

    @Modifying
    @Transactional
    @Query("UPDATE AppointmentEntity a SET a.visited = true WHERE a.id = :id")
    int confirmAppointment(@Param("id") Long id);
}
