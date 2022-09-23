package com.sm.poc.repository;

import com.sm.poc.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.UUID;

public interface StudentRepository extends MongoRepository<Student, UUID> {

    @Query(fields="{'id' : 1, 'rollNumber' : 1,'contact' : 1,'vsningFlds' : 1}")
    Page<Student> findAllByClassName(String className, Pageable pageable);


}
