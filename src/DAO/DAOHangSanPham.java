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
public class DAOHangSanPham {
      public static ResultSet LayHangSanPham(String IDHang) {
        String query = "SELECT * FROM `hangsanpham` WHERE `idhangsanpham` like '%" + IDHang + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayHangSanPhamTheoid(String IDHang) {
        String query = "SELECT * FROM `hangsanpham` WHERE `idhangsanpham` = '" + IDHang + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
