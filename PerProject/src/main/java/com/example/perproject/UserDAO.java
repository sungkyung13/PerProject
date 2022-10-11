package com.example.perproject;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class UserDAO {
    public void getUsers() {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE id LIKE 'login%'";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String uid = rs.getString("uid");
                String id = rs.getString("id");
                String pw = rs.getString("pw");
                String name = rs.getString("name");
                System.out.println("uid=" + uid + "/ id=" + id + "/ pw=" + pw + "/ name =" + name);
            }
            System.out.println("조회 성공!!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("조회 실패!!");

        }
    }

    public void insertUsers() {
        DBUtil db = new DBUtil();
        Connection conn = db.getConnection();

        PreparedStatement pstmt = null;
        Random random = new Random();
        int num = random.nextInt(100);
        String sql = "INSERT INTO users(id, pw, name) VALUES('login" + num + "', 'soft', '양영디지털고등학교')";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();
            System.out.println("삽입 성공!!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("삽입 실패!!");
        }

    }

}
