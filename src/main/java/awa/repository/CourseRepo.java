package awa.repository;

import awa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    Optional<Course> findByName(String name);
    Optional<Course> findByStartDate(Date date);
}
