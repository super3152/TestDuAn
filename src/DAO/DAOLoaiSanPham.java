/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOLoaiSanPham {
    public static ResultSet LayLoaiSanPham(String MaLoaiSanPham) {
          String query = "SELECT * FROM `loaisanpham` WHERE `idloaisanpham` like '%" + MaLoaiSanPham + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayLoaiSanPhamTheoID(String MaLoaiSanPham) {
        String query = "SELECT * FROM `loaisanpham` WHERE `idloaisanpham` = '" + MaLoaiSanPham + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
