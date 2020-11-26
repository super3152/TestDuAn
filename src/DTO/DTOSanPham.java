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
    double GiaBanLe;
    double GiaBanBuon;
    double GiaNhap;
    int KhoiLuong;
    String DonViTinh;
    int TonKho;
    int IDLoaiSanPham;
    int IDHangSanPham;
    String ThuocTinhKhachHang;
    byte[] AnhSanPham;
    int IDSize;
    int IDMauSanPham;
    int IDKe;

    public DTOSanPham() {
    }

    public DTOSanPham(int IDSanPham, int TonKho) {
        this.IDSanPham = IDSanPham;
        this.TonKho = TonKho;
    }

    public DTOSanPham(int IDSanPham, String TenSanPham, String NgayTao, String MaSanPham, String MoTaSanPham, double GiaBanLe, double GiaBanBuon, double GiaNhap, int KhoiLuong, String DonViTinh, int TonKho, int IDLoaiSanPham, int IDHangSanPham, String ThuocTinhKhachHang, byte[] AnhSanPham, int IDSize, int IDMauSanPham, int IDKe) {
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
        this.ThuocTinhKhachHang = ThuocTinhKhachHang;
        this.AnhSanPham = AnhSanPham;
        this.IDSize = IDSize;
        this.IDMauSanPham = IDMauSanPham;
        this.IDKe = IDKe;
    }

    public DTOSanPham(String TenSanPham, String NgayTao, String MaSanPham, String MoTaSanPham, double GiaBanLe, double GiaBanBuon, double GiaNhap, int KhoiLuong, String DonViTinh, int TonKho, int IDLoaiSanPham, int IDHangSanPham, String ThuocTinhKhachHang, byte[] AnhSanPham, int IDSize, int IDMauSanPham, int IDKe) {
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
        this.ThuocTinhKhachHang = ThuocTinhKhachHang;
        this.AnhSanPham = AnhSanPham;
        this.IDSize = IDSize;
        this.IDMauSanPham = IDMauSanPham;
        this.IDKe = IDKe;
    }

    public DTOSanPham(String TenSanPham, byte[] AnhSanPham) {
        this.TenSanPham = TenSanPham;
        this.AnhSanPham = AnhSanPham;
    }
    
   

    public DTOSanPham(int IDSanPham, double GiaNhap, int TonKho) {
        this.IDSanPham = IDSanPham;
        this.GiaNhap = GiaNhap;
        this.TonKho = TonKho;
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

    public double getGiaBanLe() {
        return GiaBanLe;
    }

    public void setGiaBanLe(double GiaBanLe) {
        this.GiaBanLe = GiaBanLe;
    }

    public double getGiaBanBuon() {
        return GiaBanBuon;
    }

    public void setGiaBanBuon(double GiaBanBuon) {
        this.GiaBanBuon = GiaBanBuon;
    }

    public double getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(double GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public int getKhoiLuong() {
        return KhoiLuong;
    }

    public void setKhoiLuong(int KhoiLuong) {
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

    public String getThuocTinhKhachHang() {
        return ThuocTinhKhachHang;
    }

    public void setThuocTinhKhachHang(String ThuocTinhKhachHang) {
        this.ThuocTinhKhachHang = ThuocTinhKhachHang;
    }

    public byte[] getAnhSanPham() {
        return AnhSanPham;
    }

    public void setAnhSanPham(byte[] AnhSanPham) {
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
