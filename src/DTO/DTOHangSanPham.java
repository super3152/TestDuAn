/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class DTOHangSanPham {
    int IDHangSanPham;
    String TenHang;
    String MoTa;

    public DTOHangSanPham(int IDHangSanPham, String TenHang, String MoTa) {
        this.IDHangSanPham = IDHangSanPham;
        this.TenHang = TenHang;
        this.MoTa = MoTa;
    }

    public DTOHangSanPham(String TenHang, String MoTa) {
        this.TenHang = TenHang;
        this.MoTa = MoTa;
    }

    public int getIDHangSanPham() {
        return IDHangSanPham;
    }

    public void setIDHangSanPham(int IDHangSanPham) {
        this.IDHangSanPham = IDHangSanPham;
    }

    public String getTenHang() {
        return TenHang;
    }

    public void setTenHang(String TenHang) {
        this.TenHang = TenHang;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
}
