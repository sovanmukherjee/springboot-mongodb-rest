package com.sm.poc.service.impl;

import com.sm.poc.model.PageDecorator;
import com.sm.poc.model.Student;
import com.sm.poc.model.VersioningFields;
import com.sm.poc.repository.CustomPaginationRepository;
import com.sm.poc.repository.StudentRepository;
import com.sm.poc.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CustomPaginationRepository customPaginationRepository;

    @Override
    public String save(Student student) {
        if (Objects.isNull(student.getId())) {
            student.setId(UUID.randomUUID());
        }
        student.setVsningFlds(updateVersioningFields(student.getVsningFlds()));
        try {
            return studentRepository.save(student).getId().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return StringUtils.EMPTY;
    }

    @Override
    public Page<Student> getStudentsByClassName(String className, Pageable pageable) {
        return studentRepository.findAllByClassName(className,pageable);
    }

    @Override
    public PageDecorator<Student> getStudentsByClassNameWithCustomPagination(String className, Pageable pageable) {
        return new PageDecorator<>(customPaginationRepository.findAllByClassName(className,pageable));
    }

    @Override
    public Optional<Student> getStudentById(UUID id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(UUID id) {
        studentRepository.deleteById(id);
    }


    private static VersioningFields updateVersioningFields(final VersioningFields versioningFieldsEntity) {
        if (Objects.isNull(versioningFieldsEntity)) {
            return VersioningFields.builder().createdBy("abc").crTime(LocalDateTime.now()).build();
        } else {
            versioningFieldsEntity.setMdTime(LocalDateTime.now());
            versioningFieldsEntity.setUpdatedBy("def");
            return versioningFieldsEntity;
        }
    }


}
