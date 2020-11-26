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
public class DTOLoaiKhachHang {
    int IdLoaiKhachHang;
    String TenLoaiKhachHang;
    String UuDai;
    String MoTa;

    public DTOLoaiKhachHang() {
    }

    public DTOLoaiKhachHang(int IdLoaiKhachHang, String TenLoaiKhachHang, String UuDai, String MoTa) {
        this.IdLoaiKhachHang = IdLoaiKhachHang;
        this.TenLoaiKhachHang = TenLoaiKhachHang;
        this.UuDai = UuDai;
        this.MoTa = MoTa;
    }

    public DTOLoaiKhachHang(String TenLoaiKhachHang, String UuDai, String MoTa) {
        this.TenLoaiKhachHang = TenLoaiKhachHang;
        this.UuDai = UuDai;
        this.MoTa = MoTa;
    }
    

    public int getIdLoaiKhachHang() {
        return IdLoaiKhachHang;
    }

    public void setIdLoaiKhachHang(int IdLoaiKhachHang) {
        this.IdLoaiKhachHang = IdLoaiKhachHang;
    }

    public String getTenLoaiKhachHang() {
        return TenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String TenLoaiKhachHang) {
        this.TenLoaiKhachHang = TenLoaiKhachHang;
    }

    public String getUuDai() {
        return UuDai;
    }

    public void setUuDai(String UuDai) {
        this.UuDai = UuDai;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

  
}
