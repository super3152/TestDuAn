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
    public class DTONhaCungCap {
    int IDNhaCungCap;
    String TenNhaCungCap;
    String MaNhaCungCap;
    int MaLoaiNhaCungCap;
    String SoDienThoai;
    String Email;
    String DiaChi;
    String Tinh;
    String SoFax;
    String MaSoThue;
    String WebSite;
    int MaNguoiDung;
    int TrangThai;
    String LanCuoiNhapHang;
    double TongTienHang;
    double CongNo;
    String Tag;
    String MoTa;

    public DTONhaCungCap() {
    }

    public DTONhaCungCap(int IDNhaCungCap, String TenNhaCungCap, String MaNhaCungCap, int MaLoaiNhaCungCap, String SoDienThoai, String Email, String DiaChi, String Tinh, String SoFax, String MaSoThue, String WebSite, int MaNguoiDung, int TrangThai, String Tag, String MoTa) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.TenNhaCungCap = TenNhaCungCap;
        this.MaNhaCungCap = MaNhaCungCap;
        this.MaLoaiNhaCungCap = MaLoaiNhaCungCap;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.Tinh = Tinh;
        this.SoFax = SoFax;
        this.MaSoThue = MaSoThue;
        this.WebSite = WebSite;
        this.MaNguoiDung = MaNguoiDung;
        this.TrangThai = TrangThai;
        this.Tag = Tag;
        this.MoTa = MoTa;
    }

    public DTONhaCungCap(String TenNhaCungCap, String MaNhaCungCap, int MaLoaiNhaCungCap, String SoDienThoai, String Email, String DiaChi, String Tinh, String SoFax, String MaSoThue, String WebSite, int MaNguoiDung, int TrangThai, String Tag, String MoTa) {
        this.TenNhaCungCap = TenNhaCungCap;
        this.MaNhaCungCap = MaNhaCungCap;
        this.MaLoaiNhaCungCap = MaLoaiNhaCungCap;
        this.SoDienThoai = SoDienThoai;
        this.Email = Email;
        this.DiaChi = DiaChi;
        this.Tinh = Tinh;
        this.SoFax = SoFax;
        this.MaSoThue = MaSoThue;
        this.WebSite = WebSite;
        this.MaNguoiDung = MaNguoiDung;
        this.TrangThai = TrangThai;
        this.Tag = Tag;
        this.MoTa = MoTa;
    }


    public DTONhaCungCap(int IDNhaCungCap, String LanCuoiNhapHang, double TongTienHang, double CongNo) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.LanCuoiNhapHang = LanCuoiNhapHang;
        this.TongTienHang = TongTienHang;
        this.CongNo = CongNo;
    }

    public DTONhaCungCap(int IDNhaCungCap, double CongNo) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.CongNo = CongNo;
    }

    public int getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(int IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return TenNhaCungCap;
    }

    public void setTenNhaCungCap(String TenNhaCungCap) {
        this.TenNhaCungCap = TenNhaCungCap;
    }

    public String getMaNhaCungCap() {
        return MaNhaCungCap;
    }

    public void setMaNhaCungCap(String MaNhaCungCap) {
        this.MaNhaCungCap = MaNhaCungCap;
    }

    public int getMaLoaiNhaCungCap() {
        return MaLoaiNhaCungCap;
    }

    public void setMaLoaiNhaCungCap(int MaLoaiNhaCungCap) {
        this.MaLoaiNhaCungCap = MaLoaiNhaCungCap;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTinh() {
        return Tinh;
    }

    public void setTinh(String Tinh) {
        this.Tinh = Tinh;
    }

    public String getSoFax() {
        return SoFax;
    }

    public void setSoFax(String SoFax) {
        this.SoFax = SoFax;
    }

    public String getMaSoThue() {
        return MaSoThue;
    }

    public void setMaSoThue(String MaSoThue) {
        this.MaSoThue = MaSoThue;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String WebSite) {
        this.WebSite = WebSite;
    }

    public int getMaNguoiDung() {
        return MaNguoiDung;
    }

    public void setMaNguoiDung(int MaNguoiDung) {
        this.MaNguoiDung = MaNguoiDung;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getLanCuoiNhapHang() {
        return LanCuoiNhapHang;
    }

    public void setLanCuoiNhapHang(String LanCuoiNhapHang) {
        this.LanCuoiNhapHang = LanCuoiNhapHang;
    }

    public double getTongTienHang() {
        return TongTienHang;
    }

    public void setTongTienHang(double TongTienHang) {
        this.TongTienHang = TongTienHang;
    }

    public double getCongNo() {
        return CongNo;
    }

    public void setCongNo(double CongNo) {
        this.CongNo = CongNo;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
}
