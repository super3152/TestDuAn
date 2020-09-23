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
                System.out.println(loaikh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaikh; 
        
}
}
