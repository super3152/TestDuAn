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
public class DTOChiTietTraHang {

    int MaCTTH;
    int MaTraHang;
    int MaCTHD;
    int MaSanPham;
    int SoLuong;
    double GiaHang;
    double Phitra;
    double ThanhTien;
    String GhiChu;

    public DTOChiTietTraHang() {
    }

    public DTOChiTietTraHang(int MaCTTH, int MaTraHang, int MaCTHD, int MaSanPham, int SoLuong, double GiaHang, double Phitra, double ThanhTien, String GhiChu) {
        this.MaCTTH = MaCTTH;
        this.MaTraHang = MaTraHang;
        this.MaCTHD = MaCTHD;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.GiaHang = GiaHang;
        this.Phitra = Phitra;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public DTOChiTietTraHang(int MaTraHang, int MaCTHD, int MaSanPham, int SoLuong, double GiaHang, double Phitra, double ThanhTien, String GhiChu) {
        this.MaTraHang = MaTraHang;
        this.MaCTHD = MaCTHD;
        this.MaSanPham = MaSanPham;
        this.SoLuong = SoLuong;
        this.GiaHang = GiaHang;
        this.Phitra = Phitra;
        this.ThanhTien = ThanhTien;
        this.GhiChu = GhiChu;
    }

    public int getMaCTTH() {
        return MaCTTH;
    }

    public void setMaCTTH(int MaCTTH) {
        this.MaCTTH = MaCTTH;
    }

    public int getMaTraHang() {
        return MaTraHang;
    }

    public void setMaTraHang(int MaTraHang) {
        this.MaTraHang = MaTraHang;
    }

    public int getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(int MaCTHD) {
        this.MaCTHD = MaCTHD;
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

    public double getGiaHang() {
        return GiaHang;
    }

    public void setGiaHang(double GiaHang) {
        this.GiaHang = GiaHang;
    }

    public double getPhitra() {
        return Phitra;
    }

    public void setPhitra(double Phitra) {
        this.Phitra = Phitra;
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
