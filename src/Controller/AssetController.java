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
        String exFileName = new String("D:\\Baitap\\Pt_pm_ud\\Output\\Excel.xlsx");
        Workbook wb = new HSSFWorkbook();
        OutputStream fOutput = new FileOutputStream(exFileName);
        wb.write(fOutput);
        fOutput.close();
        wb.close();
    }
}
