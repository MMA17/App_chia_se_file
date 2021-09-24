/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.con;
import Model.Group;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Tuan-user
 */
public class GroupDAO extends DAO {

    public boolean addUser(User user, Group group, String note) {
        String sql = "INSERT INTO tbljoingroup(note, user_id, group_id) VALUES(?, ?, ?)";
        boolean res = true;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, note);
            ps.setInt(2, user.getUser_id());
            ps.setInt(3, group.getGroup_id());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    public boolean delUser(User user, Group group) {
        String sql = "DELETE FROM tbljoininggroup WHERE user_id=? AND group_id=?";
        boolean res = true;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUser_id());
            ps.setInt(2, group.getGroup_id());
            ps.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

    public boolean delGroup(Group group) {
        String sql = "DELETE FROM tbljoininggroup WHERE group_id=?";
        boolean res = true;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, group.getGroup_id());
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
            res = false;
        }
        return res;
    }

//    public boolean createGroup()
}
