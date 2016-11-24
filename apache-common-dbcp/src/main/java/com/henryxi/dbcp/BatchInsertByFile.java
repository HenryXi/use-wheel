package com.henryxi.dbcp;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

//todo write a jdbc connection pool by myself
public class BatchInsertByFile {
    private static BasicDataSource dataSource = new BasicDataSource();

    public static void main(String[] args) throws Exception {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(130);
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db");
        dataSource.setDefaultAutoCommit(false);
        File file = new File("E:\\data\\www.csdn.net.sql");
        long start = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String[] data;
            List<User> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                data = line.split("#");
                list.add(new User(data[0].trim(), data[1].trim(), data[2].trim()));
                if (list.size() > 1000) {
                    try {
                        new BatchInsert(list, dataSource.getConnection()).start();
                    } catch (Exception e) {
                        System.out.println(list);
                        list = new ArrayList<>();
                        continue;
                    }
                    list = new ArrayList<>();
                }
            }
        }
        System.out.println("used: " + (System.currentTimeMillis() - start));
    }
}

class BatchInsert extends Thread {
    private List<User> list;
    private Connection conn;

    BatchInsert(List<User> list, Connection conn) {
        this.list = list;
        this.conn = conn;
    }

    @Override
    public void run() {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users (user_name,pwd,email) VALUES (?,?,?)");
            for (User user : list) {
                ps.setString(1, user.getName());
                ps.setString(2, user.getPwd());
                ps.setString(3, user.getEmail());
                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println(list);
        }
    }
}

class User {
    User(String name, String pwd, String email) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
    }

    private String name;
    private String pwd;
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}