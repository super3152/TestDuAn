/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKhachHang;
import java.sql.ResultSet;


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

    public static ResultSet LayKhachHang(String TuKhoa) {

        String query = "SELECT * FROM khachhang where tenkhachhang like '%" + TuKhoa + "%' or sodienthoai like '%" + TuKhoa + "%' or email like '%" + TuKhoa + "%' or ngaysinh like '%" + TuKhoa + "%' or diachi like '%" + TuKhoa + "%'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayKhachHangTheoMa(int MaKhachHang) {

        String query = "SELECT * FROM khachhang where idkhachhang =  '" + MaKhachHang + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenKhachHang(String TenKhachHang) {

        String query = "SELECT * FROM khachhang where tenkhachhang =  '" + TenKhachHang + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LaySDTKhachHang(String SDT) {

        String query = "SELECT * FROM khachhang where sodienthoai =  '" + SDT + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayEmailKhachHang(String Email) {

        String query = "SELECT * FROM khachhang where email =  '" + Email + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static int ThemKhachHang(DTOKhachHang kh) {
        String cauTruyVan = "INSERT INTO `khachhang`"
                + "(`idloaikhachhang`, `idnguoidung`, `tenkhachhang`, `sodienthoai`, `email`, `matkhau`, `ngaysinh`, `diachi`, `gioitinh`, `mangxahoi`, `anhdaidien`, `mota`, `tag`)"
                + " VALUES "
                + "('"+kh.getIdLoaiKhachHang()+"',"
                + "'"+kh.getIdNguoiDung()+"',"
                + "'"+kh.getTenKhachHang()+"',"
                + "'"+kh.getSoDienThoai()+"',"
                + "'"+kh.getEmail()+"',"
                + "'"+kh.getMatKhau()+"',"
                + "'"+kh.getNgaySinh()+"',"
                + "'"+kh.getDiaChi()+"',"
                + ""+kh.getGioiTinh()+","
                + "'"+kh.getMangXaHoi()+"',"
                + "'"+kh.getAnhDaiDien()+"',"
                + "'"+kh.getMoTa()+"',"
                + "'"+kh.getTag()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
     public static int SuaKhachHang(DTOKhachHang kh) {
        String cauTruyVan = "UPDATE `khachhang`"
                + " SET "
                + "`idloaikhachhang`='"+kh.getIdLoaiKhachHang()+"',"
                + "`idnguoidung`='"+kh.getIdNguoiDung()+"',"
                + "`tenkhachhang`='"+kh.getTenKhachHang()+"',"
                + "`sodienthoai`='"+kh.getSoDienThoai()+"',"
                + "`email`='"+kh.getEmail()+"',"
                + "`matkhau`='"+kh.getMatKhau()+"',"
                + "`ngaysinh`='"+kh.getNgaySinh()+"',"
                + "`diachi`='"+kh.getDiaChi()+"',"
                + "`gioitinh`="+kh.getGioiTinh()+","
                + "`mangxahoi`='"+kh.getMangXaHoi()+"',"
                + "`anhdaidien`='"+kh.getAnhDaiDien()+"',"
                + "`mota`='"+kh.getMoTa()+"',"
                + "`tag`='"+kh.getTag()+"' "
                + "WHERE `idkhachhang`='"+kh.getIdKhachHang()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
 public static int XoaKhachHang(Integer MaKhachHang) {
        String cauTruyVan = "DELETE FROM `khachhang` WHERE idkhachhang = '"+MaKhachHang+"'";
        System.out.println(cauTruyVan);
       return  DBConection.ExcuteTruyVan(cauTruyVan);
        
    }
}
