/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOChiTietHoaDon;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOChiTietHoaDon {

    public static int ThemChiTietHoaDon(DTOChiTietHoaDon cthd) {
        String query = "INSERT INTO `chitiethoadon`(`idhoadon`, `idsanpham`, `soluong`, `thanhtien`, `uudai`, `ghichu`)"
                + " VALUES ("
                + "'" + cthd.getMaHoaDon() + "',"
                + "'" + cthd.getMaSanPham() + "',"
                + "'" + cthd.getSoLuong() + "',"
                + "'" + cthd.getThanhTien() + "',"
                + "'" + cthd.getUuDai() + "',"
                + "'" + cthd.getGhiChu() + "')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }
     public static int SuaChiTietHoaDon(DTOChiTietHoaDon cthd) {
        String query = "UPDATE `chitiethoadon` SET `soluong`='"+cthd.getSoLuong()+"',`thanhtien`='"+cthd.getThanhTien()+"' WHERE `idchitiethoadon`='"+cthd.getMaCTHD()+"'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }
     public static ResultSet LayCTHDTheoMaHD(int MaHD){
         String query = "Select * from chitiethoadon where idhoadon = '"+MaHD+"'";
         ResultSet rs = DAO.DBConection.GetData(query);
         return rs;
     }
    
}
