/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Register_View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author HuyLQ
 */
public class LoginRegisController {

    //Regis
    User uModal;
    Register_View regView;

    public LoginRegisController() {
    }
   public LoginRegisController(Register_View regView) {
        this.regView = regView;
        regView.setVisible(true);
    }

    public void Regis() {
        int noti;
        String regNumber;
        uModal = new User();
        
        uModal.setHoTen(regView.getTxtReUser().getText());
        uModal.seteMail(regView.getTxtRegEmail().getText());
        regNumber = regView.getTxtNumber().getText();
        for (char c : regNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                 noti = JOptionPane.showConfirmDialog(regView, "Vui lòng nhập số", "Alert", JOptionPane.YES_OPTION);
                if (noti == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
            } else {
               uModal.setSoDT(Integer.parseInt(regNumber));
            }
        }

        if (regView.getBtnGiaoVien().isSelected()) {
            uModal.setChucVu("Giaovien");
        }
        if (regView.getBtnThuKho().isSelected()) {
            uModal.setChucVu("Thukho");
        }

        if (uModal.hoTen.isEmpty() || uModal.eMail.isEmpty()|| uModal.chucVu.isEmpty()) {
            noti = JOptionPane.showConfirmDialog(regView, "Vui lòng điền đầy đủ thông tin", "Alert", JOptionPane.YES_OPTION);
            if (noti == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.out.println(uModal.toString());
            // Thêm dữ liệu vào trong database
        }
    }

    public void eventReg() {
        regView.getBtnRegis().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Regis(); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
