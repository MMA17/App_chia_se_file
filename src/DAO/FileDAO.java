/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Model.File;
import java.util.ArrayList;
/**
 *
 * @author Hoang Viet
 */
public class FileDAO extends DAO{
    // Tim tat ca cac file duoc nguoi dung tai len hoac duoc chia se
    public ArrayList<File> searchAllFilesOfUser(String user_id) {
        ArrayList<File> files = new ArrayList<File>();
        String query = 
                "SELECT tblfile.file_id, file_name, size, file_extension, readPermission, deletePermission "
                + "FROM tblpermission, tblfile "
                + "WHERE "
                + "(tblfile.owner = ? OR tblpermission.user_id = ?) "
                + "AND tblfile.file_id = tblpermission.file_id";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user_id);
            ps.setString(2, user_id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                File file = new File();
                file.setFile_id(rs.getInt(0));
                file.setFile_name(rs.getString(1));
                file.setSize(rs.getInt(2));
                file.setFile_extension(rs.getString(3));
                
                files.add(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }
    
    public boolean addFile() {
        return true;
    }
}
