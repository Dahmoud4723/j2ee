package com.dahmoud.dahmoudd.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dahmoud.dahmoudd.model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Tu peux ajouter ici des méthodes personnalisées si besoin, par exemple :
    // List<Event> findByTitleContaining(String keyword);
}

