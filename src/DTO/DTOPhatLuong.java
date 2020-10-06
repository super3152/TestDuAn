/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class DTOPhatLuong {
    int MaPhatLuong;
    int MaNV;   
    String NgayPhat;
    String SoNgayDiLam;
    String SoNgayNghi;
    String TienThuong;
    String TienPhat;   
    String GhiChu;
    int MaLuong;
    String TongLuong;

    public DTOPhatLuong(int MaPhatLuong, int MaNV, String NgayPhat, String SoNgayDiLam, String SoNgayNghi, String TienThuong, String TienPhat, String GhiChu, int MaLuong, String TongLuong) {
        this.MaPhatLuong = MaPhatLuong;
        this.MaNV = MaNV;
        this.NgayPhat = NgayPhat;
        this.SoNgayDiLam = SoNgayDiLam;
        this.SoNgayNghi = SoNgayNghi;
        this.TienThuong = TienThuong;
        this.TienPhat = TienPhat;
        this.GhiChu = GhiChu;
        this.MaLuong = MaLuong;
        this.TongLuong = TongLuong;
    }

    public DTOPhatLuong(int MaNV, String NgayPhat, String SoNgayDiLam, String SoNgayNghi, String TienThuong, String TienPhat, String GhiChu, int MaLuong, String TongLuong) {
        this.MaNV = MaNV;
        this.NgayPhat = NgayPhat;
        this.SoNgayDiLam = SoNgayDiLam;
        this.SoNgayNghi = SoNgayNghi;
        this.TienThuong = TienThuong;
        this.TienPhat = TienPhat;
        this.GhiChu = GhiChu;
        this.MaLuong = MaLuong;
        this.TongLuong = TongLuong;
    }

    public DTOPhatLuong() {
    }

    public int getMaPhatLuong() {
        return MaPhatLuong;
    }

    public void setMaPhatLuong(int MaPhatLuong) {
        this.MaPhatLuong = MaPhatLuong;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getNgayPhat() {
        return NgayPhat;
    }

    public void setNgayPhat(String NgayPhat) {
        this.NgayPhat = NgayPhat;
    }

    public String getSoNgayDiLam() {
        return SoNgayDiLam;
    }

    public void setSoNgayDiLam(String SoNgayDiLam) {
        this.SoNgayDiLam = SoNgayDiLam;
    }

    public String getSoNgayNghi() {
        return SoNgayNghi;
    }

    public void setSoNgayNghi(String SoNgayNghi) {
        this.SoNgayNghi = SoNgayNghi;
    }

    public String getTienThuong() {
        return TienThuong;
    }

    public void setTienThuong(String TienThuong) {
        this.TienThuong = TienThuong;
    }

    public String getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(String TienPhat) {
        this.TienPhat = TienPhat;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getMaLuong() {
        return MaLuong;
    }

    public void setMaLuong(int MaLuong) {
        this.MaLuong = MaLuong;
    }

    public String getTongLuong() {
        return TongLuong;
    }

    public void setTongLuong(String TongLuong) {
        this.TongLuong = TongLuong;
    }

   
}
