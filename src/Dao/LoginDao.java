/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model1.User;
import java.sql.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class LoginDao {

    public String signUpPerson(User userObj){
        try{
           Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
           String query = "insert into userstable values(?, ?)";
           PreparedStatement st = Con.prepareStatement(query);
           st.setString(1, userObj.getUsername());
           st.setString(2, userObj.getPassword());
           int rows = st.executeUpdate();
           if(rows > 0){
               return "person registered successfully";
           }else{
               return "Error: ";
           }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String Login(User userObj){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingcenter_management_system_db","root","");
            String sql = "select * from userstable where UName=? and UPassword=?";
            PreparedStatement pst = Con.prepareStatement(sql);
            pst.setString(1, userObj.getUsername());
            pst.setString(2, userObj.getPassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return "Login successfully done";
            }else{
                return "Login failed";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
