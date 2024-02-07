/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import Model1.Coach;
import java.sql.*;
import java.util.*;
/**
 *
 * @author HP
 */
public class CoachDao {
    public List<Coach> allCoach(){
        try{
           Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
           String query = "Select * from coachtable";
           PreparedStatement pst = Con.prepareStatement(query);
           ResultSet result = pst.executeQuery();
           List<Coach> singleCoach = new ArrayList<>();
           while(result.next()){
               Coach coach = new Coach();
               coach.setId(result.getInt("CId"));
               coach.setName(result.getString("CName"));
               coach.setPhone(result.getString("CPhone"));
               coach.setAge(result.getInt("CAge"));
               coach.setAddress(result.getString("CAddress"));
               coach.setGender(result.getString("CGender"));
               singleCoach.add(coach);
           }
           return singleCoach;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    public Coach searchMember(Coach coachObj){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query = "select * from coachtable where CName = ?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, coachObj.getName());
            ResultSet result = pst.executeQuery();
            Coach singleCoach = new Coach();
            boolean flag = false;
            if(result.next()){
                singleCoach.setName(result.getString("CName"));
                singleCoach.setPhone(result.getString("CPhone"));
                singleCoach.setAge(result.getInt("CAge"));
                singleCoach.setAddress(result.getString("CAddress"));
                flag = true;
            }
            Con.close();
            if(flag){
                return singleCoach;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
        public String delete(Coach coach){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query= "delete from coachtable where  CName=?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, coach.getName());
            int rows = pst.executeUpdate();
            if(rows > 0){
                return "Person deleted";
            }else{
                return "person not deleted";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String update(Coach coachObj){
          try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query= "update coachtable set CPhone=?, CAge=?, CAddress=? where CName=?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, coachObj.getPhone());
            pst.setInt(2, coachObj.getAge());
            pst.setString(3, coachObj.getAddress());
            pst.setString(4, coachObj.getName());
            int rows = pst.executeUpdate();
            if(rows > 0){
                return "Person updated";
            }else{
                return "person not updated";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
