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
public class DAOPhatLuong {
    public static ResultSet Layphatluong(){
        String query= "SELECT * FROM phatluong";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;       
    }
        public static ResultSet LayMaNhanVien(int MaNhanVien) {
        String query = "SELECT * FROM nguoidung where idnguoidung =  '" + MaNhanVien + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        public static ResultSet Layluong(int MaLuong){
            String query = "SELECT * FROM luong where idluong = '"+MaLuong+"'";
            ResultSet rs = DAO.DBConection.GetData(query);
            return rs;
        }
        public static ResultSet LayPhatLuongTheoID(int MaPhatLuong){
            String query = "SELECT * FROM phatluong where idphatluong = '"+MaPhatLuong+"'";
            ResultSet rs = DAO.DBConection.GetData(query);
            return rs;
        }
         public static int PhatLuong(DTO.DTOPhatLuong pl) {
        String cauTruyVan = "INSERT INTO `phatluong`"
                + "(`idnguoidung`, `idluong`, `ngayphat`, `songaydilam`, `songaynghi`, `tienthuong`, `tienphat`, `tongluong`, `ghichu`)"
                + " VALUES "
                + "('"+pl.getMaNV()+"',"
                + "'"+pl.getMaLuong()+"',"
                + "'"+pl.getNgayPhat()+"',"
                + "'"+pl.getSoNgayDiLam()+"',"
                + "'"+pl.getSoNgayNghi()+"',"
                + "'"+pl.getTienThuong()+"',"
                + "'"+pl.getTienPhat()+"',"
                + "'"+pl.getTongLuong()+"',"
                + "'"+pl.getGhiChu()+"')";
        System.out.println(cauTruyVan);
         return  DBConection.ExcuteTruyVan(cauTruyVan);
       
    }
}
