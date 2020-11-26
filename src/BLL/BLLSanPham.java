/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.DAOSanPham;
import DTO.DTOMauSanPham;
import DTO.DTONguoidung;
import DTO.DTOSanPham;
import DTO.DTOSize;
import DTO.MyCombobox;
import GUI.ThongBaoCanhBao;
import GUI.pnlsanpham;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Component;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Administrator
 */
public class BLLSanPham {

    public static DTO.DTOSanPham sp = new DTOSanPham();
     public static void SizeSanPhamTheoTen(JComboBox cbbSizeSanPham, String TenSP) {
        ResultSet rs = DAO.DAOSanPham.LaySizeTheoTenSanPham(TenSP);
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbSizeSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdSize = rs.getString("idsize");
                Object TenSize = rs.getString("tensize");
                MyCombobox mb = new MyCombobox(TenSize, IdSize);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Size sản phẩm", "Thông Báo");           
        }
    }
      public static void MauSanPhamTheoTenRi(JComboBox cbbSizeSanPham, String TenSP) {
        ResultSet rs = DAO.DAOSanPham.LayMauTheoTenSanPhamRi(TenSP);
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbSizeSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdMau = rs.getString("idmausanpham");
                Object TenMau = rs.getString("tenmausanpham");
                MyCombobox mb = new MyCombobox(TenMau, IdMau);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Size sản phẩm", "Thông Báo");           
        }
    }

    public static void MauSanPhamTheoTen(JComboBox cbbMauSanPham, String TenSP, int SizeSP) {
        ResultSet rs = DAO.DAOSanPham.LayMauTheoSizeTenSanPham(TenSP, SizeSP);
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbMauSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdMau = rs.getString("idmausanpham");
                Object TenMau = rs.getString("tenmausanpham");
                MyCombobox mb = new MyCombobox(TenMau, IdMau);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Màu sản phẩm", "Thông Báo");
            
        }
    }
     public static void DoDuLieuVaoCBBTCSanPham(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAOSanPham.LayTenSanPham();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
             String TenSP= rs.getString("tensanpham");
                cbbModel.addElement(TenSP);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu sản phẩm", "Thông báo");
        }

    }
      public static int LayMaSanPhamString(String TenSP, int MaSize, int MaMau) {
        try {
            ResultSet rs = DAOSanPham.GetByTenSP(TenSP, MaSize, MaMau);

            if (rs.next()) {
                return rs.getInt("idsanpham");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Sản Phẩm !", "Thông Báo !");
        }
        return 0;
    }
        public static int LayMaSizeString(String TenSize) {
        try {
            ResultSet rs = DAOSanPham.GetByTenSize(TenSize);

            if (rs.next()) {
                return rs.getInt("idsizesanpham");
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi Lấy Mã Sản Phẩm !", "Thông Báo !");
        }
        return 0;
    }

    public static void DoDuLieuVaoCBBSanPham(JComboBox cbb) {
        try {
            ResultSet rs;
            rs = DAO.DAOSanPham.LayTenSanPham();

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            while (rs.next()) {
                MyCombobox mb = new MyCombobox(rs.getString("tensanpham"),
                        rs.getInt("idsanpham"));
                cbbModel.addElement(mb);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }

    }

    public static void SetCBBNguoiDung(JComboBox cbb, int MaLuong) {
        try {
            ResultSet rs = DAO.DAONguoiDung.LayMaLuongCBB(MaLuong);

            DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbb.getModel();
            cbbModel.removeAllElements();
            if (rs.next()) {
                MyCombobox mb = new MyCombobox(ChuyenDoi.DinhDangTien(rs.getDouble("mucluong")),
                        rs.getInt("idluong"));

                cbbModel.setSelectedItem(mb);

            }
        } catch (SQLException ex) {

            ThongBaoCanhBao.ThongBao("Lỗi truy vấn dữ liệu", "Thông báo");
        }
    }

 public static byte[] BarCode(String ab, int w, int h){
     try {
           
         Hashtable<EncodeHintType, ErrorCorrectionLevel > HintMap = new Hashtable<>();
         HintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
         Writer write = new Code128Writer();
         BitMatrix bitmatrix = write.encode(ab, BarcodeFormat.CODE_128, w, h);
         
            ByteArrayOutputStream bytearray = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitmatrix, "png", bytearray);
            return bytearray.toByteArray(); 
        } catch (Exception e) {
         return null;
        }
  }
    public static void HienThiSanPham(JTable tbl) {

        pnlsanpham.tblSanPham.getColumn("Ảnh Sản Phẩm").setCellRenderer(new mytable());
         pnlsanpham.tblSanPham.getColumn("Mã Quét").setCellRenderer(new mytable());
        ResultSet rs = DAO.DAOSanPham.LaySanPham();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[14];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("masanpham");
                obj[1] = rs.getString("tensanpham");
                int MaLoaiSanPham = rs.getInt("idloaisanpham");
                ResultSet rsLSP = DAO.DAOSanPham.LayLoaiSanPham(MaLoaiSanPham);
                if (rsLSP.next()) {
                    obj[2] = rsLSP.getString("tenloaisanpham");
                }
                int MaHangSanPham = rs.getInt("idhangsanpham");
                ResultSet rsHSP = DAO.DAOSanPham.LayHangSanPham(MaHangSanPham);
                if (rsHSP.next()) {
                    obj[3] = rsHSP.getString("tenhang");
                }
                obj[4] = rs.getDouble("gianhap");
                obj[5] = rs.getDouble("giabanle");
                obj[6] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[7] = rs.getInt("tonkho");
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
                int MaKeSanPham = rs.getInt("idke");
                ResultSet rsKSP = DAO.DAOSanPham.LayKeSanPham(MaKeSanPham);
                if (rsKSP.next()) {
                    obj[10] = rsKSP.getString("tenke");
                }
                obj[11] = rs.getInt("idsanpham");

                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[12] = lb;
                String code = rs.getString("masanpham");
                JLabel lbl3 =  new JLabel();
                
                
             
                 String id = code;  
         
        byte []result = BarCode(id , 65, 30);

       lbl3.setIcon(new ImageIcon(result));
                
                
                
                obj[13] = lbl3;
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng Sản Phẩm", "Thông báo");
        }
    }

    public static class mytable implements TableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return (Component) value;

        }
    }

    public static DTO.DTONguoidung GetMaND(Integer MaND) {
        try {
            ResultSet rs = DAO.DAONguoiDung.LayNguoiDungTheoMa(MaND);
            if (rs.next()) {
                DTONguoidung nd = new DTONguoidung();
                nd.setIdNguoiDung(rs.getInt("idnguoidung"));
                nd.setIdLuong(rs.getInt("idluong"));
                nd.setTenNguoiDung(rs.getString("tennguoidung"));
                nd.setSoDienThoai(rs.getString("sodienthoai"));
                nd.setEmail(rs.getString("email"));
                nd.setGioiTinh(rs.getString("gioitinh"));
                nd.setNgaySinh(ChuyenDoi.GetNgay(rs.getDate("ngaysinh")));
                nd.setNgayVaoLam(ChuyenDoi.GetNgay(rs.getDate("ngayvaolam")));
                nd.setDiaChi(rs.getString("diachi"));
                nd.setCMND(rs.getString("cmnd"));
                nd.setTenDangNhap(rs.getString("tendangnhap"));
                nd.setMatKhau(rs.getString("matkhau"));
                nd.setAnhDaiDien(rs.getString("anhdaidien"));
                nd.setQuyen(rs.getInt("quyen"));
                nd.setTrangThai(rs.getInt("trangthai"));
                nd.setMoTa(rs.getString("mota"));
                return nd;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn từ bảng người dùng", "Thông báo");
        }
        
        return null;
    }
 

    public static DTO.DTOSanPham GetMaSP(Integer MaSP) {
        try {
            ResultSet rs = DAO.DAOSanPham.LaySanPhamTheoMa(MaSP);
            if (rs.next()) {
                DTO.DTOSanPham sp = new DTO.DTOSanPham();
                sp.setIDSanPham(rs.getInt("idsanpham"));
                sp.setTenSanPham(rs.getString("tensanpham"));
                sp.setNgayTao(ChuyenDoi.GetNgay(rs.getDate("ngaytao")));
                sp.setMaSanPham(rs.getString("masanpham"));
                sp.setMoTaSanPham(rs.getString("motasanpham"));
                sp.setGiaBanLe(rs.getDouble("giabanle"));
                sp.setGiaBanBuon(rs.getDouble("giabanbuon"));
                sp.setGiaNhap(rs.getDouble("gianhap"));
                sp.setKhoiLuong(rs.getInt("khoiluong"));
                sp.setDonViTinh(rs.getString("donvitinh"));
                sp.setTonKho(rs.getInt("tonkho"));
                sp.setIDLoaiSanPham(rs.getInt("idloaisanpham"));
                sp.setIDHangSanPham(rs.getInt("idhangsanpham"));
                sp.setAnhSanPham(rs.getBytes("anhsanpham"));
                sp.setIDSize(rs.getInt("idsizesanpham"));
                sp.setIDMauSanPham(rs.getInt("idmausanpham"));
                sp.setIDKe(rs.getInt("idke"));
                return sp;

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi truy vấn bảng sản phẩm", "Thông báo");
        }
        return null;
    }

    public static void DoDuLieucbbLoaiSanPham(JComboBox cbbLoaiSanPham) {
       ResultSet rs = DAO.DAOLoaiSanPham.LayLoaiSanPham("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbLoaiSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object idloaisanpham = rs.getString("idloaisanpham");
                Object tenloaisanpham = rs.getString("tenloaisanpham");
                MyCombobox mb = new MyCombobox(tenloaisanpham, idloaisanpham);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb loại sản phẩm", "Thông Báo");

        }
    }

    public static void ThemSize(DTOSize Size) {
        DAO.DAOSize.ThemSize(Size);
    }

    public static boolean KiemTraThemSize(String size, String mota) {
        if (size.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên size không được bỏ trống!"
                    + "\nVui lòng nhập lại size! ", "Thông báo");
            return false;
        }
        return true;
    }

    public static void ThemMau(DTOMauSanPham Mau) {
        DAO.DAOMauSanPham.ThemMau(Mau);
    }

    public static boolean KiemTraThemMau(String Mau, String Mota) {
        if (Mau.trim().equals("")) {
            ThongBaoCanhBao.ThongBao("Tên màu không được bỏ trống!"
                    + "\nVui lòng nhập lại màu! ", "Thông báo");
            return false;
        }
        return true;
    }

    public static void DoDuLieucbbHangSanPham(JComboBox cbbNhanSanPham) {
        ResultSet rs = DAO.DAOHangSanPham.LayHangSanPham("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbNhanSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdHangSanPham = rs.getString("idhangsanpham");
                Object TenHangSanPham = rs.getString("tenhang");
                MyCombobox mb = new MyCombobox(TenHangSanPham, IdHangSanPham);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Hãng sản phẩm", "Thông Báo");

        }
    }

    public static void DoDuLieucbbSizeSanPham(JComboBox cbbSizeSanPham) {
        ResultSet rs = DAO.DAOSize.LaySizeSanPham("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbSizeSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdSize = rs.getString("idsize");
                Object TenSize = rs.getString("tensize");
                MyCombobox mb = new MyCombobox(TenSize, IdSize);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Size sản phẩm", "Thông Báo");           
        }
    }

    public static void DoDuLieucbbMauSanPham(JComboBox cbbMauSanPham) {
        ResultSet rs = DAO.DAOMauSanPham.LayMauSanPham("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbMauSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdMau = rs.getString("idmausanpham");
                Object TenMau = rs.getString("tenmausanpham");
                MyCombobox mb = new MyCombobox(TenMau, IdMau);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Màu sản phẩm", "Thông Báo");
            
        }
    }

    public static void DoDuLieucbbKeSanPham(JComboBox cbbKeSanPham) {
        ResultSet rs = DAO.DAOKe.LayKe("");
        DefaultComboBoxModel cbbModel = (DefaultComboBoxModel) cbbKeSanPham.getModel();
        cbbModel.removeAllElements();
        try {
            while (rs.next()) {
                Object IdKe = rs.getString("idke");
                Object TenKe = rs.getString("tenke");
                MyCombobox mb = new MyCombobox(TenKe, IdKe);
                cbbModel.addElement(mb);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu cbb Kệ sản phẩm", "Thông Báo");
        }
    }

    public static void HienThiSanPhamLoc(JTable tbl, String idHangSanPham, String idLoaiSanPham, String idSizeSanPham, String idMauSanPham, String idKe, String NgayTao) {
        ResultSet rs = DAO.DAOSanPham.LaySanPhamLoc(idHangSanPham, idLoaiSanPham, idSizeSanPham, idMauSanPham, idKe, NgayTao);
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("masanpham");
                obj[1] = rs.getString("tensanpham");
                ResultSet rsLoaiSP = DAO.DAOLoaiSanPham.LayLoaiSanPham(rs.getString("idloaisanpham"));
                if (rsLoaiSP.next()) {
                    obj[2] = rsLoaiSP.getString("tenloaisanpham");
                }
                ResultSet rsHang = DAO.DAOHangSanPham.LayHangSanPham(rs.getString("idhangsanpham"));
                if (rsHang.next()) {
                    obj[3] = rsHang.getString("tenhang");
                }
                obj[4] = rs.getDouble("gianhap");
                obj[5] = rs.getDouble("giabanle");
                obj[6] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[7] = rs.getInt("tonkho");
                ResultSet rsSize = DAO.DAOSize.LaySizeSanPham(rs.getString("idsizesanpham"));
                if (rsSize.next()) {
                    obj[8] = rsSize.getString("tensize");
                }
                ResultSet rsidmausanpham = DAO.DAOMauSanPham.LayMauSanPham(rs.getString("idmausanpham"));
                if (rsidmausanpham.next()) {
                    obj[9] = rsidmausanpham.getString("tenmausanpham");
                }
                ResultSet rsKe = DAO.DAOKe.LayKe(rs.getString("idke"));
                if (rsKe.next()) {
                    obj[10] = rsKe.getString("tenke");
                }
                obj[11] = rs.getInt("idsanpham");
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng Sản Phẩm", "Thông báo");
        }

    }

    public static boolean ThemSP(String TenSP, String NgayTao, String MoTa,
            String MaSP, String GiaBanLe, String GiaBanBuon, String GiaNhap,
            String KhoiLuong, String DonViTinh,
            int IDLoaiSP, int IDHangSP, String ThuocTinhKhachHang,
            int IDSize, int IDMau, int IDKe) {

        sp.setTenSanPham(TenSP);
        sp.setNgayTao(NgayTao);
        sp.setMoTaSanPham(MoTa);
        sp.setMaSanPham(MaSP);
        sp.setGiaBanLe(Double.parseDouble(GiaBanLe));
        sp.setGiaBanBuon(Double.parseDouble(GiaBanBuon));
        sp.setGiaNhap(Double.parseDouble(GiaNhap));
        sp.setKhoiLuong(Integer.parseInt(KhoiLuong));
        sp.setDonViTinh(DonViTinh);
        sp.setIDLoaiSanPham(IDLoaiSP);
        sp.setIDHangSanPham(IDHangSP);
        sp.setThuocTinhKhachHang(ThuocTinhKhachHang);
        sp.setIDSize(IDSize);
        sp.setIDMauSanPham(IDMau);
        sp.setIDKe(IDKe);
        DAO.DAOSanPham.ThemSanPham(sp);
        return true;

    }

    public static void HienThiSanPhamTimKiem(JTable tbl, String timKiem) {
        ResultSet rs = DAO.DAOSanPham.LaySanPhamTimKiem(timKiem);

        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[13];
        try {
            while (rs.next()) {
                obj[0] = rs.getString("masanpham");
                obj[1] = rs.getString("tensanpham");
                ResultSet rsLoaiSP = DAO.DAOLoaiSanPham.LayLoaiSanPham(rs.getString("idloaisanpham"));
                if (rsLoaiSP.next()) {
                    obj[2] = rsLoaiSP.getString("tenloaisanpham");
                }
                ResultSet rsHang = DAO.DAOHangSanPham.LayHangSanPham(rs.getString("idhangsanpham"));
                if (rsHang.next()) {
                    obj[3] = rsHang.getString("tenhang");
                }
                obj[4] = rs.getDouble("gianhap");
                obj[5] = rs.getDouble("giabanle");
                obj[6] = BLL.ChuyenDoi.GetNgay(rs.getDate("ngaytao"));
                obj[7] = rs.getInt("tonkho");
                ResultSet rsSize = DAO.DAOSize.LaySizeSanPham(rs.getString("idsizesanpham"));
                if (rsSize.next()) {
                    obj[8] = rsSize.getString("tensize");
                }
                ResultSet rsidmausanpham = DAO.DAOMauSanPham.LayMauSanPham(rs.getString("idmausanpham"));
                if (rsidmausanpham.next()) {
                    obj[9] = rsidmausanpham.getString("tenmausanpham");
                }
                ResultSet rsKe = DAO.DAOKe.LayKe(rs.getString("idke"));
                if (rsKe.next()) {
                    obj[10] = rsKe.getString("tenke");
                }
                obj[11] = rs.getInt("idsanpham");
                JLabel lb = new JLabel();

                ImageIcon imageIcon = new ImageIcon(new ImageIcon(rs.getBytes("anhsanpham")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                lb.setIcon(imageIcon);
                obj[12] = lb;
                tbModel.addRow(obj);
            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng Sản Phẩm", "Thông báo");
        }
    }

    public static boolean SuaSP(String TenSP, String NgayTao, String MoTa,
            String MaSP, String GiaBanLe, String GiaBanBuon, String GiaNhap,
            String KhoiLuong, String DonViTinh, String TonKho,
            int IDLoaiSP, int IDHangSP, String ThuocTinhKhachHang,
            int IDSize, int IDMau, int IDKe , int IDSanPham ) {

        sp.setTenSanPham(TenSP);
        sp.setNgayTao(NgayTao);
        sp.setMoTaSanPham(MoTa);
        sp.setMaSanPham(MaSP);
        sp.setGiaBanLe(Double.parseDouble(GiaBanLe));
        sp.setGiaBanBuon(Double.parseDouble(GiaBanBuon));
        sp.setGiaNhap(Double.parseDouble(GiaNhap));
        sp.setKhoiLuong(Integer.parseInt(KhoiLuong));
        sp.setDonViTinh(DonViTinh);
        sp.setTonKho(Integer.parseInt(TonKho));
        sp.setIDLoaiSanPham(IDLoaiSP);
        sp.setIDHangSanPham(IDHangSP);
        sp.setThuocTinhKhachHang(ThuocTinhKhachHang);
        sp.setIDSize(IDSize);
        sp.setIDMauSanPham(IDMau);
        sp.setIDKe(IDKe);
        sp.setIDSanPham(IDSanPham);
        DAO.DAOSanPham.suaSP(sp);
        return true;
    }

    public static void HienThiSize(JTable tbl) {

        ResultSet rs = DAO.DAOSize.HienThiSizeSanPham();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[3];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idsize");
                obj[1] = rs.getString("tensize");
                obj[2] = rs.getString("mota");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng size", "Thông báo");
        }

    }

    public static void HienThiMau(JTable tbl) {

        ResultSet rs = DAO.DAOMauSanPham.HienThiMauSanPham();
        DefaultTableModel tbModel = (DefaultTableModel) tbl.getModel();
        tbModel.setRowCount(0);
        Object obj[] = new Object[3];
        try {
            while (rs.next()) {
                obj[0] = rs.getInt("idmausanpham");
                obj[1] = rs.getString("tenmausanpham");
                obj[2] = rs.getString("mota");
                tbModel.addRow(obj);

            }
        } catch (SQLException ex) {
            ThongBaoCanhBao.ThongBao("Lỗi đổ dữ liệu từ bảng màu", "Thông báo");
        }
    }
}
