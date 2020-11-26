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
public class DTOPhieuNhap {
    int IDPhieuNhap;
    int IDNhaCungCap;
    int IDChiNhanh;
    int IDNguoiDung;
    String SoPhieuNhap;
    String NgayNhap;
    double ThanhTien;
    String HinhThucThanhToan;
    String HinhThucNhap;
    String TrangThai;
    String NhapKho;
    String ThanhToan;
    double CongNo;
    String HanTraCongNo;
    String Tag;
    String GhiChu;

    public DTOPhieuNhap(int IDPhieuNhap, int IDNhaCungCap, int IDChiNhanh, int IDNguoiDung, String SoPhieuNhap, String NgayNhap, double ThanhTien, String HinhThucThanhToan, String HinhThucNhap, String TrangThai, String NhapKho, String ThanhToan, double CongNo, String HanTraCongNo, String Tag, String GhiChu) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDChiNhanh = IDChiNhanh;
        this.IDNguoiDung = IDNguoiDung;
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.ThanhTien = ThanhTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.HinhThucNhap = HinhThucNhap;
        this.TrangThai = TrangThai;
        this.NhapKho = NhapKho;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.HanTraCongNo = HanTraCongNo;
        this.Tag = Tag;
        this.GhiChu = GhiChu;
    }

    public DTOPhieuNhap(int IDNhaCungCap, int IDChiNhanh, int IDNguoiDung, String SoPhieuNhap, String NgayNhap, double ThanhTien, String HinhThucThanhToan, String HinhThucNhap, String TrangThai, String NhapKho, String ThanhToan, double CongNo, String Tag, String GhiChu) {
        this.IDNhaCungCap = IDNhaCungCap;
        this.IDChiNhanh = IDChiNhanh;
        this.IDNguoiDung = IDNguoiDung;
        this.SoPhieuNhap = SoPhieuNhap;
        this.NgayNhap = NgayNhap;
        this.ThanhTien = ThanhTien;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.HinhThucNhap = HinhThucNhap;
        this.TrangThai = TrangThai;
        this.NhapKho = NhapKho;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.Tag = Tag;
        this.GhiChu = GhiChu;
    }


  

    public DTOPhieuNhap(String SoPhieuNhap, String NhapKho) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.NhapKho = NhapKho;
    }


    public DTOPhieuNhap(String SoPhieuNhap, String HinhThucThanhToan, String ThanhToan, double CongNo, String HanTraCongNo) {
        this.SoPhieuNhap = SoPhieuNhap;
        this.HinhThucThanhToan = HinhThucThanhToan;
        this.ThanhToan = ThanhToan;
        this.CongNo = CongNo;
        this.HanTraCongNo = HanTraCongNo;
    }
    

    public DTOPhieuNhap(int IDPhieuNhap, double CongNo) {
        this.IDPhieuNhap = IDPhieuNhap;
        this.CongNo = CongNo;
    }

    public DTOPhieuNhap() {
       
    }

    

    public int getIDPhieuNhap() {
        return IDPhieuNhap;
    }

    public void setIDPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
    }

    public int getIDNhaCungCap() {
        return IDNhaCungCap;
    }

    public void setIDNhaCungCap(int IDNhaCungCap) {
        this.IDNhaCungCap = IDNhaCungCap;
    }

    public int getIDChiNhanh() {
        return IDChiNhanh;
    }

    public void setIDChiNhanh(int IDChiNhanh) {
        this.IDChiNhanh = IDChiNhanh;
    }

    public int getIDNguoiDung() {
        return IDNguoiDung;
    }

    public void setIDNguoiDung(int IDNguoiDung) {
        this.IDNguoiDung = IDNguoiDung;
    }

    public String getSoPhieuNhap() {
        return SoPhieuNhap;
    }

    public void setSoPhieuNhap(String SoPhieuNhap) {
        this.SoPhieuNhap = SoPhieuNhap;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public double getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(double ThanhTien) {
        this.ThanhTien = ThanhTien;
    }

    public String getHinhThucThanhToan() {
        return HinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String HinhThucThanhToan) {
        this.HinhThucThanhToan = HinhThucThanhToan;
    }

    public String getHinhThucNhap() {
        return HinhThucNhap;
    }

    public void setHinhThucNhap(String HinhThucNhap) {
        this.HinhThucNhap = HinhThucNhap;
    }
    
    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getNhapKho() {
        return NhapKho;
    }

    public void setNhapKho(String NhapKho) {
        this.NhapKho = NhapKho;
    }

    public String getThanhToan() {
        return ThanhToan;
    }

    public void setThanhToan(String ThanhToan) {
        this.ThanhToan = ThanhToan;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public double getCongNo() {
        return CongNo;
    }

    public void setCongNo(double CongNo) {
        this.CongNo = CongNo;
    }

    public String getHanTraCongNo() {
        return HanTraCongNo;
    }

    public void setHanTraCongNo(String HanTraCongNo) {
        this.HanTraCongNo = HanTraCongNo;
    }

  
}
