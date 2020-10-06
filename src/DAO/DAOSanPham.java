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
public class DAOSanPham {
       public static ResultSet LaySanPham() {
        String query = "SELECT * FROM sanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
       public static ResultSet LayLoaiSanPham(int MaLoaiSanPham) {
        String query = "SELECT * FROM loaisanpham where idloaisanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
              public static ResultSet LayHangSanPham(int MaHangSanPham) {
        String query = "SELECT * FROM hangsanpham where idhangsanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
                   public static ResultSet LaySizeSanPham(int MaSizeSanPham) {
        String query = "SELECT * FROM sizesanpham where idsize";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
                        public static ResultSet LayMauSanPham(int MaMauSanPham) {
        String query = "SELECT * FROM mausanpham where idmausanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
