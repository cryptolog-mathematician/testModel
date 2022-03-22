package ch.cryptogramer.testModel.controller;

import ch.cryptogramer.testModel.data.entity.StudentEntity;
import ch.cryptogramer.testModel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(produces = { "application/json" })
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity) {
        return ResponseEntity.ok(studentService.createStudent(studentEntity));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable UUID id) {
        studentService.delete(id);
    }
}
