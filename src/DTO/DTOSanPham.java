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
public class DTOSanPham {
    int IDSanPham;
    String TenSanPham;
    String NgayTao;
    String MaSanPham;
    String MoTaSanPham;
    String GiaBanLe;
    String GiaBanBuon;
    String GiaNhap;
    String KhoiLuong;
    String DonViTinh;
    int TonKho;
    int IDLoaiSanPham;
    int IDHangSanPham;
    String Tag;
    String AnhSanPham;
    int IDSize;
    int IDMauSanPham;
    int IDKe;

    public DTOSanPham() {
    }

    public DTOSanPham(int IDSanPham, String TenSanPham, String NgayTao, String MaSanPham, String MoTaSanPham, String GiaBanLe, String GiaBanBuon, String GiaNhap, String KhoiLuong, String DonViTinh, int TonKho, int IDLoaiSanPham, int IDHangSanPham, String Tag, String AnhSanPham, int IDSize, int IDMauSanPham, int IDKe) {
        this.IDSanPham = IDSanPham;
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.MaSanPham = MaSanPham;
        this.MoTaSanPham = MoTaSanPham;
        this.GiaBanLe = GiaBanLe;
        this.GiaBanBuon = GiaBanBuon;
        this.GiaNhap = GiaNhap;
        this.KhoiLuong = KhoiLuong;
        this.DonViTinh = DonViTinh;
        this.TonKho = TonKho;
        this.IDLoaiSanPham = IDLoaiSanPham;
        this.IDHangSanPham = IDHangSanPham;
        this.Tag = Tag;
        this.AnhSanPham = AnhSanPham;
        this.IDSize = IDSize;
        this.IDMauSanPham = IDMauSanPham;
        this.IDKe = IDKe;
    }

    public DTOSanPham(String TenSanPham, String NgayTao, String MaSanPham, String MoTaSanPham, String GiaBanLe, String GiaBanBuon, String GiaNhap, String KhoiLuong, String DonViTinh, int TonKho, int IDLoaiSanPham, int IDHangSanPham, String Tag, String AnhSanPham, int IDSize, int IDMauSanPham, int IDKe) {
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.MaSanPham = MaSanPham;
        this.MoTaSanPham = MoTaSanPham;
        this.GiaBanLe = GiaBanLe;
        this.GiaBanBuon = GiaBanBuon;
        this.GiaNhap = GiaNhap;
        this.KhoiLuong = KhoiLuong;
        this.DonViTinh = DonViTinh;
        this.TonKho = TonKho;
        this.IDLoaiSanPham = IDLoaiSanPham;
        this.IDHangSanPham = IDHangSanPham;
        this.Tag = Tag;
        this.AnhSanPham = AnhSanPham;
        this.IDSize = IDSize;
        this.IDMauSanPham = IDMauSanPham;
        this.IDKe = IDKe;
    }

    public int getIDSanPham() {
        return IDSanPham;
    }

    public void setIDSanPham(int IDSanPham) {
        this.IDSanPham = IDSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getMoTaSanPham() {
        return MoTaSanPham;
    }

    public void setMoTaSanPham(String MoTaSanPham) {
        this.MoTaSanPham = MoTaSanPham;
    }

    public String getGiaBanLe() {
        return GiaBanLe;
    }

    public void setGiaBanLe(String GiaBanLe) {
        this.GiaBanLe = GiaBanLe;
    }

    public String getGiaBanBuon() {
        return GiaBanBuon;
    }

    public void setGiaBanBuon(String GiaBanBuon) {
        this.GiaBanBuon = GiaBanBuon;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public String getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(String KhoiLuong) {
        this.KhoiLuong = KhoiLuong;
    }

    public String getDonViTinh() {
        return DonViTinh;
    }

    public void setDonViTinh(String DonViTinh) {
        this.DonViTinh = DonViTinh;
    }

    public int getTonKho() {
        return TonKho;
    }

    public void setTonKho(int TonKho) {
        this.TonKho = TonKho;
    }

    public int getIDLoaiSanPham() {
        return IDLoaiSanPham;
    }

    public void setIDLoaiSanPham(int IDLoaiSanPham) {
        this.IDLoaiSanPham = IDLoaiSanPham;
    }

    public int getIDHangSanPham() {
        return IDHangSanPham;
    }

    public void setIDHangSanPham(int IDHangSanPham) {
        this.IDHangSanPham = IDHangSanPham;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String Tag) {
        this.Tag = Tag;
    }

    public String getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(String AnhSanPham) {
        this.AnhSanPham = AnhSanPham;
    }

    public int getIDSize() {
        return IDSize;
    }

    public void setIDSize(int IDSize) {
        this.IDSize = IDSize;
    }

    public int getIDMauSanPham() {
        return IDMauSanPham;
    }

    public void setIDMauSanPham(int IDMauSanPham) {
        this.IDMauSanPham = IDMauSanPham;
    }

    public int getIDKe() {
        return IDKe;
    }

    public void setIDKe(int IDKe) {
        this.IDKe = IDKe;
    }
    
    
}
