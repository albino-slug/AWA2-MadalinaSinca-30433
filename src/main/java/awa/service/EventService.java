package awa.service;

import awa.model.Event;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventService {
    public List<Event> findAll();

    public void save(Event event);

    public void deleteById(Integer id);

    public Optional<Event> findById(Integer id);

    public Optional<Event> findByDate(Date date);

    public Optional<Event> findByName(String name);
}
