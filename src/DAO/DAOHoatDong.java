/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOHoatDong;
import java.sql.ResultSet;

/**
 *
 * @author KMB1604
 */
public class DAOHoatDong {
    
      public static ResultSet LayHoatDong() {
        String query = "SELECT * FROM `hoatdong` ORDER BY thoigianhoatdong DESC";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
       public static ResultSet LayLoaiHoatDong(String LoaiHoatDong) {
        String query = "SELECT * FROM `loaihoatdong` WHERE `idloaihoatdong` like '%" + LoaiHoatDong + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
         public static ResultSet LayNguoiDung(String NguoiDung) {
        String query = "SELECT * FROM `nguoidung` WHERE `idnguoidung` like '%" + NguoiDung + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       
      
      public static void ThemHoatDong(DTOHoatDong hd) {
        DAO.DAOHoatDong.ThemHoatDong(hd);
    }
      public static int XoaHoatDong(Integer MaHoatDong) {
        String cauTruyVan = "DELETE FROM `hoatdong` WHERE idhoatdong = '"+MaHoatDong+"'";
        System.out.println(cauTruyVan);
       return  DBConection.ExcuteTruyVan(cauTruyVan);
        
    }
}
