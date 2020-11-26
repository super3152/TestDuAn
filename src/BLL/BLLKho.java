/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTOKho;
import DTO.DTONguoidung;
import DTO.DTOPhieuNhap;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLKho {
      public static void HienThiKho(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAOKho.LayKho(TuKhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idkho");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsSP = DAO.DAOKho.LayTenSP(MaSP);
                if (rsSP.next()) {
                    obj[1] = rsSP.getString("tensanpham");
                }
                int SoPN = rs.getInt("idphieunhap");
                ResultSet rsPN = DAO.DAOKho.LaySoPhieuNhap(SoPN);
                if (rsPN.next()) {
                    obj[2] = rsPN.getString("sophieunhap");
                }
                 obj[3] = rs.getInt("tonkho");
                 obj[4] = rs.getInt("hangdangve");
                 obj[5] = rs.getString("trangthai");
                
              
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng kho", "Thông báo");
        }

    }

    public static void ThemKho(DTOKho K) {
        DAO.DAOKho.ThemKho(K);
    }
     public static void SuaHangDangVeKho(DTOKho K) {
        DAO.DAOKho.SuaHangDangVeKho(K);
    }

    public static DTO.DTOKho GetKhoTheoIDSP(Integer MaSP) {
        try {
            ResultSet rs = DAO.DAOKho.GetKhoTheoIDSP(MaSP);
            if (rs.next()) {
                DTO.DTOKho kh = new DTO.DTOKho();
                kh.setIDKho(rs.getInt("idkho"));
                kh.setIDSanPham(rs.getInt("idsanpham"));
                kh.setIDPhieuNhap(rs.getInt("idphieunhap"));
                kh.setTonKho(rs.getInt("tonkho"));
                kh.setHangDangVe(rs.getInt("hangdangve"));
                kh.setTrangThai(rs.getString("trangthai"));

                return kh;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng kho", "Thông báo");
        }
        return null;
    }
}
