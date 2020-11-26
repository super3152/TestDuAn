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
public class DTOHinhThucGiaoHang {
      int IDHinhThucGiaoHang;
    String TenHinhThuc;
    String MoTa;

    public DTOHinhThucGiaoHang( String TenHinhThuc, String MoTa) {
      
        this.TenHinhThuc = TenHinhThuc;
        this.MoTa = MoTa;
    }
     public DTOHinhThucGiaoHang() {
      
    }

    public int getIDHinhThucGiaoHang() {
        return IDHinhThucGiaoHang;
    }

    public void setIDHinhThucGiaoHang(int IDHinhThucGiaoHang) {
        this.IDHinhThucGiaoHang = IDHinhThucGiaoHang;
    }

    public String getTenHinhThuc() {
        return TenHinhThuc;
    }

    public void setTenHinhThuc(String TenHinhThuc) {
        this.TenHinhThuc = TenHinhThuc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }
    
    
    
}

