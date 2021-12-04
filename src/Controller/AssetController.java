/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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

    public void AddAsset() {

        int noti;
        String maTS = view.getTxtMaTS().getText();
        String tenTS = view.getTxtTenTS().getText();
        String loaiTS = view.getTxtLoaiTS().getText();
        String ttTS = view.getCbttTS().getSelectedItem().toString();
        String nguoiGiu = view.getTxtNguoiGiu().getText();

        if (maTS.isEmpty() || tenTS.isEmpty() || loaiTS.isEmpty() || nguoiGiu.isEmpty()) {
            noti = JOptionPane.showConfirmDialog(view, "Vui lòng điền đầy đủ thông tin", "Alert", JOptionPane.YES_OPTION);
            if (noti == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    public void eventAddAsset() {
        view.getBtnAddAsset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAsset();
            }
        });
    }
    public boolean eventAssetView(){
        view.setVisible(true);
        return true;
    }
    public AssetController() {
    }

    public AssetController(Asset_View view) {
        this.view = view;
    }

}
