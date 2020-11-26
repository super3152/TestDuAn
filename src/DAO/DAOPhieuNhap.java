/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOKho;
import DTO.DTOPhieuNhap;
import DTO.DTOSanPham;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOPhieuNhap {

    public static ResultSet LayThongTinSPTheoID(int MaSP) {
        String query = "SELECT * FROM sanpham where idsanpham =  '" + MaSP + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayPhieuNhapTheoID(int MaPN) {
        String query = "SELECT * FROM phieunhap where idphieunhap =  '" + MaPN + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenNCC(int MaNCC) {
        String query = "SELECT * FROM nhacungcap where idnhacungcap =  '" + MaNCC + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenCN(int MaCN) {
        String query = "SELECT * FROM chinhanh where idchinhanh =  '" + MaCN + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenND(int MaND) {
        String query = "SELECT * FROM nguoidung where idnguoidung =  '" + MaND + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayTenKH(int MaKH) {
        String query = "SELECT * FROM khachhang where idkhachhang =  '" + MaKH + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayPhieuNhap(String TuKhoa) {
        String query = "Select * from phieunhap where idphieunhap like '%" + TuKhoa + "%' or idnhacungcap like '%" + TuKhoa + "%' or idchinhanh like '%" + TuKhoa + "%' or idnguoidung like '%" + TuKhoa + "%' or sophieunhap like '%" + TuKhoa + "%' or ngaynhap like '%" + TuKhoa + "%' or thanhtien like '%" + TuKhoa + "%'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayNhaCungCap() {
        String query = "Select * from nhacungcap";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayKhoTheoIDSP(int MaSanPham) {
        String query = "Select * from kho where idsanpham= '" + MaSanPham + "'";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static ResultSet LayChiNhanh() {
        String query = "Select * from chinhanh";
        ResultSet rs = DAO.DBConection.GetData(query);
        return rs;
    }

    public static int ThemPhieNhap(DTOPhieuNhap pn) {
        String query = "INSERT INTO `phieunhap`"
                + "( `idnhacungcap`, `idchinhanh`, `idnguoidung`, `sophieunhap`, `ngaynhap`, `thanhtien`, `hinhthucthanhtoan`, `hinhthucnhap`, `trangthai`, `nhapkho`, `thanhtoan`, `congno`, `tag`, `ghichu`)"
                + " VALUES "
                + "('" + pn.getIDNhaCungCap() + "',"
                + "'" + pn.getIDChiNhanh() + "',"
                + "'" + pn.getIDNguoiDung() + "',"
                + "'" + pn.getSoPhieuNhap() + "',"
                + "'" + pn.getNgayNhap() + "',"
                + "'" + pn.getThanhTien() + "',"
                + "'" + pn.getHinhThucThanhToan() + "',"
                + "'" + pn.getHinhThucNhap() + "',"
                + "'" + pn.getTrangThai() + "',"
                + "'" + pn.getNhapKho() + "',"
                + "'" + pn.getThanhToan() + "',"
                + "'" + pn.getCongNo() + "',"
                + "'" + pn.getTag() + "',"
                + "'" + pn.getGhiChu() + "')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }

    public static ResultSet GetByTenPN(String SoPhieuNhap) {
        String cauTruyVan = "select * from phieunhap where sophieunhap = '" + SoPhieuNhap + "'";
        ResultSet rs = DBConection.GetData(cauTruyVan);
        return rs;
    }

    public static int SuaTonKhoGia(DTOKho kh) {
        String query = "UPDATE `kho` SET `tonkho`='" + kh.getTonKho() + "',`hangdangve`='" + kh.getHangDangVe() + "' WHERE `idsanpham`='" + kh.getIDSanPham() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaNhapKhoPN(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `nhapkho`='" + pn.getNhapKho() + "' WHERE `sophieunhap`='" + pn.getSoPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaTonKhoSP(DTOSanPham sp) {
        String query = "UPDATE `sanpham` SET `gianhap`='" + sp.getGiaNhap() + "',`tonkho`='" + sp.getTonKho() + "' WHERE `idsanpham`='" + sp.getIDSanPham() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int SuaThanhToanPN(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `hinhthucthanhtoan`='" + pn.getHinhThucThanhToan() + "',`thanhtoan`='" + pn.getThanhToan() + "',`congno`='" + pn.getCongNo() + "',`hantracongno`='" + pn.getHanTraCongNo() + "' WHERE `sophieunhap`='" + pn.getSoPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }

    public static int TraNoPhieuNhap(DTOPhieuNhap pn) {
        String query = "UPDATE `phieunhap` SET `congno`='" + pn.getCongNo() + "' WHERE `idphieunhap`='" + pn.getIDPhieuNhap() + "'";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);
    }
}
