package awa.service;

import awa.model.Course;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    public List<Course> findAll();

    public Boolean save(Course course);

    public Boolean deleteById(Integer id);

    public Optional<Course> findById(Integer id);

    public List<Course> findByStartDate(Date date);

    public Optional<Course> findByName(String name);
}
