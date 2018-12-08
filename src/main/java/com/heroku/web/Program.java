/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aryas
 */
public class Program {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://ec2-54-243-150-10.compute-1.amazonaws.com/d5t4o9s8al8sif?sslmode=require";
            String user="kcgffwauavsznk";
            String pass="85850f06967e2d8a62b834233ecfd20869f864f08f0af0f95d42921f2fe58330";
            Connection conn = DriverManager.getConnection(url,
                    user, pass);
          /*  String sql = "insert into skills(skill_name)"
             + "values('Programming22')";*/
            String sql = "select * from skills";
            PreparedStatement stmt = conn.prepareStatement(sql);
      ResultSet rs=stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("skill_name"));
            }
            conn.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
