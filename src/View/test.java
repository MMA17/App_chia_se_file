/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import DAO.FileDAO;
import DAO.UserDAO;
import Model.User;
import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Hoang Viet
 */
public class test{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ArrayList<User> users = (new UserDAO()).searchUserByName("hoangviet1");
//        if (users.size() == 0) {
//            System.out.println("Khong co user nao");
//        }
//        else {
//            System.out.println(users.get(0).getName());
//        }
          boolean check = (new FileDAO()).deleteFile(4);
          System.out.println(check);    
    }
}
