package ch.cryptogramer.testModel.controller;

import ch.cryptogramer.testModel.data.entity.StudentEntity;
import ch.cryptogramer.testModel.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class StudentControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void shouldCreateStudent() throws Exception {
        // given
        StudentEntity studentEntity = StudentEntity.builder()
                .id(UUID.randomUUID())
                .build();

        // when
        when(studentService.createStudent(any())).thenReturn(studentEntity);

        // then
        mockMvc.perform(post("/students")
                .content(asJsonString(studentEntity))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(studentService).createStudent(studentEntity);
    }

    @Test
    void shouldDeleteStudent() throws Exception {
        // given
        UUID id = UUID.randomUUID();

        doNothing().when(studentService).delete(any());

        // then
        mockMvc.perform(delete("/students/{id}", id))
                .andExpect(status().isOk());

        verify(studentService).delete(id);
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
