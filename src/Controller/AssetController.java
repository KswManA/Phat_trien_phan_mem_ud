/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Asset;
import View.Asset_View;
import java.awt.Font;
import java.awt.List;
import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author HuyLQ
 */
public class AssetController extends JDBCConnection {

    Asset_View view;
    Asset asModal = new Asset();


    public AssetController() {
        super();
    }

    public AssetController(Asset_View view) {
        this.view = view;
    }

    public boolean AddAsset(String maTsString, String tenTS, String loaiTS, String ttTS, String nguoiGiu) {
        //add vào db
        String sql = "insert into TaiSan (MaTS, TenTS, LoaiTS, TinhTrang, SoLuong, NguoiGiu, ThoiGianTiepNhan)" + " values (?, ?, ?, ?, ? , ?, ?)";
//        String date = new String();
//        date = LocalDate.now().toString();

        try {
//            con = JDBCConnection.getJDBCConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, maTsString);
            ps.setString(2, tenTS);
            ps.setString(3, loaiTS);
            ps.setString(4, ttTS);
            ps.setInt(5, 1);
            ps.setString(6, nguoiGiu);
//            ps.setDate(7, new Date(asModal.getThoiGianTiepNhan().getTime()));
//            ps.setDate(7, );
            ps.setString(7, LocalDate.now().toString());
           
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public ArrayList<Asset> getListAsset() {
        ArrayList<Asset> list = new ArrayList<>();
       
        String sql = "select * from TaiSan";
        try {
            con = JDBCConnection.getJDBCConnection(); // gọi câu này nữa thì mới lấy được con 
            PreparedStatement ps = con.prepareStatement(sql); //lấy được rồi đấy, nhưng db k có dữ liệu thì phải
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Asset asModel = new Asset();
                asModel.setMaTS(rs.getString("MaTS"));
                asModel.setTenTS(rs.getString("TenTS"));
                asModel.setLoaiTS(rs.getString("LoaiTS"));
                asModel.setTtTS(rs.getString("TinhTrang"));
                asModel.setSoLuong(rs.getInt("SoLuong"));
                asModel.setNguoiGiu(rs.getString("NguoiGiu"));
                asModel.setThoiGianTiepNhan(rs.getString("ThoiGianTiepNhan"));
                list.add(asModel);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void SearchAsset() {
        //query db xong hiện lên bảng
    }

    public void MainExcel() throws Exception {
        String exFileName = new String("D:\\Baitap\\Pt_pm_ud\\Output\\Excel.xlsx");
        Workbook wb = new HSSFWorkbook();
        OutputStream fOutput = new FileOutputStream(exFileName);
        wb.write(fOutput);
        fOutput.close();
        wb.close();
    }
}
