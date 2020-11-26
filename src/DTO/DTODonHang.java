/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author KMB1604
 */
public class DTODonHang {
    int idhoadon ; 
    String SoHoaDon ; 
     int MaKhachHang ;
    String NgayTaoHoaDon ;
    String TimeTaoHoaDon ;
   int hinhthucthanhtoan;
   int tinhtrang;
    double TongTien ;
    int trangthaihoadon;
    String diachi;
    int sodienthoai;
 String view;
 int hinhthucvanchuyen;
 double tiengiaohang;
 
 
     public DTODonHang() {
       
    }
     
     public DTODonHang(double tiengiaohang,int hinhthucvanchuyen, int idhoadon) {
           this.tiengiaohang = tiengiaohang;
        this.hinhthucvanchuyen = hinhthucvanchuyen;
         this.idhoadon = idhoadon;
        
    }
     
     public DTODonHang(int idhoadon,String view) {
           this.idhoadon = idhoadon;
        this.view = view;
    }
     
      public DTODonHang(int idhoadon,int trangthaihoadon) {
           this.idhoadon = idhoadon;
        this.trangthaihoadon = trangthaihoadon;
    }
    
        
    public DTODonHang(int idhoadon, String SoHoaDon, int MaKhachHang, String NgayTaoHoaDon, int hinhthucthanhtoan, int tinhtrang, double TongTien, int trangthaihoadon, String diachi, int sodienthoai, String TimeTaoHoaDon, double tiengiaohang) {
        this.idhoadon = idhoadon;
        this.SoHoaDon = SoHoaDon;
        this.MaKhachHang = MaKhachHang;
        this.NgayTaoHoaDon = NgayTaoHoaDon;
        this.hinhthucthanhtoan = hinhthucthanhtoan;
        this.tinhtrang = tinhtrang;
        this.TongTien = TongTien;
        this.trangthaihoadon = trangthaihoadon;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.TimeTaoHoaDon = TimeTaoHoaDon;
          this.tiengiaohang = tiengiaohang;
    }

    public int getHinhthucvanchuyen() {
        return hinhthucvanchuyen;
    }

    public void setHinhthucvanchuyen(int hinhthucvanchuyen) {
        this.hinhthucvanchuyen = hinhthucvanchuyen;
    }

    public double getTiengiaohang() {
        return tiengiaohang;
    }

    public void setTiengiaohang(double tiengiaohang) {
        this.tiengiaohang = tiengiaohang;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getTimeTaoHoaDon() {
        return TimeTaoHoaDon;
    }

    public void setTimeTaoHoaDon(String TimeTaoHoaDon) {
        this.TimeTaoHoaDon = TimeTaoHoaDon;
    }

    
    
        
    public int getIdhoadon() {
        return idhoadon;
    }

    public void setIdhoadon(int idhoadon) {
        this.idhoadon = idhoadon;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }

    public int getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(int MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getNgayTaoHoaDon() {
        return NgayTaoHoaDon;
    }

    public void setNgayTaoHoaDon(String NgayTaoHoaDon) {
        this.NgayTaoHoaDon = NgayTaoHoaDon;
    }

    public int getHinhthucthanhtoan() {
        return hinhthucthanhtoan;
    }

    public void setHinhthucthanhtoan(int hinhthucthanhtoan) {
        this.hinhthucthanhtoan = hinhthucthanhtoan;
    }

    public int getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(int tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public int getTrangthaihoadon() {
        return trangthaihoadon;
    }

    public void setTrangthaihoadon(int trangthaihoadon) {
        this.trangthaihoadon = trangthaihoadon;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(int sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    
   
}
