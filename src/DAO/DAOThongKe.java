/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOThongke;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author KMB1604
 */
public class DAOThongKe {
     public static ResultSet LayThongKeSanPhamBanChay() {

        String query = "SELECT sanpham.idsanpham,sanpham.tensanpham,SUM(chitiethoadon.soluong),SUM(chitiethoadon.thanhtien) FROM hoadon INNER JOIN chitiethoadon ON hoadon.idhoadon = chitiethoadon.idhoadon INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham  GROUP BY sanpham.idsanpham ORDER BY SUM(chitiethoadon.soluong) DESC";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      public static ResultSet LayThongKeSanPham(String tukhoa) {

        String query = "SELECT sanpham.idsanpham,sanpham.tensanpham,SUM(chitiethoadon.soluong),SUM(chitiethoadon.thanhtien) FROM hoadon INNER JOIN chitiethoadon ON hoadon.idhoadon = chitiethoadon.idhoadon INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham  where sanpham.idsanpham like '%" + tukhoa + "%' or sanpham.tensanpham like '%" + tukhoa + "%'  GROUP BY sanpham.idsanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     
      public static ResultSet TimKiemSanPhamTheoNgay(String ngaybatdau, String ngayketthuc) {

        String query = "SELECT sanpham.idsanpham,sanpham.tensanpham,SUM(chitiethoadon.soluong),SUM(chitiethoadon.thanhtien) FROM hoadon INNER JOIN chitiethoadon ON hoadon.idhoadon = chitiethoadon.idhoadon INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham  WHERE hoadon.ngaytaohoadon >= '"+ ngaybatdau +"' and hoadon.ngaytaohoadon <= '"+ ngayketthuc +"' GROUP BY sanpham.idsanpham";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        public static ResultSet LayThongKeHoaDon() {

        String query = "SELECT idhoadon,sohoadon,ngaytaohoadon,nguoidung.tennguoidung,congno,tongtien FROM hoadon INNER JOIN nguoidung ON nguoidung.idnguoidung = hoadon.idnguoidung";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
        
             public static ResultSet LayThongPhieuNhap() {

        String query = "SELECT idphieunhap, sophieunhap, ngaynhap, congno,  thanhtien FROM phieunhap";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
           
              public static ResultSet LayThongKeSanPhamBanChay2() {

        String query = "SELECT sanpham.idsanpham,sanpham.tensanpham,SUM(chitiethoadon.soluong), sanpham.anhsanpham FROM hoadon INNER JOIN chitiethoadon ON hoadon.idhoadon = chitiethoadon.idhoadon INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham GROUP BY sanpham.idsanpham ORDER BY SUM(chitiethoadon.soluong) DESC";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
              public static ResultSet LayThongKe7Ngay(String Ngay ) {

        String query = "SELECT hoadon.ngaytaohoadon,SUM(chitiethoadon.soluong),SUM(chitiethoadon.thanhtien),hoadon.idhoadon,chitiethoadon.idchitiethoadon, sanpham.tensanpham, sanpham.idsanpham FROM hoadon INNER JOIN chitiethoadon ON hoadon.idhoadon = chitiethoadon.idhoadon INNER JOIN sanpham ON sanpham.idsanpham = chitiethoadon.idsanpham WHERE hoadon.ngaytaohoadon = '"+Ngay+"'   GROUP BY hoadon.ngaytaohoadon";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
      
}
