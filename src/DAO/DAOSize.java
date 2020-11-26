/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOSize;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOSize {
     public static ResultSet HienThiSizeSanPham() {
        String query = "SELECT * FROM `sizesanpham`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LaySizeSanPham(String MaSize) {
        String query = "SELECT * FROM `sizesanpham` WHERE `idsize` like '%" + MaSize + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LaySizeSanPhamTheoID(String MaSize) {
        String query = "SELECT * FROM `sizesanpham` WHERE `idsize` = '" + MaSize + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static int ThemSize(DTOSize size) {
        String cauTruyVan = "INSERT INTO `sizesanpham`(`tensize`,`mota`) VALUES ('"+size.getTenSize()+"','"+size.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
      
}
