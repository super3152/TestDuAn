/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
import GUI.pnlkhachhang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class DAOKhachHang {



    public static ResultSet LayLoaiKhachHangCBB() {

            String query = "SELECT * FROM loaikhachhang";
             ResultSet rs = DBConection.GetData(query);
            return rs;
    }

    public static ResultSet LayMaLoaiKhachHangCBB(int MaLoaiKhachHang) {

        String query = "SELECT * FROM loaikhachhang where idloaikhachhang = '" + MaLoaiKhachHang + "' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayKhachHangTheoMaLoai(int MaLoaiKhachHang) {

            String query = "SELECT * FROM khachhang where idloaikhachhang = '" + MaLoaiKhachHang + "'";
            ResultSet rs = DBConection.GetData(query);
            return rs;

    }

    public static ResultSet LayKhachHang() {
       
            String query = "SELECT * FROM khachhang";
           ResultSet rs = DBConection.GetData(query);
           System.out.println(query);
           return rs;
    }
      public static ResultSet LayKhachHangTheoMa(int MaKhachHang) {
       
            String query = "SELECT * FROM khachhang where idkhachhang =  '"+MaKhachHang+"'";
           ResultSet rs = DBConection.GetData(query);
           System.out.println(query);
           return rs;
    }
  public static int ThemKhachHang(DTOKhachHang kh) {
        String cauTruyVan = "INSERT INTO `khachhang`( `idloaikhachhang`, `idnguoidung`, `tenkhachhang`, `sodienthoai`, `email`, `matkhau`, `ngaysinh`, `diachi`,"
                + " `gioitinh`, `mangxahoi`, `anhdaidien`, `mota`, `tag`) VALUES (" + kh.getIdLoaiKhachHang() + ","
                + kh.getIdNguoiDung() + "," + kh.getTenKhachHang() + "," + kh.getSoDienThoai() + "," + kh.getEmail() + "," + kh.getMatKhau() + "," + kh.getNgaySinh() + "," + kh.getDiaChi() + ""
                + "," + kh.getGioiTinh() + "," + kh.getMangXaHoi() + "," + kh.getAnhDaiDien() + "," + kh.getMoTa() + "," + kh.getTag() + ")";
        System.out.println(cauTruyVan);
        int kq = DBConection.ExcuteTruyVan(cauTruyVan);
        return kq;
    }

}
