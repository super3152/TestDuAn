/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTONguoidung;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLSanPham {

    public static void HienThiSanPham(JTable tbl) {
        ResultSet rs = DAO.DAOSanPham.LaySanPham();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[11];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idsanpham");
                obj[1] = rs.getString("tensanpham");
                obj[2] = rs.getString("masanpham");
                obj[3] = ChuyenDoi.DinhDangTien(rs.getDouble("giabanbuon"));
                obj[4] = rs.getString("khoiluong");
                int MaLoaiSanPham = rs.getInt("idloaisanpham");
                ResultSet rsLSP = DAO.DAOSanPham.LayLoaiSanPham(MaLoaiSanPham);
                if (rsLSP.next()) {
                    obj[5] = rsLSP.getString("tenloaisanpham");
                }
                int MaHangSanPham = rs.getInt("idhangsanpham");
                ResultSet rsHSP = DAO.DAOSanPham.LayHangSanPham(MaHangSanPham);
                if (rsHSP.next()) {
                    obj[6] = rsHSP.getString("tenhang");
                }
                obj[7] = ChuyenDoi.GetNgay(rs.getDate("ngaytao"));

                int MaSizeSanPham = rs.getInt("idsizesanpham");
                ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSizeSanPham);
                if (rsSSP.next()) {
                    obj[8] = rsSSP.getString("tensize");
                }
                int MaMauSanPham = rs.getInt("idmausanpham");
                ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMauSanPham);
                if (rsMSP.next()) {
                    obj[9] = rsMSP.getString("tenmausanpham");
                }
                obj[10] = rs.getString("anhsanpham");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng sản phẩm", "Thông báo");
        }

    }

  
}
