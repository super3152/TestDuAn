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
public class DTOMauSanPham {
    int IDMauSanPham;
    String TenMauSanPham;
    String MoTa;

    public DTOMauSanPham() {
    }

    public DTOMauSanPham(String TenMauSanPham) {
        this.TenMauSanPham = TenMauSanPham;
    }

    public DTOMauSanPham(int IDMauSanPham, String TenMauSanPham, String MoTa) {
        this.IDMauSanPham = IDMauSanPham;
        this.TenMauSanPham = TenMauSanPham;
        this.MoTa = MoTa;
    }

    public DTOMauSanPham(String TenMauSanPham, String MoTa) {
        this.TenMauSanPham = TenMauSanPham;
        this.MoTa = MoTa;
    }

    public int getIDMauSanPham() {
        return IDMauSanPham;
    }

    public void setIDMauSanPham(int IDMauSanPham) {
        this.IDMauSanPham = IDMauSanPham;
    }

    public String getTenMauSanPham() {
        return TenMauSanPham;
    }

    public void setTenMauSanPham(String TenMauSanPham) {
        this.TenMauSanPham = TenMauSanPham;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}
