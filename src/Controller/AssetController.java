/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.Asset;
import View.Asset_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
            if (noti == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.out.println(asModal.toString());
            // Thêm dữ liệu vào trong database
        }
    }
    public void Table(){
        // query dữ liệu trong db để insert vào bảng trong phần view
    }
    public void eventAdd() {
        view.getBtnAddAsset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAsset();
                Table();
                //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}   
