package com.sm.poc.controller;

import com.sm.poc.constant.SortBy;
import com.sm.poc.model.PageDecorator;
import com.sm.poc.model.Student;
import com.sm.poc.service.StudentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.UUID;

@OpenAPIDefinition(info = @Info(
        title = "Student API",
        version = "1.0.0",
        description = "Student service with MongoDB",
        contact = @Contact(
                name = "Sovan Mukherjee",
                email = "sovanm10@gmail.com")
))
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Save Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Save Student",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        return ResponseEntity.ok().body(studentService.save(student));
    }

    @Operation(summary = "Get Students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get Students",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<Student>> getStudentsByClassName(@RequestParam("className") String className,
                                                                @RequestParam(value ="page", defaultValue = "${pageable.default.value.page}") int page,
                                                                @RequestParam(value ="size", defaultValue = "${pageable.default.value.size}") int size,
                                                                @RequestParam(value = "sortBy", defaultValue = "${pageable.default.value.sortBy}") SortBy sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy.name()).ascending());
        return ResponseEntity.ok().body(studentService.getStudentsByClassName(className,pageable));
    }

    @Operation(summary = "Get Student Details")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Get Student details",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@RequestParam("id") UUID id) {
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @Operation(summary = "Delete Student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Delete Student details",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error",
                    content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@RequestParam("id") UUID id) {
        studentService.deleteById(id);
        return ResponseEntity.ok().body(id + "deleted successfully");
    }


    @Operation(summary = "Custom Pagination Get Students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Custom Pagination Get Students",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "500",
                    description = "Internal server Error",
                    content = @Content)
    })
    @GetMapping("/custom-pagination")
    public ResponseEntity<PageDecorator<Student>> getStudentsByClassNameWithCustomPagination(@RequestParam("className") String className,
                                                                                             @RequestParam(value ="page", defaultValue = "${pageable.default.value.page}") int page,
                                                                                             @RequestParam(value ="size", defaultValue = "${pageable.default.value.size}") int size,
                                                                                             @RequestParam(value = "sortBy", defaultValue = "${pageable.default.value.sortBy}") SortBy sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy.name()).ascending());
        return ResponseEntity.ok().body(studentService.getStudentsByClassNameWithCustomPagination(className,pageable));
    }

}
