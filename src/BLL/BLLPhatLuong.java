/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.DTONguoidung;
import DTO.DTOPhatLuong;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLPhatLuong {
    public static void Hienthiphatluong(JTable tbl){
        ResultSet rs = DAO.DAOPhatLuong.Layphatluong();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
           tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while(rs.next()){
                obj[0]= rs.getInt("idphatluong");
                int MaNhanien = rs.getInt("idnguoidung");
                ResultSet rsnv = DAO.DAOPhatLuong.LayMaNhanVien(MaNhanien);
                if (rsnv.next()) {
                     obj[1]= rsnv.getString("tennguoidung");
                }
                int MaLuong = rs.getInt("idluong");
                ResultSet rsluong = DAO.DAOPhatLuong.Layluong(MaLuong);
                if (rsluong.next()) {
                    obj[2]= ChuyenDoi.DinhDangTien(rsluong.getDouble("mucluong"));
                }
                obj[3]=ChuyenDoi.GetDate(rs.getString("ngayphat"));
                obj[4] = rs.getInt("songaydilam");
                obj[5]= rs.getInt("songaynghi");
                obj[6]=ChuyenDoi.DinhDangTien(rs.getDouble("tienthuong"));
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("tienphat"));
                obj[8]= ChuyenDoi.DinhDangTien(rs.getDouble("tongluong"));
                obj[9]= rs.getString("ghichu");
              tbModel.addRow(obj);
            }
        } catch (SQLException e) {
                ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng phát lương", "Thông báo");
        }
    }
    
}
