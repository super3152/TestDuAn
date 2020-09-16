/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;

/**
 *
 * @author Takemikazuchi
 */
public class DAOnguoidung {
      public static ResultSet DangNhap(String username) {
        //Tạo câu truy vấn 
        String cauTruyVan = "Select * from nguoidung "
                + "where tendangnhap = N'" + username + "'";
        //Thực thi câu truy vấn
        ResultSet rs = DBConection.GetData(cauTruyVan);

        return rs; //Trả về bảng kết quả
    }
}
