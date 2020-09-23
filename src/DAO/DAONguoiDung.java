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
public class DAONguoiDung {
      public static ResultSet DangNhap(String TenDangNhap) {

            String query = "SELECT * FROM `nguoidung` WHERE `tendangnhap` = '"+TenDangNhap+"'";
             ResultSet rs = DBConection.GetData(query);
            return rs;
    }

}
