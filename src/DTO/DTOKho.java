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
public class DTOKho {
    int IDKho;
    int IDSanPham;
    int IDPhieuNhap;
    int TonKho;
    int HangDangVe;
    String TrangThai;

    public DTOKho() {
    }
    

    public DTOKho(int IDKho, int IDSanPham, int IDPhieuNhap, int TonKho, int HangDangVe, String TrangThai) {
        this.IDKho = IDKho;
        this.IDSanPham = IDSanPham;
        this.IDPhieuNhap = IDPhieuNhap;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
        this.TrangThai = TrangThai;
    }

    public DTOKho(int IDSanPham, int IDPhieuNhap, int TonKho, int HangDangVe, String TrangThai) {
        this.IDSanPham = IDSanPham;
        this.IDPhieuNhap = IDPhieuNhap;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
        this.TrangThai = TrangThai;
    }

    public DTOKho(int IDSanPham, int TonKho, int HangDangVe) {
        this.IDSanPham = IDSanPham;
        this.TonKho = TonKho;
        this.HangDangVe = HangDangVe;
    }

    public DTOKho(int IDSanPham, int HangDangVe) {
        this.IDSanPham = IDSanPham;
        this.HangDangVe = HangDangVe;
    }

    


    public int getIDKho() {
        return IDKho;
    }

    public void setIDKho(int IDKho) {
        this.IDKho = IDKho;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public int getIDPhieuNhap() {
        return IDPhieuNhap;
    }

    public void setIDPhieuNhap(int IDPhieuNhap) {
        this.IDPhieuNhap = IDPhieuNhap;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getHangDangVe() {
        return HangDangVe;
    }

    public void setHangDangVe(int HangDangVe) {
        this.HangDangVe = HangDangVe;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

  
}
