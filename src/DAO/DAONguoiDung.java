/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKhachHang;
import DTO.DTOLoaiKhachHang;
import DTO.DTONguoidung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DAONguoiDung {
     public static ResultSet LayNhanVienCBB() {
        String query = "SELECT * FROM nguoidung";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayMucLuongCBB() {
        String query = "SELECT * FROM luong";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayMaLuongCBB(int MaLuong) {

        String query = "SELECT * FROM luong where idluong = '" + MaLuong + "' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet DangNhap(String TenDangNhap) {

        String query = "SELECT * FROM `nguoidung` WHERE `tendangnhap` = '" + TenDangNhap + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ArrayList<DTONguoidung> GetChucVu() {
        ResultSet rs;
        ArrayList<DTONguoidung> chucvu = null;
        String cauTruyVan = "select DISTINCT  quyen from nguoidung";
        rs = DBConection.GetData(cauTruyVan);
        chucvu = new ArrayList<DTONguoidung>();
        try {
            while (rs.next()) {
                DTONguoidung nd = new DTONguoidung(rs.getInt("quyen"));
                chucvu.add(nd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOLoaiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chucvu;

    }

    public static ResultSet LayNguoiDungTheoChucVu(int ChucVu) {

        String query = "SELECT * FROM nguoidung where quyen = '" + ChucVu + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;

    }

    public static ResultSet LayNguoiDung(String TuKhoa) {

        String query = "SELECT * FROM nguoidung where tennguoidung like '%" + TuKhoa + "%' or ngaysinh like '%" + TuKhoa + "%' or ngayvaolam like '%" + TuKhoa + "%' or cmnd like '%" + TuKhoa + "%' or tendangnhap like '%" + TuKhoa + "%' ";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayNguoiDungTheoMa(int MaND) {

        String query = "SELECT * FROM nguoidung where idnguoidung = '"+MaND+"'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenNguoiDung(String TenNguoiDung) {

        String query = "SELECT * FROM nguoidung where tennguoidung =  '" + TenNguoiDung + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LaySDTNguoiDung(String SoDienThoai) {

        String query = "SELECT * FROM nguoidung where sodienthoai =  '" + SoDienThoai + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayEmailNguoiDung(String Email) {

        String query = "SELECT * FROM nguoidung where email =  '" + Email + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
     public static ResultSet LayCMNDNguoiDung(String CMND) {

        String query = "SELECT * FROM nguoidung where cmnd =  '" + CMND + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
    public static ResultSet LayMaLuong(int MaLuong) {

        String query = "SELECT * FROM luong where idluong =  '" + MaLuong + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }


    public static int ThemNguoiDung(DTONguoidung nd) {
        String cauTruyVan = "INSERT INTO `nguoidung`(`idluong`, `tennguoidung`, `sodienthoai`, `email`, `gioitinh`, `ngaysinh`, `ngayvaolam`, `diachi`, `cmnd`, `tendangnhap`,"
                + " `matkhau`, `anhdaidien`, `quyen`, `trangthai`, `mota`)"
                + " VALUES "
                + "('" + nd.getIdLuong() + "',"
                + "'" + nd.getTenNguoiDung() + "',"
                + "'" + nd.getSoDienThoai() + "',"
                + "'" + nd.getEmail() + "',"
                + "" + nd.getGioiTinh() + ","
                + "'" + nd.getNgaySinh() + "',"
                + "'" + nd.getNgayVaoLam() + "',"
                + "'" + nd.getDiaChi() + "',"
                + "'" + nd.getCMND() + "',"
                + "'" + nd.getTenDangNhap() + "',"
                + "'" + nd.getMatKhau() + "',"
                + "'" + nd.getAnhDaiDien() + "',"
                + "" + nd.getQuyen() + ","
                + "" + nd.getTrangThai()+ ","
                + "'" + nd.getMoTa() + "')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

    public static int SuaNhanVien(DTONguoidung nd) {
        String cauTruyVan = "UPDATE `nguoidung` SET"
                + " `idluong`='"+nd.getIdLuong()+"',"
                + "`tennguoidung`='"+nd.getTenNguoiDung()+"',"
                + "`sodienthoai`='"+nd.getSoDienThoai()+"',"
                + "`email`='"+nd.getEmail()+"',"
                + "`gioitinh`="+nd.getGioiTinh()+","
                + "`ngaysinh`='"+nd.getNgaySinh()+"',"
                + "`ngayvaolam`='"+nd.getNgayVaoLam()+"',"
                + "`diachi`='"+nd.getDiaChi()+"',"
                + "`cmnd`='"+nd.getCMND()+"',"
                + "`tendangnhap`='"+nd.getTenDangNhap()+"',"
                + "`matkhau`='"+nd.getMatKhau()+"',"
                + "`anhdaidien`='"+nd.getAnhDaiDien()+"',"
                + "`quyen`="+nd.getQuyen()+","
                + "`trangthai`="+nd.getTrangThai()+","
                + "`mota`='"+nd.getMoTa()+"'"
                + "WHERE `idnguoidung`='"+nd.getIdNguoiDung()+"'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }

    public static int XoaNhanVien(Integer MaNhanVien) {
        String cauTruyVan = "DELETE FROM `nguoidung` WHERE idnguoidung = '" + MaNhanVien + "'";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);

    }

}
