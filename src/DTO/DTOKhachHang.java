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
public class DTOKhachHang {
    int IdKhachHang;
    int IdLoaiKhachHang;
    int IdNguoiDung;
    String TenKhachHang;
    int SoDienThoai;
    String Email;
    String MatKhau;
    Date NgaySinh;
    String DiaChi;
    int GioiTinh;
    String MangXaHoi;
    String MoTa;
    String Tag;

    public DTOKhachHang() {
    }

    public DTOKhachHang(int IdKhachHang, int IdLoaiKhachHang, int IdNguoiDung, String TenKhachHang, int SoDienThoai, String Email, String MatKhau, Date NgaySinh, String DiaChi, int GioiTinh, String MangXaHoi, String MoTa, String Tag) {
        this.IdKhachHang = IdKhachHang;
        this.IdLoaiKhachHang = IdLoaiKhachHang;
        this.IdNguoiDung = IdNguoiDung;
        this.TenKhachHang = TenKhachHang;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.MatKhau = MatKhau;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.GioiTinh = GioiTinh;
        this.MangXaHoi = MangXaHoi;
        this.MoTa = MoTa;
        this.Tag = Tag;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public int getIdLoaiKhachHang() {
        return IdLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(int IdLoaiKhachHang) {
        this.IdLoaiKhachHang = IdLoaiKhachHang;
    }

    public int getIdNguoiDung() {
        return IdNguoiDung;
    }

    public void setIdNguoiDung(int IdNguoiDung) {
        this.IdNguoiDung = IdNguoiDung;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public int getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(int SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMangXaHoi() {
        return MangXaHoi;
    }

    public void setMangXaHoi(String MangXaHoi) {
        this.MangXaHoi = MangXaHoi;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }
    
    
}
