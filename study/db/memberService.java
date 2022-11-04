package study.db;

import java.sql.*;

public class memberService {


    public void dbSelect(){
        //        5가지 있어야함.
//        1. ip(domain) , 2. port , 3. 계정 , 4. password , 5. instance

        String url = "jdbc:mariadb://192.168.64.3:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

//        1. 드라이버 로드
//        2. 커넥션 객체 생성
//        3. 스테이트먼트 객체 생성
//        4. 쿼리 실행
//        5. 결과 수행
//        6. 객체 연결 해제(close)

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        //email, kakao, facebook

        String memberTypeValue = "email";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " select member_type, user_id, password, name " +
                    " from member " +
                    " where member_type = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberTypeValue);

            rs = preparedStatement.executeQuery();

            while(rs.next()){
                String memberType = rs.getString("member_type");
                String userId = rs.getString("user_id");
                String password = rs.getString("password");
                String name = rs.getString("name");

                System.out.println(memberType + ", " + userId + ", " + password + ", " + name);


            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    /**
     * 회원 가입 함수
     * @param member 회원정보
     */
    public void register(Member member){
//        1. ip(domain) , 2. port , 3. 계정 , 4. password , 5. instance

        String url = "jdbc:mariadb://192.168.64.3:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;



        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " Insert INTO member(member_type, user_id, password, name) " +
                    "value (?, ?, ?, ?); ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());
            preparedStatement.setString(3, member.getPassword());
            preparedStatement.setString(4, member.getName());

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 저장 성공 ");
            }else{
                System.out.println(" 저장 실패 ");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void dbUpdate(){
//        1. ip(domain) , 2. port , 3. 계정 , 4. password , 5. instance

        String url = "jdbc:mariadb://192.168.64.3:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;



        String memberTypeValue = "email";
        String userIdValue = "zerobase@naver.com";
        String passwordValue = "9999";

        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = " update member set " +
                    " password = ? " +
                    "where member_type = ? and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, passwordValue);
            preparedStatement.setString(2, memberTypeValue);
            preparedStatement.setString(3, userIdValue);

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 수정 성공 ");
            }else{
                System.out.println(" 수정 실패 ");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

    /**
     * 회원 탈퇴 함수
     */
    public void withdraw(Member member){
//        1. ip(domain) , 2. port , 3. 계정 , 4. password , 5. instance

        String url = "jdbc:mariadb://192.168.64.3:3306/testdb1";
        String dbUserId = "testuser1";
        String dbPassword = "zerobase";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;



        try {
            connection = DriverManager.getConnection(url, dbUserId, dbPassword);

            String sql = "delete from member " +
                    "where member_type = ? and user_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, member.getMemberType());
            preparedStatement.setString(2, member.getUserId());

            int affected = preparedStatement.executeUpdate();

            if(affected > 0){
                System.out.println(" 삭제 성공 ");
            }else{
                System.out.println(" 삭제 실패 ");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(preparedStatement != null && !preparedStatement.isClosed()){
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(rs != null && !connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
