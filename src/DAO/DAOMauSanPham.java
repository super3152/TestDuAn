/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOMauSanPham;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOMauSanPham {
    public static ResultSet LayMauSanPham(String idMauSP) {
        String query = "SELECT * FROM `mausanpham` WHERE `idmausanpham` like '%" + idMauSP + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayMauSanPhamTheoID(String idMauSP) {
        String query = "SELECT * FROM `mausanpham` WHERE `idmausanpham` = '" + idMauSP + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static int ThemMau(DTOMauSanPham mau) {
        String cauTruyVan = "INSERT INTO `mausanpham`(`tenmausanpham`,`mota`) VALUES ('"+mau.getTenMauSanPham()+"','"+mau.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
      public static ResultSet HienThiMauSanPham() {
        String query = "SELECT * FROM `mausanpham`";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
