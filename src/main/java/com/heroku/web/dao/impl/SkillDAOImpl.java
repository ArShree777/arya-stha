/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.dao.impl;

import com.heroku.web.dao.SkillDAO;
import com.heroku.web.entity.Skill;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aryas
 */
public class SkillDAOImpl implements SkillDAO {

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://ec2-54-243-150-10.compute-1.amazonaws.com/d5t4o9s8al8sif?sslmode=require";
            String user = "kcgffwauavsznk";
            String pass = "85850f06967e2d8a62b834233ecfd20869f864f08f0af0f95d42921f2fe58330";
            Connection conn = DriverManager.getConnection(url,
                    user, pass);
            /*  String sql = "insert into skills(skill_name)"
             + "values('Programming22')";*/
            String sql = "select * from skills";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("skill_name"));
                skills.add(skill);

            }

            conn.close();
            return skills;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
