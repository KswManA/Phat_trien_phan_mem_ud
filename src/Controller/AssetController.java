/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Asset;
import View.Asset_View;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
        view.setVisible(true);
    }

    public void AddAsset() {

        int noti;
        asModal = new Asset();
        asModal.setMaTS(view.getTxtMaTS().getText());
        asModal.setTenTS(view.getTxtTenTS().getText());
        asModal.setNguoiGiu(view.getTxtNguoiGiu().getText());
        asModal.setLoaiTS(view.getTxtLoaiTS().getText());
        asModal.setTtTS(view.getCbttTS().getSelectedItem().toString());
        if (asModal.maTS.isEmpty() || asModal.tenTS.isEmpty() || asModal.nguoiGiu.isEmpty()) {
            noti = JOptionPane.showConfirmDialog(view, "Vui lòng điền đầy đủ thông tin", "Alert", JOptionPane.YES_OPTION);
            if (noti == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        } else {
            System.out.println(asModal.toString());
        }
    }

    public void exportExcel(JTable table) {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                // ten Cot
                for (int j = 0; j < table.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < table.getRowCount(); j++) {
                    for (int k = 0; k < table.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }

    public void eventAdd() {
        view.getBtnAddAsset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAsset();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    public void eventExcel(){
        view.getBtnExcel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportExcel(table);
                 //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
