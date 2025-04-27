package com.dahmoud.dahmoudd.repository;

import com.dahmoud.dahmoudd.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    // Méthode pour récupérer les inscriptions par ID d'événement
    List<Registration> findByEventId(Long eventId);

    // Méthode pour récupérer les inscriptions par ID de participant
    List<Registration> findByParticipantId(Long participantId);

    // Méthode pour récupérer une inscription par participant et événement
    Optional<Registration> findByParticipantIdAndEventId(Long participantId, Long eventId);
}
