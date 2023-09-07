package com.study.service;

import com.study.jdbcex.TodoDTO;
import com.study.jdbcex.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TodoServiceTests {

    private TodoService todoService;

    @BeforeEach
    public void ready() {
        todoService = TodoService.INSTANCE;
    }

    @Test
    public void testRegister() throws Exception {

        TodoDTO todoDTO = TodoDTO.builder()
                        .title("JDBC Test Title")
                        .dueDate(LocalDate.now())
                        .build();

        todoService.register(todoDTO);
    }

}
