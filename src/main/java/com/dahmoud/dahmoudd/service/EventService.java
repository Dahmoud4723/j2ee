package com.dahmoud.dahmoudd.service;



import com.dahmoud.dahmoudd.model.Event;
import com.dahmoud.dahmoudd.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Créer un nouvel événement
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    // Récupérer tous les événements
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Récupérer un événement par son ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Mettre à jour un événement
    public Event updateEvent(Long id, Event updatedEvent) {
        if (eventRepository.existsById(id)) {
            updatedEvent.setId(id);
            return eventRepository.save(updatedEvent);
        }
        return null; // ou lever une exception
    }

    // Supprimer un événement
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}

