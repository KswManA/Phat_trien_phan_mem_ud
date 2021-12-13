/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author HuyLQ
 */
public class Asset implements Serializable{

    public String maTS;
    public String tenTS;
    public String loaiTS;
    public String nguoiGiu;
    public String ttTS;
    public int soLuong;
    public String ThoiGianTiepNhan;

    public Asset() {
    }

    public Asset(String maTS, String tenTS, String loaiTS, String nguoiGiu, String ttTS, int soLuong, String ThoiGianTiepNhan) {
        this.maTS = maTS;
        this.tenTS = tenTS;
        this.loaiTS = loaiTS;
        this.nguoiGiu = nguoiGiu;
        this.ttTS = ttTS;
        this.soLuong = soLuong;
        this.ThoiGianTiepNhan = ThoiGianTiepNhan;
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

    public String getThoiGianTiepNhan() {
        return ThoiGianTiepNhan;
    }

    public void setThoiGianTiepNhan(String ThoiGianTiepNhan) {
        this.ThoiGianTiepNhan = ThoiGianTiepNhan;
    }

    @Override
    public String toString() {
        return "Asset{" + "maTS=" + maTS + ", tenTS=" + tenTS + ", loaiTS=" + loaiTS + ", nguoiGiu=" + nguoiGiu + ", ttTS=" + ttTS + ", soLuong=" + soLuong + ", ThoiGianTiepNhan=" + ThoiGianTiepNhan + '}';
    }
    
    
    
    
}
