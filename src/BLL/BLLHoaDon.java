/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DAOHoaDon;
import DTO.DTOHoaDon;
import DTO.DTOKho;
import DTO.DTOSanPham;
import GUI.ThongBaoCanhBao;
import GUI.pnlChitiethoadon;
import GUI.pnlbanhang;
import GUI.pnlsanpham;
import java.awt.Component;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Administrator
 */
public class BLLHoaDon {

    public static void HienThiHoaDon(JTable tbl, String TuKhoa) {
        ResultSet rs = DAO.DAOHoaDon.LayHoaDon(TuKhoa);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[8];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idhoadon");
                obj[1] = rs.getString("sohoadon");
                int MaKH = rs.getInt("idkhachhang");
                ResultSet rsKH = DAO.DAOPhieuNhap.LayTenKH(MaKH);
                if (rsKH.next()) {
                    obj[2] = rsKH.getString("tenkhachhang");
                }
                obj[3] = ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon"));
                obj[4] = ChuyenDoi.DinhDangTien(rs.getDouble("tongtien"));

                int tt = rs.getInt("tinhtrang");
                String TrangThai = String.valueOf(tt);
                if (TrangThai.equals("0")) {
                    obj[5] = "Chưa Thanh Toán";
                } else if (TrangThai.equals("1")) {
                    obj[5] = "Đã Thanh Toán";
                } else {
                    obj[5] = "Đang Nợ";
                }

                obj[6] = ChuyenDoi.DinhDangTien(rs.getDouble("congno"));
                int MaND = rs.getInt("idnguoidung");
                ResultSet rsND = DAO.DAOPhieuNhap.LayTenND(MaND);
                if (rsND.next()) {
                    obj[7] = rsND.getString("tennguoidung");
                }
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng hóa đơn", "Thông báo");
        }
    }

    public static void HienThiChiTietHoaDon(JTable tbl, int MaHD) {
        pnlChitiethoadon.tblChiTietHoaDon.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        ResultSet rs = DAO.DAOHoaDon.LayCTHDTheoMaHD(MaHD);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idsanpham");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMSP.next()) {
                    obj[2] = rsMSP.getString("masanpham");
                }
                ResultSet rsTSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsTSP.next()) {
                    obj[3] = rsTSP.getString("tensanpham");
                }
                ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {
                    int MaSize = rsSSP.getInt("idsizesanpham");

                    ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                    if (rsMSSP.next()) {
                        obj[4] = rsMSSP.getString("tensize");
                    }
                }

                ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {
                    int MaMau = rsMMSP.getInt("idmausanpham");
                    ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                    if (rsIDMSP.next()) {
                        obj[5] = rsIDMSP.getString("tenmausanpham");
                    }
                }
                obj[6] = rs.getInt("soluong");
                ResultSet rsGSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsGSP.next()) {
                    obj[7] = ChuyenDoi.DinhDangTien(rsGSP.getDouble("giabanle"));
                }
                obj[8] = ChuyenDoi.DinhDangTien(rs.getDouble("uudai"));
                obj[9] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {

                    JLabel lb = new JLabel();

                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                    lb.setIcon(imageIcon);
                    obj[1] = lb;
                }
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng trả hàng", "Thông báo");
        }
    }

    public static DTO.DTOHoaDon GetMaHD(Integer MaHD) {
        try {
            ResultSet rs = DAO.DAOHoaDon.LayHoaDonTheoMa(MaHD);
            if (rs.next()) {
                DTOHoaDon hd = new DTOHoaDon();
                hd.setMaHoaDon(rs.getInt("idhoadon"));
                hd.setSoHoaDon(rs.getString("sohoadon"));
                hd.setNgayTaoHoaDon(ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon")));
                hd.setMaNV(rs.getInt("idnguoidung"));
                hd.setTinhTrang(rs.getInt("tinhtrang"));
                hd.setTongTien(rs.getDouble("tongtien"));
                hd.setMaKhachHang(rs.getInt("idkhachhang"));
                hd.setTraHang(rs.getInt("trahang"));
                hd.setCongNo(rs.getDouble("congno"));

                return hd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng hóa đơn", "Thông báo");
        }
        return null;
    }

    public static DTO.DTOHoaDon GetSoHD(String SoHD) {
        try {
            ResultSet rs = DAO.DAOHoaDon.LayHoaDonTheoSoHD(SoHD);
            if (rs.next()) {
                DTOHoaDon hd = new DTOHoaDon();
                hd.setMaHoaDon(rs.getInt("idhoadon"));
                hd.setSoHoaDon(rs.getString("sohoadon"));
                hd.setNgayTaoHoaDon(ChuyenDoi.GetNgay(rs.getDate("ngaytaohoadon")));
                hd.setMaNV(rs.getInt("idnguoidung"));
                hd.setTinhTrang(rs.getInt("tinhtrang"));
                hd.setTongTien(rs.getDouble("tongtien"));
                hd.setMaKhachHang(rs.getInt("idkhachhang"));
                hd.setTraHang(rs.getInt("trahang"));

                return hd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng hóa đơn", "Thông báo");
        }
        return null;
    }

    public static String TaoSoHoaDon() {
        String soHoaDon;

        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");

        Date d = new Date();

        soHoaDon = "HD" + dateFormat.format(d);

        return soHoaDon;
    }

    public static void DoSanPhamLenLaiHoaDon(JTable tb, int MaHoaDon) {
        pnlbanhang.tblChiTietHoaDon.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        ResultSet rs = DAO.DAOChiTietHoaDon.LayCTHDTheoMaHD(MaHoaDon);
        Object obj[] = new Object[10];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idsanpham");
                int MaSP = rs.getInt("idsanpham");
                ResultSet rsMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMSP.next()) {
                    obj[2] = rsMSP.getString("masanpham");
                }
                ResultSet rsTSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsTSP.next()) {
                    obj[3] = rsTSP.getString("tensanpham");
                }
                ResultSet rsSSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsSSP.next()) {
                    int MaSize = rsSSP.getInt("idsizesanpham");

                    ResultSet rsMSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
                    if (rsMSSP.next()) {
                        obj[4] = rsMSSP.getString("tensize");
                    }
                }

                ResultSet rsMMSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsMMSP.next()) {
                    int MaMau = rsMMSP.getInt("idmausanpham");
                    ResultSet rsIDMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
                    if (rsIDMSP.next()) {
                        obj[5] = rsIDMSP.getString("tenmausanpham");
                    }
                }
                obj[6] = rs.getInt("soluong");
                ResultSet rsGSP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsGSP.next()) {
                    obj[7] = ChuyenDoi.DinhDangTien(rsGSP.getDouble("giabanle"));
                }
                obj[8] = ChuyenDoi.DinhDangTien(rs.getDouble("uudai"));
                obj[9] = ChuyenDoi.DinhDangTien(rs.getDouble("thanhtien"));
                ResultSet rsASP = DAO.DAOPhieuNhap.LayThongTinSPTheoID(MaSP);
                if (rsASP.next()) {

                    JLabel lb = new JLabel();

                    ImageIcon imageIcon = new ImageIcon(new ImageIcon(rsASP.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                    lb.setIcon(imageIcon);
                    obj[1] = lb;
                }
                tableModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }

    }

    public static double NhapSanPhamVaoChiTietHoaDon(JTable tb, DTOSanPham sp, int SoLuong, double UuDai) {
        pnlbanhang.tblChiTietHoaDon.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
            obj[0] = sp.getIDSanPham();
            obj[2] = sp.getMaSanPham();
            obj[3] = sp.getTenSanPham();
            int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
            int Soluong = 1;
            obj[6] = Soluong;
            obj[7] = BLL.ChuyenDoi.DinhDangTien(sp.getGiaBanLe());
            obj[8] = ChuyenDoi.DinhDangTien(UuDai);
            double thanhTien = (sp.getGiaBanLe()) * Soluong;
            obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien);

            JLabel lb = new JLabel();

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            lb.setIcon(imageIcon);
            obj[1] = lb;
            tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tongTien + tien;
        }

        return tongTien;

    }

    public static double NhapSanPhamVaoChiTietHoaDonTrung(JTable tb, DTOSanPham sp, int SoLuong, double UuDai) {
        pnlbanhang.tblChiTietHoaDon.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
            obj[0] = sp.getIDSanPham();
            obj[2] = sp.getMaSanPham();
            obj[3] = sp.getTenSanPham();
            int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
            int SoLuongMoi = SoLuong + 1;
            obj[6] = SoLuongMoi;
            obj[7] = BLL.ChuyenDoi.DinhDangTien(sp.getGiaBanLe());
            obj[8] = ChuyenDoi.DinhDangTien(UuDai);
            double thanhTien = (sp.getGiaBanLe()) * SoLuongMoi;
            obj[9] = BLL.ChuyenDoi.DinhDangTien(thanhTien - UuDai);

            JLabel lb = new JLabel();

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            lb.setIcon(imageIcon);
            obj[1] = lb;
            tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tien;
        }

        return tongTien;

    }

    public static class mytable implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;

        }
    }

    public static double SuaSanPhamVaoChiTietHoaDon(JTable tb, DTOSanPham sp, int SoLuong, double UuDai) {
        pnlbanhang.tblChiTietHoaDon.getColumn("Ảnh").setCellRenderer(new BLLSanPham.mytable());
        DefaultTableModel tableModel = (DefaultTableModel) tb.getModel();
        Object obj[] = new Object[10];
        try {
            obj[0] = sp.getIDSanPham();
            obj[2] = sp.getMaSanPham();
            obj[3] = sp.getTenSanPham();
            int MaSize = sp.getIDSize();
            ResultSet rsSSP = DAO.DAOSanPham.LaySizeSanPham(MaSize);
            if (rsSSP.next()) {
                obj[4] = rsSSP.getString("tensize");
            }
            int MaMau = sp.getIDMauSanPham();
            ResultSet rsMSP = DAO.DAOSanPham.LayMauSanPham(MaMau);
            if (rsMSP.next()) {
                obj[5] = rsMSP.getString("tenmausanpham");
            }
            obj[6] = SoLuong;
            obj[7] = BLL.ChuyenDoi.DinhDangTien(sp.getGiaBanLe());
            double TinhChietKhau = (sp.getGiaBanLe()) * UuDai * 0.1;
            obj[8] = BLL.ChuyenDoi.DinhDangTien(TinhChietKhau);
            double ThanhTien = sp.getGiaBanLe() * SoLuong - TinhChietKhau;
            obj[9] = BLL.ChuyenDoi.DinhDangTien(ThanhTien);
            JLabel lb = new JLabel();

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(sp.getAnhSanPham()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            lb.setIcon(imageIcon);
            obj[1] = lb;
            tableModel.addRow(obj);
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu chi tiết bán hàng", "Thông báo");
        }
        double tongTien = 0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            double tien = BLL.ChuyenDoi.ChuyenTien(tb.getValueAt(i, 9).toString());
            tongTien = tien;
        }
        return tongTien;
    }

    public static void SuaSoLuongChoSP(DTOSanPham sp) {
        DAO.DAOSanPham.SuaSoLuong(sp);
    }

    public static void SuaTonKhoTrongKho(DTOKho kh) {
        DAO.DAOKho.SuaTonKho(kh);
    }

    public static void ThemHoaDon(DTOHoaDon HD) {
        DAO.DAOHoaDon.ThemHoaDon(HD);
    }

    public static int LayMaHoaDonString(String TenHD) {
        try {
            ResultSet rs = DAOHoaDon.GetByTenHD(TenHD);

            if (rs.next()) {
                return rs.getInt("idhoadon");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Hóa Đơn !", "Thông Báo !");
        }
        return 0;
    }

    public static int LayMaNhanVienString(String TenNV) {
        try {
            ResultSet rs = DAOHoaDon.GetByTenNV(TenNV);

            if (rs.next()) {
                return rs.getInt("idnguoidung");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Người Dùng !", "Thông Báo !");
        }
        return 0;
    }

    public static int LayMaSanPhamString(String MaSanPham) {
        try {
            ResultSet rs = DAOHoaDon.GetByMaSP(MaSanPham);

            if (rs.next()) {
                return rs.getInt("idsanpham");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Sản Phẩm !", "Thông Báo !");
        }
        return 0;
    }

    public static void ThemChiTietHoaDon(DTO.DTOChiTietHoaDon cthd) {
        DAO.DAOChiTietHoaDon.ThemChiTietHoaDon(cthd);
    }

    public static void SuaNoHoaDonPhieuTra(DTO.DTOHoaDon hd) {
        DAO.DAOHoaDon.SuaNoHoaDonPhieuTra(hd);
    }

    public static void SuaTraHangHoaDon(DTO.DTOHoaDon hd) {
        DAO.DAOHoaDon.SuaTraHangHoaDon(hd);
    }

    public static void TraNoHoaDon(DTO.DTOHoaDon hd) {
        DAO.DAOHoaDon.TraNoHoaDon(hd);
    }

    public static void SuaTrangThaiHoaDon(DTO.DTOHoaDon hd) {
        DAO.DAOHoaDon.SuaTrangThai(hd);
    }

    public static void SuaTrangThaiHanNoHoaDon(DTO.DTOHoaDon hd) {
        DAO.DAOHoaDon.SuaTrangThaiHanNoHoaDon(hd);
    }
}
