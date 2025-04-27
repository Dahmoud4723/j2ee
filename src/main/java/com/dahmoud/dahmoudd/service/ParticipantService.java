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

    // Créer un nouveau participant
    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    // Récupérer tous les participants
    public List<Participant> getAllParticipants() {
        return participantRepository.findAll();
    }

    // Récupérer un participant par son ID
    public Optional<Participant> getParticipantById(Long id) {
        return participantRepository.findById(id);
    }

    // Récupérer un participant par son email
    public Optional<Participant> getParticipantByEmail(String email) {
        return participantRepository.findByEmail(email);
    }

    // Mettre à jour un participant
    public Participant updateParticipant(Long id, Participant updatedParticipant) {
        if (participantRepository.existsById(id)) {
            updatedParticipant.setId(id);
            return participantRepository.save(updatedParticipant);
        }
        return null; // ou lever une exception personnalisée
    }

    // Supprimer un participant
    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
