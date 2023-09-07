package com.study.dao;

import com.study.jdbcex.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodoDAOTests {
    private TodoDAO todoDAO;

    // ready()를 통해서 모든 테스트 전에 TodoDAO 타입의 객체를 생성하도록 함
    @BeforeEach
    public void ready() {
        todoDAO = new TodoDAO();
    }

    // testTime()을 이용해서 정상 작동 확인
    @Test
    public void testTime() throws Exception {
        System.out.println(todoDAO.getTime());
    }

}
