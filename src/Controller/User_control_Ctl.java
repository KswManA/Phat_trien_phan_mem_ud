/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import model.User;
import java.sql.Connection;
/**
 *
 * @author lekho
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;
public class User_control_Ctl {
public boolean insert(User user ) throws Exception
{
String sql = "insert into user (hoTen,Email,soDT,chucVu) values (?,?,?,?)";
try(
Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

){
pstmt.setString(1, user.getHoTen());
pstmt.setString(2, user.geteMail());
pstmt.setString(3, user.getSoDT());
pstmt.setString(4, user.getChucVu());
return pstmt.executeUpdate() > 0 ;
}
}
 public User Finduser(String maSv ) throws Exception
{
String sql = "select * from user where hoTen = ?";
try(
Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

){
pstmt.setString(1, maSv);
    ResultSet rs = pstmt.executeQuery();
if(rs.next())
{
User user = new User();
user.setHoTen(rs.getString("HoTen"));
user.seteMail(rs.getString("email"));
user.setSoDT(rs.getString("soDT"));
user.setChucVu(rs.getString("chucvu"));
return user;
}
}
return null;
}
public boolean Update(User user ) throws Exception
{
String sql = "update user set Email = ?, soDt = ? "+ "where hoten =?";
try(
Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

){
pstmt.setString(3, user.getHoTen());
pstmt.setString(1, user.geteMail());
pstmt.setString(2, user.getSoDT());
return pstmt.executeUpdate() > 0 ;
}
}
public boolean Delete(User user ) throws Exception
{
String sql = "detele user "+ "where hoten =?";
try(
Connection con = JDBCConnection.getJDBCConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);

){
pstmt.setString(1, user.getHoTen());
return pstmt.executeUpdate() > 0 ;
}
}
}







