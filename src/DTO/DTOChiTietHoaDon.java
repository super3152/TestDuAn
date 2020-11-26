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
public class DTOChiTietHoaDon {
    int MaCTHD;
    int MaHoaDon;
    int MaSanPham;
    int SoLuong;
    double ThanhTien;
    double UuDai;
    String GhiChu;

    public DTOChiTietHoaDon() {
    }

    public DTOChiTietHoaDon(int MaCTHD, int SoLuong, double ThanhTien) {
        this.MaCTHD = MaCTHD;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
    }

   
    
    public DTOChiTietHoaDon(int MaCTHD, int MaHoaDon, int MaSanPham, int SoLuong, double ThanhTien, double UuDai, String GhiChu) {
        this.MaCTHD = MaCTHD;
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.UuDai = UuDai;
        this.GhiChu = GhiChu;
    }

    public DTOChiTietHoaDon(int MaHoaDon, int MaSanPham, int SoLuong, double ThanhTien, double UuDai, String GhiChu) {
        this.MaHoaDon = MaHoaDon;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.ThanhTien = ThanhTien;
        this.UuDai = UuDai;
        this.GhiChu = GhiChu;
    }

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(int MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public double getUuDai() {
        return UuDai;
    }

    public void setUuDai(double UuDai) {
        this.UuDai = UuDai;
    }


    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    
}
