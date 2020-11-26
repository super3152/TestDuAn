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
public class DTOHoaDon {
    int MaHoaDon ;
    String SoHoaDon ; 
    String NgayTaoHoaDon ; 
    int MaNV ;
    int TinhTrang ; 
    double TongTien ;
    int MaKhachHang ;
    int TraHang;
    double CongNo;
    String HanTraCongNo;

    public String getHanTraCongNo() {
        return HanTraCongNo;
    }

    public void setHanTraCongNo(String HanTraCongNo) {
        this.HanTraCongNo = HanTraCongNo;
    }

    public DTOHoaDon() {
    }

    public DTOHoaDon(int MaHoaDon, String SoHoaDon, String NgayTaoHoaDon, int MaNV, int TinhTrang, double TongTien, int MaKhachHang, int TraHang, double CongNo) {
        this.MaHoaDon = MaHoaDon;
        this.SoHoaDon = SoHoaDon;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.MaNV = MaNV;
        this.TinhTrang = TinhTrang;
        this.TongTien = TongTien;
        this.MaKhachHang = MaKhachHang;
        this.TraHang = TraHang;
        this.CongNo = CongNo;
    }

    public DTOHoaDon(String SoHoaDon, String NgayTaoHoaDon, int MaNV, int TinhTrang, double TongTien, int MaKhachHang, int TraHang, double CongNo) {
        this.SoHoaDon = SoHoaDon;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.MaNV = MaNV;
        this.TinhTrang = TinhTrang;
        this.TongTien = TongTien;
        this.MaKhachHang = MaKhachHang;
        this.TraHang = TraHang;
        this.CongNo = CongNo;
    }

    public DTOHoaDon(String SoHoaDon, int TinhTrang, double CongNo, String HanTraCongNo) {
        this.SoHoaDon = SoHoaDon;
        this.TinhTrang = TinhTrang;
        this.CongNo = CongNo;
        this.HanTraCongNo = HanTraCongNo;
    }

    public DTOHoaDon(String SoHoaDon,int TinhTrang) {
        this.SoHoaDon = SoHoaDon;
        this.TinhTrang = TinhTrang;
    }

    
    

    public DTOHoaDon(String SoHoaDon, double TongTien) {
        this.SoHoaDon = SoHoaDon;
        this.TongTien = TongTien;
    }

    public DTOHoaDon(int MaHoaDon, int TraHang) {
        this.MaHoaDon = MaHoaDon;
        this.TraHang = TraHang;
    }

    public DTOHoaDon(int MaHoaDon, int TinhTrang, double CongNo) {
        this.MaHoaDon = MaHoaDon;
        this.TinhTrang = TinhTrang;
        this.CongNo = CongNo;
    }

  
    

    public int getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public String getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(String NgayTaoHoaDon) {
        this.NgayTaoHoaDon = NgayTaoHoaDon;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getTraHang() {
        return TraHang;
    }

    public void setTraHang(int TraHang) {
        this.TraHang = TraHang;
    }

    public double getCongNo() {
        return CongNo;
    }

    public void setCongNo(double CongNo) {
        this.CongNo = CongNo;
    }
    
    
}
