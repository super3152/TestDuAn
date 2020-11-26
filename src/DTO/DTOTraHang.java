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
public class DTOTraHang {
    int MaTraHang;
    int MaHoaDon;
    int MaKhachHang;
    int MaNhanVien;
    String SoPhieuTra;
    String TrangThai;
    String HoanTien;
    double TongTien;
    String NgayNhan;
    String LyDoTra;
    String HinhThucThanhToan;

    public DTOTraHang() {
    }

    public DTOTraHang(String SoPhieuTra, String TrangThai, String NgayNhan) {
        this.SoPhieuTra = SoPhieuTra;
        this.TrangThai = TrangThai;
        this.NgayNhan = NgayNhan;
    }

    public DTOTraHang(int MaTraHang, int MaHoaDon, int MaKhachHang, int MaNhanVien, String SoPhieuTra, String TrangThai, String HoanTien, double TongTien, String NgayNhan, String LyDoTra, String HinhThucThanhToan) {
        this.MaTraHang = MaTraHang;
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.SoPhieuTra = SoPhieuTra;
        this.TrangThai = TrangThai;
        this.HoanTien = HoanTien;
        this.TongTien = TongTien;
        this.NgayNhan = NgayNhan;
        this.LyDoTra = LyDoTra;
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public DTOTraHang(int MaHoaDon, int MaKhachHang, int MaNhanVien, String SoPhieuTra, String TrangThai, String HoanTien, double TongTien, String NgayNhan, String LyDoTra, String HinhThucThanhToan) {
        this.MaHoaDon = MaHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.MaNhanVien = MaNhanVien;
        this.SoPhieuTra = SoPhieuTra;
        this.TrangThai = TrangThai;
        this.HoanTien = HoanTien;
        this.TongTien = TongTien;
        this.NgayNhan = NgayNhan;
        this.LyDoTra = LyDoTra;
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public DTOTraHang(String SoPhieuTra, String TrangThai, String HoanTien, String HinhThucThanhToan) {
        this.SoPhieuTra = SoPhieuTra;
        this.TrangThai = TrangThai;
        this.HoanTien = HoanTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
    }
    

    
  

    public int getMaTraHang() {
        return MaTraHang;
    }

    public void setMaTraHang(int MaTraHang) {
        this.MaTraHang = MaTraHang;
    }

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(int MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getSoPhieuTra() {
        return SoPhieuTra;
    }

    public void setSoPhieuTra(String SoPhieuTra) {
        this.SoPhieuTra = SoPhieuTra;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHoanTien() {
        return HoanTien;
    }

    public void setHoanTien(String HoanTien) {
        this.HoanTien = HoanTien;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getNgayNhan() {
        return NgayNhan;
    }

    public void setNgayNhan(String NgayNhan) {
        this.NgayNhan = NgayNhan;
    }

    public String getLyDoTra() {
        return LyDoTra;
    }

    public void setLyDoTra(String LyDoTra) {
        this.LyDoTra = LyDoTra;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }



  
  
}
