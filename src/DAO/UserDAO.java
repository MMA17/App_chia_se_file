/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Hoang Viet
 */
public class UserDAO extends DAO{
         
        public ArrayList<User> searchAllUser() {
            ArrayList<User> res = new ArrayList<User>();
            String query = "SELECT * FROM tblUser";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                //System.out.println(rs);
                while (rs.next()) {
                    User user = new User();
                    user.setUser_id(rs.getInt("user_id"));
                    user.setUser_name(rs.getString("user_name"));
                    user.setPass(rs.getString("pass"));
                    user.setName(rs.getString("name"));
                    user.setUsaged(rs.getInt("usaged"));
                    user.setTel(rs.getString("tel"));
                    user.setNote(rs.getString("note"));
                    
                    res.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        }

        public ArrayList<User> searchUserByName(String username) {
            ArrayList<User> res = new ArrayList<User>();
            String query = "SELECT * FROM tblUser WHERE user_name = ?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                username = username.trim();
                ps.setString(1, username);
                ResultSet rs = ps.executeQuery();
                //System.out.println(rs);
                while (rs.next()) {
                    User user = new User();
                    user.setUser_id(rs.getInt("user_id"));
                    user.setUser_name(rs.getString("user_name"));
                    user.setPass(rs.getString("pass"));
                    user.setName(rs.getString("name"));
                    user.setUsaged(rs.getInt("usaged"));
                    user.setTel(rs.getString("tel"));
                    user.setNote(rs.getString("note"));
                    
                    res.add(user);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        }
        
        public boolean checkLogin(String username, String pass) {
            ArrayList<User> res = new ArrayList<User>();
            String query = "SELECT * FROM tblUser WHERE user_name = ? AND pass = ?";
            int count = 0;
            try {
                PreparedStatement ps = con.prepareStatement(query);
                username = username.trim();
                ps.setString(1, username);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(count);
            if (count > 0) {
                return true;
            }
            return false;
        }
}
