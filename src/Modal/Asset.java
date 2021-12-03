/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author HuyLQ
 */
public class Asset {

    private String maTS;
    private String tenTS;
    private String loaiTS;
    private String nguoiGiu;
    private String ttTS;
    private int soLuong;

    public Asset() {
    }

    public Asset(String maTS, String tenTS, String loaiTS, String nguoiGiu, String ttTS, int soLuong) {
        this.maTS = maTS;
        this.tenTS = tenTS;
        this.loaiTS = loaiTS;
        this.nguoiGiu = nguoiGiu;
        this.ttTS = ttTS;
        this.soLuong = soLuong;
    }

    public String getMaTS() {
        return maTS;
    }

    public void setMaTS(String maTS) {
        this.maTS = maTS;
    }

    public String getTenTS() {
        return tenTS;
    }

    public void setTenTS(String tenTS) {
        this.tenTS = tenTS;
    }

    public String getLoaiTS() {
        return loaiTS;
    }

    public void setLoaiTS(String loaiTS) {
        this.loaiTS = loaiTS;
    }

    public String getNguoiGiu() {
        return nguoiGiu;
    }

    public void setNguoiGiu(String nguoiGiu) {
        this.nguoiGiu = nguoiGiu;
    }

    public String getTtTS() {
        return ttTS;
    }

    public void setTtTS(String ttTS) {
        this.ttTS = ttTS;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
