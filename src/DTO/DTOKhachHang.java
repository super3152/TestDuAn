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
public class DTOKhachHang {
    int IdKhachHang;
    int IdLoaiKhachHang;
    int IdNguoiDung;
    String TenKhachHang;
    String SoDienThoai;
    String Email;
    String MatKhau;
    String NgaySinh;
    String DiaChi;
    String GioiTinh;
    String MangXaHoi;
    String LanCuoiMuaHang;
    double TongTienHang;
    double CongNo;
    String MoTa;
    String Tag;

    public DTOKhachHang() {
    }

    public DTOKhachHang(int IdLoaiKhachHang, int IdNguoiDung, String TenKhachHang, String SoDienThoai, String Email, String MatKhau, String NgaySinh, String DiaChi, String GioiTinh, String MangXaHoi, String MoTa, String Tag) {
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

    public DTOKhachHang(int IdKhachHang, int IdLoaiKhachHang, int IdNguoiDung, String TenKhachHang, String SoDienThoai, String Email, String MatKhau, String NgaySinh, String DiaChi, String GioiTinh, String MangXaHoi, String MoTa, String Tag) {
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

    public DTOKhachHang(int IdKhachHang, int IdLoaiKhachHang) {
        this.IdKhachHang = IdKhachHang;
        this.IdLoaiKhachHang = IdLoaiKhachHang;
    }
    
    public DTOKhachHang(int IdKhachHang, String LanCuoiMuaHang, double TongTienHang) {
        this.IdKhachHang = IdKhachHang;
        this.LanCuoiMuaHang = LanCuoiMuaHang;
        this.TongTienHang = TongTienHang;
    }

    public DTOKhachHang(int IdKhachHang, double CongNo) {
        this.IdKhachHang = IdKhachHang;
        this.CongNo = CongNo;
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

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMangXaHoi() {
        return MangXaHoi;
    }

    public void setMangXaHoi(String MangXaHoi) {
        this.MangXaHoi = MangXaHoi;
    }

    public String getLanCuoiMuaHang() {
        return LanCuoiMuaHang;
    }

    public void setLanCuoiMuaHang(String LanCuoiMuaHang) {
        this.LanCuoiMuaHang = LanCuoiMuaHang;
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
