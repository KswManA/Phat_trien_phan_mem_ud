/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Asset;
import View.Asset_View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

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
        //Init
        String exFileName = new String("D:\\Baitap\\Pt_pm_ud\\Output\\Excel.xls");
        HSSFWorkbook wb = new HSSFWorkbook();
        OutputStream fOutput = new FileOutputStream(exFileName);
        ArrayList<Asset> list = new ArrayList<>();
        int rownum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(wb);
        HSSFSheet sheet = wb.createSheet("Employees sheet");
        row = sheet.createRow(rownum);
        asModal = new Asset();
        //Process
        Asset as = new Asset(asModal.getMaTS(), asModal.getTenTS(), asModal.getLoaiTS(), asModal.getNguoiGiu(), asModal.getTtTS(), asModal.getSoLuong());
        list.add(as);

        // Mã tài sản 
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Mã tài sản");
        cell.setCellStyle(style);
        // Tên tài sản
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Tên tài sản");
        cell.setCellStyle(style);
        // Loại tài sản
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Loại tài sản");
        cell.setCellStyle(style);
        // người giữ
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Người giữ");
        cell.setCellStyle(style);
        //tình trạng tài sản
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Tình trạng tài sản");
        cell.setCellStyle(style);
        //số lượng
        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Số lượng");
        cell.setCellStyle(style);

        // Data
        for (Asset emp : list) {
            rownum++;
            row = sheet.createRow(rownum);

            //  (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(emp.getMaTS());
            // (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(emp.getTenTS());
            //  (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(emp.getLoaiTS());
            // (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(emp.getNguoiGiu());
            // (E)
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(emp.getTtTS());
            // (F)
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(emp.getSoLuong());
        }
        File file = new File(exFileName);
        file.getParentFile().mkdirs();
        FileOutputStream outFile = new FileOutputStream(file);
        wb.write(outFile);
        System.out.println("Created file: " + file.getAbsolutePath());
        wb.write(fOutput);
        fOutput.close();
        wb.close();
    }

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

}
