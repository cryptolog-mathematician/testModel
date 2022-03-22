package ch.cryptogramer.testModel.service;

import ch.cryptogramer.testModel.data.entity.StudentEntity;

import java.util.UUID;

public interface StudentService {

    StudentEntity createStudent(StudentEntity studentEntity);

    void delete(UUID id);

    StudentEntity getStudent(UUID id);
}
