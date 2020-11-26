/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOLoaiKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAOLoaiKhachHang {
      public static ArrayList<DTOLoaiKhachHang> GetLoaiKhachHang() {
        ResultSet rs;
        ArrayList<DTOLoaiKhachHang> loaikh = null;
        String cauTruyVan = "select * from loaikhachhang";
        rs = DBConection.GetData(cauTruyVan);
        loaikh = new ArrayList<DTOLoaiKhachHang>();
        try {
            while (rs.next()) {
                DTOLoaiKhachHang kh = new DTOLoaiKhachHang(rs.getInt("idloaikhachhang"), rs.getString("tenloaikhachhang"),rs.getString("uudai"), rs.getString("mota"));
                loaikh.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaikh; 
        
}
      public static ResultSet LayLoaiKhachHang(){
          String query = "select * from loaikhachhang";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
      public static ResultSet LayLoaiKhachHangTheoTen(String TenLKH){
          String query = "select * from loaikhachhang where tenloaikhachhang = '"+TenLKH+"'";
          ResultSet rs = DAO.DBConection.GetData(query);
          return rs;
      }
      public static int ThemLoaiKhachHang(DTOLoaiKhachHang lkh) {
        String cauTruyVan = "INSERT INTO `loaikhachhang`(`tenloaikhachhang`, `uudai`, `mota`) VALUES ('"+lkh.getTenLoaiKhachHang()+"','"+lkh.getUuDai()+"','"+lkh.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
     public static int SuaLoaiKhachHang(DTOLoaiKhachHang lkh) {
        String cauTruyVan = "UPDATE `loaikhachhang` SET `tenloaikhachhang`='"+lkh.getTenLoaiKhachHang()+"',`uudai`='"+lkh.getUuDai()+"'],`mota`='"+lkh.getMoTa()+"' WHERE `idloaikhachhang`='"+lkh.getIdLoaiKhachHang()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
 public static int XoaLoaiKhachHang(Integer MaLoaiKhachHang) {
        String cauTruyVan = "DELETE FROM `loaikhachhang` WHERE idloaikhachhang = '"+MaLoaiKhachHang+"'";
        System.out.println(cauTruyVan);
       return  DBConection.ExcuteTruyVan(cauTruyVan);
        
    }
}
