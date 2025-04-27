package com.dahmoud.dahmoudd.service;

import com.dahmoud.dahmoudd.model.Event;
import com.dahmoud.dahmoudd.model.Participant;
import com.dahmoud.dahmoudd.model.Registration;
import com.dahmoud.dahmoudd.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private EventService eventService;

    // Inscrire un participant à un événement
    public Registration registerParticipant(Long participantId, Long eventId) {
        Participant participant = participantService.getParticipantById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found"));
        Event event = eventService.getEventById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Registration registration = new Registration();
        registration.setParticipant(participant);
        registration.setEvent(event);

        return registrationRepository.save(registration);
    }

    // Récupérer toutes les inscriptions d'un événement
    public List<Registration> getRegistrationsByEvent(Long eventId) {
        return registrationRepository.findByEventId(eventId); // Tu peux définir cette méthode dans le repository
    }

    // Récupérer toutes les inscriptions d'un participant
    public List<Registration> getRegistrationsByParticipant(Long participantId) {
        return registrationRepository.findByParticipantId(participantId); // Tu peux définir cette méthode dans le
                                                                          // repository
    }

    // Supprimer une inscription
    public void cancelRegistration(Long participantId, Long eventId) {
        Registration registration = registrationRepository.findByParticipantIdAndEventId(participantId, eventId)
                .orElseThrow(() -> new IllegalArgumentException("Registration not found"));
        registrationRepository.delete(registration);
    }
}
