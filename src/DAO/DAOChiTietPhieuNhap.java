/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DTOChiTietPhieuNhap;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DAOChiTietPhieuNhap {

    public static int ThemChiTietPhieuNhap(DTOChiTietPhieuNhap ctpn) {
        String query = "INSERT INTO `chitietphieunhap`(`idphieunhap`, `idsanpham`, `donvi`, `soluong`, `gianhap`, `thanhtien`, `ghichu`)"
                + " VALUES"
                + "('"+ctpn.getIDPhieuNhap()+"',"
                + "'"+ctpn.getIDSanPham()+"',"
                + "'"+ctpn.getDonViTinh()+"',"
                + "'"+ctpn.getSoLuong()+"',"
                + "'"+ctpn.getGiaNhap()+"',"
                + "'"+ctpn.getThanhTien()+"',"
                + "'"+ctpn.getGhiChu()+"')";
        System.out.println(query);
        return DBConection.ExcuteTruyVan(query);

    }
    public static ResultSet LayCTPNTheoMaPN(int MaPN) {
        String query = "SELECT * FROM chitietphieunhap where idphieunhap =  '" + MaPN + "'";
        ResultSet rs = DBConection.GetData(query);
        return rs;
    }
}
