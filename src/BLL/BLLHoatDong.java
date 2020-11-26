/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DBConection;
import DTO.DTOHoatDong;
import GUI.ThongBaoCanhBao;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KMB1604
 */
public class BLLHoatDong {
    
      public static void HienThiHoatDong(JTable tbl) {
        ResultSet rs = DAO.DAOHoatDong.LayHoatDong();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[3];
        try {
            while (rs.next()) {
                ResultSet loaihoatdong = DAO.DAOHoatDong.LayLoaiHoatDong(rs.getString("idloaihoatdong"));
                if (loaihoatdong.next()) {
                    obj[1] = loaihoatdong.getString("tenloaihoatdong");
                }          
                 ResultSet nguoidung = DAO.DAOHoatDong.LayNguoiDung(rs.getString("idnguoidung"));
                if (nguoidung.next()) {
                    obj[0] = nguoidung.getString("tennguoidung");
                }
                obj[2] = BLL.ChuyenDoi.GetNgay(rs.getTimestamp("thoigianhoatdong"));
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hoạt động", "Thông báo");
        }

    }
    
      
          public static void HienThiChiTietHoatDong(JTable tbl) {
        ResultSet rs = DAO.DAOHoatDong.LayHoatDong();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[5];
        try {
            while (rs.next()) {
                 obj[0] = rs.getInt("idhoatdong");
                ResultSet loaihoatdong = DAO.DAOHoatDong.LayLoaiHoatDong(rs.getString("idloaihoatdong"));
                if (loaihoatdong.next()) {
                    obj[2] = loaihoatdong.getString("tenloaihoatdong");
                }          
                 ResultSet nguoidung = DAO.DAOHoatDong.LayNguoiDung(rs.getString("idnguoidung"));
                if (nguoidung.next()) {
                    obj[1] = nguoidung.getString("tennguoidung");
                }
                obj[3] = BLL.ChuyenDoi.GetNgay(rs.getDate("thoigianhoatdong"));
               
                 obj[4] = BLL.ChuyenDoi.GetNgay(rs.getTimestamp("thoigianhoatdong"));
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hoạt động", "Thông báo");
        }

    }
      
    
    public static int ThemHoatDong(DTOHoatDong hd) {
        String cauTruyVan = "INSERT INTO `hoatdong`"
                + "(`idloaihoatdong`, `idnguoidung`)"
                + " VALUES "
                + "('"+hd.getIdloaihoatdong()+"',"                        
                + "'"+hd.getIdnguoidung()+"')";
        System.out.println(cauTruyVan);
        return DBConection.ExcuteTruyVan(cauTruyVan);
    }
    
    
}
