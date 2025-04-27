package com.dahmoud.dahmoudd.controller;

import com.dahmoud.dahmoudd.model.Registration;
import com.dahmoud.dahmoudd.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // Inscrire un participant à un événement
    @PostMapping
    public ResponseEntity<Registration> registerParticipant(@RequestParam Long participantId, @RequestParam Long eventId) {
        Registration registration = registrationService.registerParticipant(participantId, eventId);
        return new ResponseEntity<>(registration, HttpStatus.CREATED);
    }

    // Récupérer toutes les inscriptions d'un événement
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<Registration>> getRegistrationsByEvent(@PathVariable Long eventId) {
        List<Registration> registrations = registrationService.getRegistrationsByEvent(eventId);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    // Récupérer toutes les inscriptions d'un participant
    @GetMapping("/participant/{participantId}")
    public ResponseEntity<List<Registration>> getRegistrationsByParticipant(@PathVariable Long participantId) {
        List<Registration> registrations = registrationService.getRegistrationsByParticipant(participantId);
        return new ResponseEntity<>(registrations, HttpStatus.OK);
    }

    // Annuler une inscription
    @DeleteMapping
    public ResponseEntity<Void> cancelRegistration(@RequestParam Long participantId, @RequestParam Long eventId) {
        registrationService.cancelRegistration(participantId, eventId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
