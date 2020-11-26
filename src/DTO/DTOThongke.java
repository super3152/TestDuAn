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
public class DTOThongke {
    String ngaybatdau;
    String Ngayketthuc;
     int Ngay;

     
      public DTOThongke(int Ngay) {     
        this.Ngay = Ngay;
    }
    public DTOThongke(String ngaybatdau, String Ngayketthuc) {
        this.ngaybatdau = ngaybatdau;
        this.Ngayketthuc = Ngayketthuc;
    }

    
     public DTOThongke() {
       
    }

    public int getNgay() {
        return Ngay;
    }

    public void setNgay(int Ngay) {
        this.Ngay = Ngay;
    }
    
    
    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return Ngayketthuc;
    }

    public void setNgayketthuc(String Ngayketthuc) {
        this.Ngayketthuc = Ngayketthuc;
    }
    
    
}
