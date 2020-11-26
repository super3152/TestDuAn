/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTODonHang;
import DTO.DTOHinhThucGiaoHang;
import java.sql.ResultSet;

/**
 *
 * @author KMB1604
 */
public class DAODonHang {
    public static ResultSet LayDonHang(String TuKhoa) {

        String query = "SELECT * FROM `hoadon` where loaihoadon = '1'  ORDER BY ngaytaohoadon DESC";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
      public static ResultSet LayChiTietDonHang(String TuKhoa) {

        String query = "SELECT * FROM `chitiethoadon`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
    
     public static ResultSet LayDonHangTheoMa(int MaDonHang) {

        String query = "SELECT * FROM `hoadon` WHERE idhoadon = '"+MaDonHang+"'";
        ResultSet rs = DBConection.GetData(query);
         System.out.println(query);
          System.out.println(rs);
        return rs;
    }
     
     public static ResultSet LayKhachHang(int MaKhachHang) {
        String query = "SELECT * FROM khachhang where idkhachhang = '"+MaKhachHang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     
      public static ResultSet LayKhachHangNotLogin(int MaNonKhachHang) {
        String query = "SELECT * FROM nonkhachhang where idnonkhachhang = '"+MaNonKhachHang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
       public static int SuaDonHang(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`trangthaihoadon`='"+dh.getTrangthaihoadon()+"'"             
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
       
       
           public static int SuaDonHangView(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`view`='"+dh.getTrangthaihoadon()+"'"             
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
       
       
       
    public static ResultSet laychitietdonhang(int iddonhang) {

        String query = "SELECT chitiethoadon.idchitiethoadon, sanpham.anhsanpham, sanpham.masanpham, sanpham.tensanpham, sanpham.idsizesanpham, sanpham.idmausanpham, chitiethoadon.soluong, sanpham.giabanle, chitiethoadon.uudai, chitiethoadon.thanhtien FROM `chitiethoadon` INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham INNER JOIN hoadon ON hoadon.idhoadon = chitiethoadon.idhoadon WHERE hoadon.idhoadon = '"+iddonhang+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }    
       
    
      public static int SuaTienGiaoHang(DTODonHang dh) {
        String cauTruyVan = "UPDATE `hoadon`"
                + " SET "
                + "`idhinhthuc`='"+dh.getHinhthucvanchuyen()+"',"              
                + "`tiengiaohang`='"+dh.getTiengiaohang()+"' "
                + "WHERE `idhoadon`='"+dh.getIdhoadon()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
      
       public static int ThemHinhThuc(DTOHinhThucGiaoHang hinhthuc) {
        String cauTruyVan = "INSERT INTO `hinhthucgiaohang`(`tenhinhthuc`,`mota`) VALUES ('"+hinhthuc.getTenHinhThuc()+"','"+hinhthuc.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

        public static ResultSet LayHinhThuc(String idHinhThuc) {
        String query = "SELECT * FROM `hinhthucgiaohang` WHERE `idhinhthuc` like '%" + idHinhThuc + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayHinhThucTheoID(int idHinhThuc) {
        String query = "SELECT * FROM `hinhthucgiaohang` WHERE `idhinhthuc` = '" + idHinhThuc + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet HienThiHinhThuc() {
        String query = "SELECT * FROM `hinhthucgiaohang`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       
       
       
       
}
