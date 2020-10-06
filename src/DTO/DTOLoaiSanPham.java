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
public class DTOLoaiSanPham {
    int IDLoaiSanPham;
    String TenLoaiSanPham;
    String MoTa;

    public DTOLoaiSanPham() {
    }

    public DTOLoaiSanPham(int IDLoaiSanPham, String TenLoaiSanPham, String MoTa) {
        this.IDLoaiSanPham = IDLoaiSanPham;
        this.TenLoaiSanPham = TenLoaiSanPham;
        this.MoTa = MoTa;
    }

    public DTOLoaiSanPham(String TenLoaiSanPham, String MoTa) {
        this.TenLoaiSanPham = TenLoaiSanPham;
        this.MoTa = MoTa;
    }

    public int getIDLoaiSanPham() {
        return IDLoaiSanPham;
    }

    public void setIDLoaiSanPham(int IDLoaiSanPham) {
        this.IDLoaiSanPham = IDLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return TenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String TenLoaiSanPham) {
        this.TenLoaiSanPham = TenLoaiSanPham;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}
