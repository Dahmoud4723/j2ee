package com.dahmoud.dahmoudd.repository;



import com.dahmoud.dahmoudd.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    // Méthode pour trouver un participant par email
    Optional<Participant> findByEmailAndName(String email, String name);

}
