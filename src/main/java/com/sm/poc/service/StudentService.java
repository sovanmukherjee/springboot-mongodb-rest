package com.sm.poc.service;

import com.sm.poc.model.PageDecorator;
import com.sm.poc.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface StudentService {
    String save(Student student);

    Page<Student> getStudentsByClassName(String className, Pageable pageable);

    PageDecorator<Student> getStudentsByClassNameWithCustomPagination(String className, Pageable pageable);

    Optional<Student> getStudentById(UUID id);

    void deleteById(UUID id);
}
