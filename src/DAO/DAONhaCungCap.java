/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTONhaCungCap;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAONhaCungCap {
    public static int SuaNhapHangNCC(DTONhaCungCap ncc){
        String query = "UPDATE `nhacungcap` SET `lancuoinhaphang`='"+ncc.getLanCuoiNhapHang()+"',`tongtienhang`='"+ncc.getTongTienHang()+"',`congno`='"+ncc.getCongNo()+"' WHERE `idnhacungcap`='"+ncc.getIDNhaCungCap()+"'";
        System.out.println(query);
        return DAO.DBConection.ExcuteTruyVan(query);
    }
    public static int SuaCongNoNCC(DTONhaCungCap ncc){
        String query = "UPDATE `nhacungcap` SET `congno`='"+ncc.getCongNo()+"' WHERE `idnhacungcap`='"+ncc.getIDNhaCungCap()+"'";
        System.out.println(query);
        return DAO.DBConection.ExcuteTruyVan(query);
    }
    public static ResultSet LayNCCTheoMa(int MaNCC){
        String query = "Select * from nhacungcap where idnhacungcap = '"+MaNCC+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayPhieuNhapTheoMaNCC(int MaNCC){
        String query = "Select * from phieunhap where idnhacungcap = '"+MaNCC+"'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayNhaCungCap(String TuKhoa) {

        String query = "SELECT * FROM nhacungcap where tennhacungcap like '%" + TuKhoa + "%' or idnhacungcap like '%" + TuKhoa + "%' or manhacungcap like '%" + TuKhoa + "%' or idloainhacungcap like '%" + TuKhoa + "%' or idnguoidung like '%" + TuKhoa + "%'";
        ResultSet rs = DBConection.GetData(query);    
        return rs;
    }
     public static ResultSet LayNguoiDung(String TuKhoa) {
        String query = "SELECT * FROM nguoidung where tennguoidung like '%" + TuKhoa + "%' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayNhaCungCapTheoMa(int MaNhaCungCap) {
        String query = "SELECT * FROM nhacungcap where idnhacungcap =  '" + MaNhaCungCap + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    
     public static ResultSet LayNhaCungCapTheoMaLoai(int MaLoaiNhaCungCap) {
        String query = "SELECT * FROM loainhacungcap where idloainhacungcap = '" + MaLoaiNhaCungCap + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }
    
        public static ResultSet LayMaNguoiDungCBB(int MaNguoiDung) {

        String query = "SELECT * FROM nguoidung where idnguoidung = '" + MaNguoiDung + "' ";
            System.out.println(query);
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
     
          public static ResultSet LayNguoiDungCBB() {

        String query = "SELECT * FROM nguoidung";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
          public static ResultSet LayLoaiNhaCungCapCBB() {

        String query = "SELECT * FROM loainhacungcap";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
           public static ResultSet LayNhacCungCapCBB() {

        String query = "SELECT * FROM nhacungcap";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
           
           public static int ThemNhaCungCap(DTONhaCungCap ncc) {
        String cauTruyVan = "INSERT INTO `nhacungcap`"
                + "(`tennhacungcap`, `manhacungcap`, `idloainhacungcap`, `sodienthoai`, `email`, `diachi`, `tinh`, `sofax`, `masothue`, `website`, `idnguoidung`, `trangthai`, `tag`,`mota` )"
                + " VALUES "
                + "('"+ncc.getTenNhaCungCap()+"',"
                + "'"+ncc.getMaNhaCungCap()+"',"
                + "'"+ncc.getMaLoaiNhaCungCap()+"',"
                + "'"+ncc.getSoDienThoai()+"',"
                + "'"+ncc.getEmail()+"',"
                + "'"+ncc.getDiaChi()+"',"
                + "'"+ncc.getTinh()+"',"
                + "'"+ncc.getSoFax()+"',"
                + "'"+ncc.getMaSoThue()+"',"
                + "'"+ncc.getWebSite()+"',"
                + "'"+ncc.getMaNguoiDung()+"',"
                + "'"+ncc.getTrangThai()+"',"
                 + "'"+ncc.getTag()+"',"
                + "'"+ncc.getMoTa()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
           
          public static int SuaNhaCungCap(DTONhaCungCap ncc) {
        String cauTruyVan = "UPDATE `nhacungcap`"
                + " SET " 
                + "`tennhacungcap`='"+ncc.getTenNhaCungCap()+"',"
                + "`manhacungcap`='"+ncc.getMaNhaCungCap()+"',"
                + "`idloainhacungcap`='"+ncc.getMaLoaiNhaCungCap()+"',"
                + "`sodienthoai`='"+ncc.getSoDienThoai()+"',"
                + "`email`='"+ncc.getEmail()+"',"
                + "`diachi`='"+ncc.getDiaChi()+"',"
                + "`tinh`='"+ncc.getTinh()+"',"
                + "`sofax`='"+ncc.getSoFax()+"',"
                + "`masothue`="+ncc.getMaSoThue()+","
                + "`website`='"+ncc.getWebSite()+"',"
                + "`idnguoidung`='"+ncc.getIDNhaCungCap()+"',"
                + "`trangthai`='"+ncc.getTrangThai()+"',"
                + "`tag`='"+ncc.getTag()+"',"
                + "`mota`='"+ncc.getMoTa()+"' "
                + "WHERE `idnhacungcap`='"+ncc.getIDNhaCungCap()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }  
           public static int TraNoNhaCungCap(DTONhaCungCap ncc) {
        String cauTruyVan = "UPDATE `nhacungcap` SET `congno`='"+ncc.getCongNo()+"' WHERE `idnhacungcap`='"+ncc.getIDNhaCungCap()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }  
           
           
            public static int XoaNhaCungCap(Integer MaNhaCungCap) {
        String cauTruyVan = "DELETE FROM `nhacungcap` WHERE idnhacungcap = '"+MaNhaCungCap+"'";
        System.out.println(cauTruyVan);
       return  DBConection.ExcuteTruyVan(cauTruyVan);
        
    }
            
              public static ResultSet LayNhaCungCapLoc(String idloainhacungcap, String idnguoidung) {
        String query = "SELECT "
                + "* "
                + "FROM "
                + "nhacungcap "
                + "WHERE "
                + "idloainhacungcap = '" + idloainhacungcap + "'"
                + "AND idnguoidung = '" + idnguoidung + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
