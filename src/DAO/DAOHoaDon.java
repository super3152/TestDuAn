/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOHoaDon;
import DTO.DTOSanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAOHoaDon {
     public static ResultSet LayHoaDon(String TuKhoa) {
        String query = "Select * from hoadon where idhoadon like '%" + TuKhoa + "%' or sohoadon like '%" + TuKhoa + "%' or ngaytaohoadon like '%" + TuKhoa + "%' or idnguoidung like '%" + TuKhoa + "%' or tongtien like '%" + TuKhoa + "%' or idkhachhang like '%" + TuKhoa + "%' or congno like '%" + TuKhoa + "%'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayPhieuNhapTheoID(String IDPhieuNhap) {
        String query = "SELECT * FROM `phieunhap` WHERE `idphieunhap`= '" + IDPhieuNhap + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayCTHDTheoMaHD(int MaHD) {
        String query = "SELECT * FROM `chitiethoadon` WHERE `idhoadon`= '" + MaHD + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static int ThemHoaDon(DTOHoaDon hd) {
        String query = "INSERT INTO `hoadon`"
                + "( `sohoadon`, `ngaytaohoadon`, `idnguoidung`, `tinhtrang`, `tongtien`, `idkhachhang`, `trahang`, `congno`)"
                + " VALUES "
                + "('" + hd.getSoHoaDon() + "',"
                + "'" + hd.getNgayTaoHoaDon() + "',"
                + "'" + hd.getMaNV() + "',"
                + "'" + hd.getTinhTrang() + "',"
                + "'" + hd.getTongTien() + "',"
                + "'" + hd.getMaKhachHang() + "',"
                + "'" + hd.getTraHang() + "',"
                + "'" + hd.getCongNo() + "')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }

    public static ResultSet GetByTenHD(String SoHoaDon) {
        String cauTruyVan = "select * from hoadon where sohoadon = '" + SoHoaDon + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
    public static ResultSet GetByTenNV(String TenNV) {
        String cauTruyVan = "select * from nguoidung where tennguoidung = '" + TenNV + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
     public static ResultSet GetByMaSP(String MaSP) {
        String cauTruyVan = "select * from sanpham where masanpham = '" + MaSP + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }
    public static void SuaTrangThai(DTOHoaDon HD) {
        String query = "UPDATE `hoadon` SET `tinhtrang`='"+HD.getTinhTrang()+"' WHERE `sohoadon`='"+HD.getSoHoaDon()+"'";
        System.out.println(query);
        DBConection.ExcuteTruyVan(query);

    }

    public static void SuaTrangThaiHanNoHoaDon(DTOHoaDon HD) {
        String query = "UPDATE `hoadon` SET `tinhtrang`='"+HD.getTinhTrang()+"', `congno`='"+HD.getCongNo()+"',`hantracongno`='"+HD.getHanTraCongNo()+"' WHERE `sohoadon`='"+HD.getSoHoaDon()+"'";
        System.out.println(query);
        DBConection.ExcuteTruyVan(query);

    }
    public static void SuaNoHoaDonPhieuTra(DTOHoaDon HD) {
        String query = "UPDATE `hoadon` SET `congno`='" + HD.getCongNo() + "' WHERE `sohoadon`='" + HD.getSoHoaDon() + "'";
        System.out.println(query);
        DBConection.ExcuteTruyVan(query);

    }
     public static void SuaTraHangHoaDon(DTOHoaDon HD) {
        String query = "UPDATE `hoadon` SET `trahang`='" + HD.getTraHang() + "' WHERE `idhoadon`='" + HD.getMaHoaDon() + "'";
        System.out.println(query);
        DBConection.ExcuteTruyVan(query);

    }
     public static void TraNoHoaDon(DTOHoaDon HD) {
        String query = "UPDATE `hoadon` SET `tinhtrang`='"+HD.getTinhTrang()+"', `congno`='" + HD.getCongNo() + "' WHERE `idhoadon`='" + HD.getMaHoaDon() + "'";
        System.out.println(query);
        DBConection.ExcuteTruyVan(query);

    }

    public static ResultSet LayHoaDonTheoMa(int MaHD) {
        String query = "Select * from hoadon where idhoadon = '" + MaHD + "'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;

    }

    public static ResultSet LayHoaDonTheoSoHD(String SoHD) {
        String query = "Select * from hoadon where sohoadon = '" + SoHD + "'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;

    }
    public static ArrayList<DTOSanPham> GetSanPhamHayDung() {
        ResultSet rs;
        ArrayList<DTOSanPham> sanpham = null;
        String cauTruyVan = "SELECT DISTINCT chitiethoadon.`idsanpham` AS idsanpham, sanpham.`tensanpham` AS tensanpham, sanpham.`anhsanpham` AS anhsanpham "
                + "FROM `chitiethoadon` chitiethoadon INNER JOIN `sanpham` sanpham ON chitiethoadon.`idsanpham` = sanpham.`idsanpham` LIMIT 5";
        rs = DBConection.GetData(cauTruyVan);
        sanpham = new ArrayList<DTOSanPham>();
        try {
            while (rs.next()) {
                DTOSanPham sp = new DTOSanPham(rs.getString("tensanpham"), rs.getBytes("anhsanpham"));
                sanpham.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanpham;

    }

}
