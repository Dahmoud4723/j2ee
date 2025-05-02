package com.dahmoud.dahmoudd.service;

import com.dahmoud.dahmoudd.model.Participant;
import com.dahmoud.dahmoudd.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    // Méthode pour rechercher un participant par email et nom
    public Optional<Participant> findByEmailAndName(String email, String name) {
        return participantRepository.findByEmailAndName(email, name);
    }

    // Méthode pour récupérer tous les participants
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Méthode pour récupérer un participant par son ID
    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    // Méthode pour enregistrer un nouveau participant
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }
}
