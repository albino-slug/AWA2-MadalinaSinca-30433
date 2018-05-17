package awa.service;

import awa.model.Event;
import awa.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepo eventRepo;

    @Override
    public List<Event> findAll() {
        return eventRepo.findAll();
    }

    @Override
    public Boolean save(Event event) {
        try{
            eventRepo.save(event);
        }
        catch (Exception e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (id.intValue() < 0){
            return Boolean.FALSE;
        }
        else {
            try {
                eventRepo.deleteById(id);
            }
            catch (Exception e) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Optional<Event> findById(Integer id) {
        return eventRepo.findById(id);
    }

    @Override
    public List<Event> findByDate(Date date) {
        return eventRepo.findByDate(date);
    }

    @Override
    public List<Event> findByName(String name) {
        return eventRepo.findByName(name);
    }
}
