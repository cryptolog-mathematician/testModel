package ch.cryptogramer.testModel.service.impl;

import ch.cryptogramer.testModel.data.entity.StudentEntity;
import ch.cryptogramer.testModel.data.repository.StudentRepository;
import ch.cryptogramer.testModel.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DefaultStudentService implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    @Override
    public void delete(UUID id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity getStudent(UUID id) {
        Optional<StudentEntity> studentWrapper = studentRepository.findById(id);
        return studentWrapper.orElse(null);
    }
}
