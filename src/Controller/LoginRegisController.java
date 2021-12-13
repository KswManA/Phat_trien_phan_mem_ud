/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Register_View;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author HuyLQ
 */
public class LoginRegisController extends JDBCConnection{

    //Regis
    User uModal;
    Register_View regView;

    public LoginRegisController() {
        super();
    }

    public LoginRegisController(Register_View regView) {
        this.regView = regView;
    }

    public boolean Regis(String hoTen, String PassWord) {
           //thêm thông tin vào trong db
           String sql = "insert into nguoimuon" + "value (?,?)";
           try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hoTen);
            ps.setString(2, PassWord);
            
            return ps.executeUpdate()> 0;
            
        } catch (Exception e) {
        }
        return false;    
    }
    
    public ArrayList<User> getListUser(){
        ArrayList<User> listUser = new ArrayList<>();
        
        String sql = "select TenTK, MK from nguoimuon";
        try {
            con = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                User user = new User();
                user.setHoTen(rs.getString("TenTK"));
                user.setPassWord(rs.getString("MK"));
                
                listUser.add(user);
            }
        } catch (Exception e) {
        }
        return listUser;
    }
    
    public void Login(){
        try {
            //query data trong db rồi set vào modal
            String sql = "select TenTK, MK from nguoimuon where TenTK = ? and MK = ?";
            try {
                PreparedStatement ps = con.prepareCall(sql);
                ps.setString(1, uModal.getHoTen());
                ps.setString(2, uModal.getPassWord());
                
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    uModal.setHoTen(rs.getString("TenTK"));
                    uModal.setPassWord(rs.getString("MK"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginRegisController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
