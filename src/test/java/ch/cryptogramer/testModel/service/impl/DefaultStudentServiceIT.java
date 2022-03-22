package ch.cryptogramer.testModel.service.impl;

import ch.cryptogramer.testModel.data.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DefaultStudentServiceIT {

    @Autowired
    private DefaultStudentService defaultStudentService;

    @Test
    void shouldCreateStudent() {
        // given
        StudentEntity studentEntity = StudentEntity.builder()
                .id(UUID.randomUUID())
                .birthDate(Instant.now())
                .build();

        // when
        StudentEntity result = defaultStudentService.createStudent(studentEntity);

        // then
        assertEquals(studentEntity.getId(), result.getId());
    }

    @Test
    void shouldGetStudent() {
        // given
        StudentEntity studentEntity = StudentEntity.builder()
                .id(UUID.randomUUID())
                .birthDate(Instant.now())
                .build();
        defaultStudentService.createStudent(studentEntity);

        // when
        StudentEntity result = defaultStudentService.getStudent(studentEntity.getId());

        // then
        assertEquals(studentEntity.getId(), result.getId());
        assertEquals(studentEntity.getBirthDate(), result.getBirthDate());
    }

    @Test
    void shouldDeleteStudent() {
        // given
        StudentEntity studentEntity = StudentEntity.builder()
                .id(UUID.randomUUID())
                .birthDate(Instant.now())
                .build();
        defaultStudentService.createStudent(studentEntity);

        // when
        defaultStudentService.delete(studentEntity.getId());

        StudentEntity result = defaultStudentService.getStudent(studentEntity.getId());

        // then
        assertNull(result);
    }
}