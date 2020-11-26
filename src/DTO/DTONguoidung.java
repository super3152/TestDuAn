/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Administrator
 */
public class DTONguoidung {

    int IdNguoiDung;
    int IdLuong;
    String TenNguoiDung;
    String SoDienThoai;
    String Email;
    String GioiTinh;
    String NgaySinh;
    String NgayVaoLam;
    String DiaChi;
    String CMND;
    String TenDangNhap;
    String MatKhau;
    String AnhDaiDien;
    int Quyen;
    int TrangThai;
    String MoTa;

    public DTONguoidung() {
    }

    public DTONguoidung(int Quyen) {
        this.Quyen = Quyen;
    }

    public DTONguoidung(int IdNguoiDung, int IdLuong, String TenNguoiDung, String SoDienThoai, String Email, String GioiTinh, String NgaySinh, String NgayVaoLam, String DiaChi, String CMND, String TenDangNhap, String MatKhau, String AnhDaiDien, int Quyen, int TrangThai, String MoTa) {
        this.IdNguoiDung = IdNguoiDung;
        this.IdLuong = IdLuong;
        this.TenNguoiDung = TenNguoiDung;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.DiaChi = DiaChi;
        this.CMND = CMND;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.AnhDaiDien = AnhDaiDien;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
        this.MoTa = MoTa;
    }

    public DTONguoidung(int IdLuong, String TenNguoiDung, String SoDienThoai, String Email, String GioiTinh, String NgaySinh, String NgayVaoLam, String DiaChi, String CMND, String TenDangNhap, String MatKhau, String AnhDaiDien, int Quyen, int TrangThai, String MoTa) {
        this.IdLuong = IdLuong;
        this.TenNguoiDung = TenNguoiDung;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.NgaySinh = NgaySinh;
        this.NgayVaoLam = NgayVaoLam;
        this.DiaChi = DiaChi;
        this.CMND = CMND;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.AnhDaiDien = AnhDaiDien;
        this.Quyen = Quyen;
        this.TrangThai = TrangThai;
        this.MoTa = MoTa;
    }

    public int getIdNguoiDung() {
        return IdNguoiDung;
    }

    public void setIdNguoiDung(int IdNguoiDung) {
        this.IdNguoiDung = IdNguoiDung;
    }

    public int getIdLuong() {
        return IdLuong;
    }

    public void setIdLuong(int IdLuong) {
        this.IdLuong = IdLuong;
    }

    public String getTenNguoiDung() {
        return TenNguoiDung;
    }

    public void setTenNguoiDung(String TenNguoiDung) {
        this.TenNguoiDung = TenNguoiDung;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getAnhDaiDien() {
        return AnhDaiDien;
    }

    public void setAnhDaiDien(String AnhDaiDien) {
        this.AnhDaiDien = AnhDaiDien;
    }

    public int getQuyen() {
        return Quyen;
    }

    public void setQuyen(int Quyen) {
        this.Quyen = Quyen;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

 
}
