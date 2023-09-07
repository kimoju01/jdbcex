package com.study.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO {

    public String getTime() {

        String now = null;

        // try-with-resources를 이용해 자동 close() => try() 내의 변수들은 모두 Auto Closeable 인터페이스 구현한 타입이어야함.
        try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select now()"); // SQL을 DB로 미리 보내기
            ResultSet resultSet = preparedStatement.executeQuery(); // 쿼리 실행해서 반환된 데이터 resultSet에 넣기
            ) {

            resultSet.next();  // 첫 번째 행 데이터 읽을 수 있도록 이동한다.

            now = resultSet.getString(1);  // 1번째 열의 값을 String 타입으로 읽어들이기

        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;

    }

    // @Cleanup을 이용하는 코드
    public String getTime2() throws Exception {
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement("select now()");
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        String now = resultSet.getString(1);

        return now;
    }

}
