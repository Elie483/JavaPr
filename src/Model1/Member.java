/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model1;

/**
 *
 * @author HP
 */
public class Member {
    String memberName;
    int phonenumber;
    int age;
    int amount;
    String coach;

    public Member() {
    }

    public Member(String memberName, int phonenumber, int age, int amount, String coach) {
        this.memberName = memberName;
        this.phonenumber = phonenumber;
        this.age = age;
        this.amount = amount;
        this.coach = coach;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

   

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
