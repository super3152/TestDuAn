/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DAOTraHang;
import DTO.DTOChiTietHoaDon;
import DTO.DTOTraHang;
import DTO.MyCombobox;
import GUI.ThongBaoCanhBao;
import GUI.pnltrahang;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class BLLTraHang {

    public static int SoLuong;

    public static int HienThiChiTietTraHang(JTable tbl, int MaTraHang) {
         pnltrahang.tblPhieutra.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOChiTietTraHang.LayCTTHTheoMaTH(MaTraHang);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {

                obj[0] = rs.getInt("idchitiethoadon");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMSP.next()) {
                    obj[2] = rsMSP.getString("tensanpham");
                }
                 ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {
                    int MaSize = rsSSP.getInt("idsizesanpham");

                    ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                    if (rsMSSP.next()) {
                        obj[3] = rsMSSP.getString("tensize");
                    }
                }

                ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {
                    int MaMau = rsMMSP.getInt("idmausanpham");
                    ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                    if (rsIDMSP.next()) {
                        obj[4] = rsIDMSP.getString("tenmausanpham");
                    }
                }
                obj[5] = rs.getInt("soluong");
                obj[6] = ChuyenDoi.DinhDangTien(rs.getDouble("giahang"));
                obj[7] = ChuyenDoi.DinhDangTien(rs.getDouble("phitra"));
                obj[8] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                 ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {
                
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                }
                tbModel.addRow(obj);
                int soluong =0;
                for (int i = 0; i < tbModel.getRowCount(); i++) {
                     soluong = soluong+ Integer.parseInt(tbl.getValueAt(i, 5).toString());
                    SoLuong =soluong;
                }

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng trả hàng", "Thông báo");
        }
        return SoLuong;

    }

    public static void HienThiTraHang(JTable tbl) {
        ResultSet rs = DAO.DAOTraHang.LayTraHang();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idtrahang");
                obj[1] = rs.getString("sotrahang");
                int MaHD = rs.getInt("idhoadon");
                ResultSet rsHD = DAO.DAOTraHang.LaySoHoaDon(MaHD);
                if (rsHD.next()) {
                    obj[2] = rsHD.getString("sohoadon");
                }
                int MaKH = rs.getInt("idkhachhang");
                ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                if (rsKH.next()) {
                    obj[3] = rsKH.getString("tenkhachhang");
                }
                obj[4] = rs.getString("trangthai");
                obj[5] = rs.getString("hoantien");
                obj[6] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));
                obj[7] = rs.getString("lydotra");

                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng trả hàng", "Thông báo");
        }
    }

    public static String TaoSoTraHang() {
        String soHoaDon;

        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");

        Date d = new Date();

        soHoaDon = "PT" + dateFormat.format(d);

        return soHoaDon;
    }

    public static void SetCBBKhachHang(JComboBox cbb, int MaKH) {
        try {
            ResultSet rs = DAO.DAOTraHang.LayKhachHangTheoTen(MaKH);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tenkhachhang"),
                        rs.getInt("idkhachhang"));

                cbbModel.setSelectedItem(mb);
            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }

    public static void HienThiHoaDonTheoTraHang(JTable tbl) {
        ResultSet rs = DAO.DAOTraHang.LayHoaDonTheoTraHang();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[6];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idhoadon");
                obj[1] = rs.getString("sohoadon");
                obj[2] = ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon"));
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                if (rsND.next()) {
                    obj[3] = rsND.getString("tennguoidung");
                }
                int MaKH = rs.getInt("idkhachhang");
                ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                if (rsKH.next()) {
                    obj[4] = rsKH.getString("tenkhachhang");
                }
                obj[5] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));

                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }

    }
    public static double TongTien;

    public static double HienThiChiTietHoaDon(JTable tbl, int MaHoaDon) {
        pnltrahang.tblPhieutra.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOTraHang.LayChiTietHoaDonTheoHoaDon(MaHoaDon);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idchitiethoadon");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsSP = DAO.DAOTraHang.LayTenSanPham(MaSP);
                if (rsSP.next()) {
                    obj[2] = rsSP.getString("tensanpham");
                }
                int SoLuong = 0;
                obj[5] = SoLuong;
                 ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {                
                int MaSize = rsSSP.getInt("idsizesanpham");
                
                ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                if (rsMSSP.next()) {
                    obj[3] = rsMSSP.getString("tensize");
                }
                }
                
                 ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {  
                int MaMau = rsMMSP.getInt("idmausanpham");
                ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                if (rsIDMSP.next()) {
                    obj[4] = rsIDMSP.getString("tenmausanpham");
                }
                }
                double GiaTongHang = rs.getDouble("thanhtien");
                int SoLuongCT = rs.getInt("soluong");
                double GiaLe = GiaTongHang / SoLuongCT;
                obj[6] = ChuyenDoi.DinhDangTien(GiaLe);
                double PhiTra = 0;
                obj[7] = ChuyenDoi.DinhDangTien(PhiTra);
                double ThanhTien = GiaLe * SoLuong - PhiTra;
                obj[8] = ChuyenDoi.DinhDangTien(ThanhTien);
                 ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {
                
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                }

                tbModel.addRow(obj);
                for (int i = 0; i < tbModel.getRowCount(); i++) {
                    double tien = BLL.ChuyenDoi.ChuyenTien(tbl.getValueAt(i, 8).toString());
                    TongTien = TongTien + tien;
                }

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }
        return TongTien;
    }

    public static double HienThiChiTietHoaDonSua(JTable tbl, int MaCTHD, int SoLuong, double PhiTra) {
         pnltrahang.tblPhieutra.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOTraHang.LayChiTietHoaDonTheoMa(MaCTHD);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        Object obj[] = new Object[9];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idchitiethoadon");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsSP = DAO.DAOTraHang.LayTenSanPham(MaSP);
                if (rsSP.next()) {
                    obj[2] = rsSP.getString("tensanpham");
                }
                obj[5] = SoLuong;
                 ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {                
                int MaSize = rsSSP.getInt("idsizesanpham");
                
                ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                if (rsMSSP.next()) {
                    obj[3] = rsMSSP.getString("tensize");
                }
                }
                
                 ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {  
                int MaMau = rsMMSP.getInt("idmausanpham");
                ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                if (rsIDMSP.next()) {
                    obj[4] = rsIDMSP.getString("tenmausanpham");
                }
                }
                double GiaTongHang = rs.getDouble("thanhtien");
                int SoLuongCT = rs.getInt("soluong");
                double GiaLe = GiaTongHang / SoLuongCT;
                obj[6] = ChuyenDoi.DinhDangTien(GiaLe);
                obj[7] = ChuyenDoi.DinhDangTien(PhiTra);
                double ThanhTien = GiaLe * SoLuong - PhiTra;
                obj[8] = ChuyenDoi.DinhDangTien(ThanhTien);
                 ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {
                
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[1] = lb;
                }

                tbModel.addRow(obj);
                for (int i = 0; i < tbModel.getRowCount(); i++) {
                    double tien = BLL.ChuyenDoi.ChuyenTien(tbl.getValueAt(i, 8).toString());
                    TongTien = tien;
                }

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }
        return TongTien;
    }

    public static DTO.DTOTraHang GetMaPT(int MaPT) {
        try {
            ResultSet rs = DAO.DAOTraHang.LayTraHangTheoID(MaPT);
            if (rs.next()) {
                DTOTraHang th = new DTOTraHang();
                th.setMaTraHang(rs.getInt("idtrahang"));
                th.setMaHoaDon(rs.getInt("idhoadon"));
                th.setMaKhachHang(rs.getInt("idkhachhang"));
                th.setMaNhanVien(rs.getInt("idnguoidung"));
                th.setSoPhieuTra(rs.getString("sotrahang"));
                th.setTrangThai(rs.getString("trangthai"));
                th.setHoanTien(rs.getString("hoantien"));
                th.setTongTien(rs.getDouble("tongtien"));
                th.setNgayNhan(ChuyenDoi.GetNgay(rs.getDate("ngaynhan")));
                th.setLyDoTra(rs.getString("lydotra"));
                th.setHinhThucThanhToan(rs.getString("hinhthucthanhtoan"));
                return th;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng phiếu trả", "Thông báo");
        }
        return null;
    }

    public static DTO.DTOChiTietHoaDon GetMaCTHD(Integer MaCTHD) {
        try {
            ResultSet rs = DAO.DAOTraHang.LayCTHDTheoMa(MaCTHD);
            if (rs.next()) {
                DTOChiTietHoaDon cthd = new DTOChiTietHoaDon();
                cthd.setMaHoaDon(rs.getInt("idchitiethoadon"));
                cthd.setMaHoaDon(rs.getInt("idhoadon"));
                cthd.setMaSanPham(rs.getInt("idsanpham"));
                cthd.setSoLuong(rs.getInt("soluong"));
                cthd.setThanhTien(rs.getDouble("thanhtien"));
                cthd.setUuDai(rs.getDouble("uudai"));
                cthd.setGhiChu(rs.getString("ghichu"));

                return cthd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng chi tiết hóa đơn", "Thông báo");
        }
        return null;
    }
        public static DTO.DTOChiTietHoaDon GetMaCTHDTheoMaHD(Integer MaHD) {
        try {
            ResultSet rs = DAO.DAOTraHang.LayCTHDTheoMaHD(MaHD);
            if (rs.next()) {
                DTOChiTietHoaDon cthd = new DTOChiTietHoaDon();
                cthd.setMaHoaDon(rs.getInt("idchitiethoadon"));
                cthd.setMaHoaDon(rs.getInt("idhoadon"));
                cthd.setMaSanPham(rs.getInt("idsanpham"));
                cthd.setSoLuong(rs.getInt("soluong"));
                cthd.setThanhTien(rs.getDouble("thanhtien"));
                cthd.setUuDai(rs.getDouble("uudai"));
                cthd.setGhiChu(rs.getString("ghichu"));

                return cthd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng chi tiết hóa đơn", "Thông báo");
        }
        return null;
    }

    public static void ThemPhieuTraHang(DTO.DTOTraHang th) {
        DAO.DAOTraHang.ThemPhieuTra(th);
    }

    public static void SuaPhieuTraHang(DTO.DTOTraHang th) {
        DAO.DAOTraHang.SuaPhieuTra(th);
    }

    public static void SuaCTHD(DTO.DTOChiTietHoaDon cthd) {
        DAO.DAOChiTietHoaDon.SuaChiTietHoaDon(cthd);
    }

    public static void SuaTonKhoKho(DTO.DTOKho kh) {
        DAO.DAOTraHang.SuaTonKhoKho(kh);
    }

    public static void SuaTonKhoSP(DTO.DTOSanPham sp) {
        DAO.DAOTraHang.SuaTonKhoSP(sp);
    }

    public static void SuaThanhToanTraHang(DTO.DTOTraHang th) {
        DAO.DAOTraHang.SuaThanhToanTraHang(th);
    }

    public static void ThemCTTH(DTO.DTOChiTietTraHang ctth) {
        DAO.DAOTraHang.ThemCTTH(ctth);
    }

    public static void SuaTongTienHD(DTO.DTOHoaDon hd) {
        DAO.DAOTraHang.SuaTongTienHD(hd);
    }

    public static int LayMaSanPhamString(String TenSP) {
        try {
            ResultSet rs = DAO.DAOTraHang.GetByTenSP(TenSP);

            if (rs.next()) {
                return rs.getInt("idsanpham");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Hóa Đơn !", "Thông Báo !");
        }
        return 0;
    }

    public static int LayMaPhieuTraString(String TenPT) {
        try {
            ResultSet rs = DAOTraHang.GetByTenPT(TenPT);

            if (rs.next()) {
                return rs.getInt("idtrahang");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Phiếu Trả !", "Thông Báo !");
        }
        return 0;
    }
}
