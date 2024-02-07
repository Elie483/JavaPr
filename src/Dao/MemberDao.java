/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.*;
import Model1.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;


/**
 *
 * @author HP
 */
public class MemberDao {
    public List<Member> allMembers(){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query = "select * from memberstable";
            PreparedStatement pst = Con.prepareStatement(query);
            List<Member> members = new ArrayList<>();
            ResultSet result = pst.executeQuery();
            while(result.next()){
                Member allMembers = new Member();
                allMembers.setMemberName(result.getString("MName"));
                allMembers.setPhonenumber(result.getInt("MPhone"));
                allMembers.setAge(result.getInt("MAge"));
                allMembers.setAmount(result.getInt("MAmount"));
                allMembers.setCoach(result.getString("MCoach"));
                members.add(allMembers);
            }
            return members;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public Member searchMember(Member memberObj){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query = "select * from memberstable where MName = ?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, memberObj.getMemberName());
            ResultSet result = pst.executeQuery();
            Member singleMember = new Member();
            boolean flag = false;
            if(result.next()){
                singleMember.setMemberName(result.getString("MName"));
                singleMember.setPhonenumber(result.getInt("MPhone"));
                singleMember.setAge(result.getInt("MAge"));
                singleMember.setAmount(result.getInt("MAmount"));
                singleMember.setCoach(result.getString("MCoach"));
                flag = true;
            }
            Con.close();
            if(flag){
                return singleMember;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    public String delete(Member memberObj){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query= "delete from memberstable where  MName=?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setString(1, memberObj.getMemberName());
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
        public String update(Member memberObj){
        try{
            Connection Con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Trainingcenter_management_system_db","root","");
            String query= "update memberstable set MPhone=?, MAge=?, MAmount=?, MCoach =? where MName = ?";
            PreparedStatement pst = Con.prepareStatement(query);
            pst.setInt(1, memberObj.getPhonenumber());
            pst.setInt(2, memberObj.getAge());
            pst.setInt(3, memberObj.getAmount());
            pst.setString(4, memberObj.getCoach());
            pst.setString(5, memberObj.getMemberName());
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
