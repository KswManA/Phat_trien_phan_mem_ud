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
import java.util.ArrayList;
import model.User;
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
public class AssetController {

    Asset_View view;
    Asset asModal;

    public AssetController() {
    }

    public AssetController(Asset_View view) {
        this.view = view;
    }

    public void AddAsset() {
        //add vào db
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
