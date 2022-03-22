package ch.cryptogramer.testModel.service.impl;

import ch.cryptogramer.testModel.data.entity.StudentEntity;
import ch.cryptogramer.testModel.data.repository.StudentRepository;
import ch.cryptogramer.testModel.service.impl.DefaultStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultStudentServiceTest {

    @InjectMocks
    private DefaultStudentService testee;

    @Mock
    private StudentRepository studentRepositoryMock;

    @Test
    void shouldCreateStudent() {
        // given
        StudentEntity studentEntity = StudentEntity.builder()
                .id(UUID.randomUUID())
                .birthDate(Instant.now())
                .build();

        when(studentRepositoryMock.save(any())).thenReturn(studentEntity);

        // when
        StudentEntity result = testee.createStudent(studentEntity);

        // then
        assertEquals(studentEntity.getId(), result.getId());
    }
}
