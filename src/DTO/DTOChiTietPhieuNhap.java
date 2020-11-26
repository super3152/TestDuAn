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
public class DTOChiTietPhieuNhap {
    int IDChiTietPhieuNhap;
    int IDPhieuNhap;
    int IDSanPham;
    String DonViTinh;
    int SoLuong;
    double GiaNhap;
    double ThanhTien;
    String GhiChu;

    public DTOChiTietPhieuNhap(int IDChiTietPhieuNhap, int IDPhieuNhap, int IDSanPham, String DonViTinh, int SoLuong, double GiaNhap, double ThanhTien, String GhiChu) {
        this.IDChiTietPhieuNhap = IDChiTietPhieuNhap;
        this.IDPhieuNhap = IDPhieuNhap;
        this.IDSanPham = IDSanPham;
        this.DonViTinh = DonViTinh;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public DTOChiTietPhieuNhap(int IDPhieuNhap, int IDSanPham, String DonViTinh, int SoLuong, double GiaNhap, double ThanhTien, String GhiChu) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.IDSanPham = IDSanPham;
        this.DonViTinh = DonViTinh;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public int getIDChiTietPhieuNhap() {
        return IDChiTietPhieuNhap;
    }

    public void setIDChiTietPhieuNhap(int IDChiTietPhieuNhap) {
        this.IDChiTietPhieuNhap = IDChiTietPhieuNhap;
    }

    public int getIDPhieuNhap() {
        return IDPhieuNhap;
    }

    public void setIDPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
}
