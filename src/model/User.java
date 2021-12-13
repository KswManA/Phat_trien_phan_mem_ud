/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author HuyLQ
 */
public class User implements Serializable{
    public String hoTen = "a";
    public String eMail;
    public int soDT;
    public String chucVu;
    public String passWord = "123";
    public User() {
    }

    public User(String hoTen, String eMail, int soDT, String chucVu) {
        this.hoTen = hoTen;
        this.eMail = eMail;
        this.soDT = soDT;
        this.chucVu = chucVu;
    }

    public User(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "User{" + "hoTen=" + hoTen + ", eMail=" + eMail + ", soDT=" + soDT + ", chucVu=" + chucVu + '}';
    }
    
}
