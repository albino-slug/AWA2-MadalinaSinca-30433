package awa.service;

import awa.model.Course;
import awa.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Boolean save(Course course) {
        try{
            courseRepo.save(course);
        }
        catch (Exception e){
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
                courseRepo.delete(id);
            }
            catch (Exception e) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> findByStartDate(Date date) {
        return courseRepo.findByStartDate(date);
    }

    @Override
    public Optional<Course> findByName(String name) {
        return courseRepo.findByName(name);
    }
}
